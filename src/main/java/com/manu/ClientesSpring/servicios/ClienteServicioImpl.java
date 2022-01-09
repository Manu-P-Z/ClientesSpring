package com.manu.ClientesSpring.servicios;

import com.manu.ClientesSpring.entidad.Cliente;
import com.manu.ClientesSpring.repositorio.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ClienteServicioImpl implements ClienteServicio {


    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public Set<Cliente> findAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findByIdCliente(Long id) {
        return clienteRepository.findByIdCliente(id);
    }

    @Override
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    public void modificar(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getId()))
            clienteRepository.delete(findByIdCliente(cliente.getId()));
        clienteRepository.save(cliente);

    }

    @Override
    public void borrar(Long idCliente) {
        if (clienteRepository.existsById(idCliente))
            clienteRepository.delete(findByIdCliente(idCliente));
    }

}


