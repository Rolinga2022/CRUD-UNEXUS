package com.UNEXUS.CRUD.service;


import com.UNEXUS.CRUD.entity.Cliente;
import com.UNEXUS.CRUD.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    //Crear un cliente con direccion matriz
    public Cliente crear (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    //Mostrar una lista de clientes
    public List<Cliente> mostrar () {
        return clienteRepository.findAll();
    }
    
    //Eliminar un cliente (por id)
    public void eliminar (Long id_cliente){
        clienteRepository.deleteById(id_cliente);
    }
    
    //Editar un cliente seleccionado por id (no lo use)
    public Cliente editar (Cliente cliente){
        return clienteRepository.save(cliente);
    }
    
    
    
    
    
}
