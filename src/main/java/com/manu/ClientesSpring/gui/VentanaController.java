package com.manu.ClientesSpring.gui;


import com.manu.ClientesSpring.entidad.Cliente;
import com.manu.ClientesSpring.servicios.ClienteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Set;

import static javax.swing.JOptionPane.showMessageDialog;
@Component
public class VentanaController implements ActionListener {
    //Variables para la ventana y manejador de datos
    @Autowired
    private final Ventana ventana;
    @Autowired
    private final ClienteServicioImpl datos;
    //Método para instanciar ventana y datos desde el main
    @Autowired
    public VentanaController(Ventana ventana, ClienteServicioImpl datos) {
        this.datos = datos;
        this.ventana = ventana;

        //Muestra los objetos en el campo de texto lateral
        buscarTodos();

        //Añadir todos los actionListeners(Código abajo del todo)
        addEventListeners(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String accion = e.getActionCommand();
        Cliente cliente = new Cliente();
        System.out.println(accion);
        switch (accion) {
            case "Nuevo":

                //Pone todos los campos en blanco
                resetInput();
                break;
            case "Guardar":
                //Asigna valores a un nuevo objeto


                if (compobarCampos()) {

                    cliente = asignarAtributos(cliente);

                    datos.save(cliente);
                    showMessageDialog(null, "Se ha guardado el Cliente");
                    buscarTodos();
                }
                break;

            case "Modificar":

                //Modifica objeto segun campo
                if (compobarCampos()) {

                    cliente = asignarAtributos(cliente);
                    datos.modificar(cliente);
                    showMessageDialog(null, "Se ha modificado la entrada ");
                }
                break;

            case "Eliminar":

                //elimina el objeto con campo especificado
                if (ventana.textFieldId.getText().isEmpty()) {
                    showMessageDialog(null, "Escriba el id que quiera eliminar en el campo id*");

                } else {
                    try {
                        datos.borrar(Long.parseLong(ventana.textFieldId.getText()));
                        showMessageDialog(null, "Se ha eliminado el Cliente");

                        buscarTodos();
                        resetInput();
                    } catch(NumberFormatException n) {
                        showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);

                    }

                }
                break;


            case "Buscar":
                // Busca Cliente en la base de datos segun el id
                if (!ventana.textFieldBuscar.getText().isEmpty()) {

                    try{

                        cliente = datos.findByIdCliente(Long.parseLong(ventana.textFieldBuscar.getText()));


                        if (cliente != null) {
                            cargar(cliente);
                        } else {
                            showMessageDialog(null, "No se ha encontrado ningún Cliente con este id");
                        }
                    } catch(NumberFormatException n) {
                        showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);
                    }

                } else {
                    showMessageDialog(null, "Escriba el id del Cliente que quiera buscar en el campo de arriba");

                }

                break;
        }
    }

    private boolean compobarCampos() {
        boolean procesoOk = true;
        if (ventana.textFieldId.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El id del Cliente no puede estar vacío");

        } else if (ventana.textFieldNombre.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El nombre del Cliente no puede estar vacío");

        } else if (ventana.textFieldApellidos.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "Los Apellidos del Cliente no puede estar vacío");

        } else if (ventana.textFieldCategory.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "La categoría del Cliente no puede estar vacío");

        } else if (ventana.textFieldLimiteCredito.getText().isEmpty()) {
            procesoOk = false;
            showMessageDialog(null, "El límite de crédito del Cliente no puede estar vacía");

        }  else if (ventana.getTextFieldCreationDate.getText().isEmpty()) {
        procesoOk = false;
        showMessageDialog(null, "la fecha de creacion del Cliente no puede estar vacía");

    }
        System.out.println(procesoOk);
        return procesoOk;
    }

    private void cargar(Cliente Cliente) {

        ventana.textFieldId.setText(Long.toString(Cliente.getId()));
        ventana.textFieldNombre.setText(Cliente.getNombre());
        ventana.textFieldApellidos.setText(Cliente.getApellidos());
        ventana.textFieldCategory.setText(Cliente.getCategory());
        ventana.textFieldLimiteCredito.setText(Float.toString(Cliente.getLimite_credito()));
        ventana.textFieldLimiteCredito.setText(new SimpleDateFormat("dd-MM-yyyy").format(Cliente.getCreationDate()));
    }

    private Cliente asignarAtributos(Cliente Cliente) {
        try  {
            Cliente.setNombre(ventana.textFieldNombre.getText());
            Cliente.setApellidos(ventana.textFieldApellidos.getText());
            Cliente.setCategory(ventana.textFieldCategory.getText());
//            try {
//                Cliente.setCreationDate(new LocalDateTimeType());
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
        }catch(NumberFormatException n) {
            showMessageDialog(null, "El id especificado es demasiado largo. Introduzca un número entre 0 y " + Long.MAX_VALUE);

        }
        return Cliente;
    }

    private void resetInput() {
        ventana.textFieldId.setText("");
        ventana.textFieldNombre.setText("");
        ventana.textFieldApellidos.setText("");
        ventana.textFieldCategory.setText("");
        ventana.textFieldLimiteCredito.setText("");
        ventana.textFieldBuscar.setText("");
    }

    private void addEventListeners(ActionListener listener) {

        ventana.nuevoButton.addActionListener(listener);
        ventana.guardarButton.addActionListener(listener);
        ventana.modificarButton.addActionListener(listener);
        ventana.eliminarButton.addActionListener(listener);
        ventana.buscarButton.addActionListener(listener);

    }

    private void buscarTodos() {
        Set<Cliente> clientes = datos.findAllClientes();
        ventana.buscarTextPane.setText(null);
        for (Cliente cliente :
                clientes) {
            if (ventana.buscarTextPane.getText().isEmpty()) {
                ventana.buscarTextPane.setText(Long.toString(cliente.getId()).replaceFirst("^0+(?!$)", "") + " - " + cliente.getNombre());
            } else {
                ventana.buscarTextPane.setText(ventana.buscarTextPane.getText() + "\n" + Long.toString(cliente.getId()).replaceFirst("^0+(?!$)", "") + " - " + cliente.getNombre());
            }

        }
    }
}
