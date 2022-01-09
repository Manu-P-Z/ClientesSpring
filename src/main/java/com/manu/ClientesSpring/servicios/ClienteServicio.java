package com.manu.ClientesSpring.servicios;

import com.manu.ClientesSpring.entidad.Cliente;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface ClienteServicio {
    Set<Cliente> findAllClientes();
    Cliente findByIdCliente(Long id);
    void save(Cliente cliente);
    void modificar(Cliente cliente);
    void borrar(Long idCLiente);
}
