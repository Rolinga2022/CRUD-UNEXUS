package com.UNEXUS.CRUD.service;


import com.UNEXUS.CRUD.entity.DireccionCliente;
import com.UNEXUS.CRUD.repository.DireccionClienteRepository;
import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DireccionClienteService {
    
    @Autowired
    private DireccionClienteRepository direccionClienteRepository;
        
    
    //Registrar una nueva direccion
    public DireccionCliente crear (DireccionCliente dir){
       return direccionClienteRepository.save(dir);
    }
    
    //Listar las direcciones adicionales
    public List<DireccionCliente> listarById (Long id_cliente){
        List<DireccionCliente> listaDirCli = new ArrayList<>();
        List<DireccionCliente> lista = direccionClienteRepository.findAll();
        for (int i=0; i<lista.size(); i++){
            if (lista.get(i).getCliente().getId_cliente()==id_cliente){
                listaDirCli.add(lista.get(i));
            }
        }
        return listaDirCli;
    } 
    
    //Para mostrar todas las direcciones
    public List<DireccionCliente> mostrarTot(){
        return direccionClienteRepository.findAll();
    }
}
