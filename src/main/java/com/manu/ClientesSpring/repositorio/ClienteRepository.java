package com.manu.ClientesSpring.repositorio;

import com.manu.ClientesSpring.entidad.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Long> {
    Set<Cliente> findAll();
    Cliente findByIdCliente(Long id);

}
