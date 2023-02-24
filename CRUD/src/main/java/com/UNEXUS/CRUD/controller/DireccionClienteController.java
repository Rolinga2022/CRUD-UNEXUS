package com.UNEXUS.CRUD.controller;

import com.UNEXUS.CRUD.entity.DireccionCliente;
import com.UNEXUS.CRUD.service.DireccionClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DireccionClienteController {
    
    @Autowired
    private DireccionClienteService direccionClienteService;
    
   
    //REGISTRAR/CREAR DIRECCION DE UN CLIENTE
    @PostMapping("/direccion/registrar")
    public DireccionCliente registrarDireccion (@RequestBody DireccionCliente direccion) {
        DireccionCliente nuevoRegistro = direccionClienteService.crear(direccion);
        System.out.println("Ingreso exitoso");
        return nuevoRegistro;
    }
    
    
    //Mostrar las direcciones de un cliente(por id)
    @GetMapping("direcciones/mostrar/{id}")
    public List<DireccionCliente> mostrarDir (@PathVariable Long id_cliente){
        List<DireccionCliente> listaTotal = direccionClienteService.mostrarTot();
        List<DireccionCliente> listaById = new ArrayList<>();
        for (int i=0; i<listaTotal.size(); i++){
            if(listaTotal.get(i).getCliente().getId_cliente()==id_cliente){
                listaById.add(listaTotal.get(i));
            }
        }
        return listaById;
    }
    
    
    
    
    
    
    
        
}
