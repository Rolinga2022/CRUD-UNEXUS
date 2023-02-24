package com.UNEXUS.CRUD.controller;


import com.UNEXUS.CRUD.entity.Cliente;
import com.UNEXUS.CRUD.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    
    //Crear un nuevo cliente con direccion matriz (no debe existir otro cliente con el mimso DNI)
    @PostMapping("/clientes/crear")
    public Cliente nuevoCliente (@RequestBody Cliente cliente){
        Cliente clienteAgregado = new Cliente();
        List<Cliente> listaTotal = clienteService.mostrar();
        boolean ref=true;
        for (int i=0; i<listaTotal.size(); i++){
            if(listaTotal.get(i).getNum_identif()== cliente.getNum_identif()){
                ref=false;
            }            
        }
        if(ref){
            System.out.println("El cliente fue agregado");
            clienteAgregado =  clienteService.crear(cliente);
        } else {
            System.out.println("El cliente ya existe");
        }
        return clienteAgregado;
    }
    
    
    
    //Eliminar un cliente enviado por id
    @DeleteMapping("clientes/borrar/{id_cliente}")
    public void eliminarCliente (@PathVariable Long id_cliente){
        clienteService.eliminar(id_cliente);
    }
    
    
    
    //Editar un cliente
    @PutMapping("clientes/editar")
    public Cliente editarCliente (Cliente cliente){
        Cliente clienteAModif = new Cliente();
        List<Cliente> listaTotal = clienteService.mostrar();
        for (int i=0; i<listaTotal.size(); i++){
            if(listaTotal.get(i).getId_cliente()== cliente.getId_cliente() && listaTotal.get(i).getNum_identif()!= cliente.getNum_identif() ){
                listaTotal.get(i).setCelular(cliente.getCelular());
                listaTotal.get(i).setEmail(cliente.getEmail());
                listaTotal.get(i).setNombre_y_apellido(cliente.getNombre_y_apellido());
                listaTotal.get(i).setNum_identif(cliente.getNum_identif());
                listaTotal.get(i).setTipo_identif(cliente.getTipo_identif());
                listaTotal.get(i).setDireccionCliente(cliente.getDireccionCliente());
                clienteAModif = cliente;
                System.out.println("Fue posible modificar");
            } else {
                System.out.println("No es posible modificar");
            } 
        }
        return clienteAModif;
    }
    
    //Mostrar un cliente (por num de identif)
    @GetMapping("clientes/mostrar/{num_identif}")
    public Cliente obtenerCliente (Long num_identif){
        Cliente clienteObtenido = new Cliente();
        List<Cliente> listaTot = clienteService.mostrar();
        List<Cliente> listaReduc = new ArrayList<>();
        
        for (int i=0; i<listaTot.size(); i++){
            if(listaTot.get(i).getNum_identif()==num_identif){
                listaReduc.add(listaTot.get(i));
            }
        }
        for (int i=0; i<listaReduc.size(); i++){
            if(listaReduc.get(i).getDireccionCliente().isEs_matriz()==true){
                clienteObtenido = listaReduc.get(i);
            }
        }
        return clienteObtenido;
    }
    
      
}
