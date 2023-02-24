package com.UNEXUS.CRUD.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "direccionCliente")
public class DireccionCliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_direccion;
    
    private String provincia;
    
    private String ciudad;
    
    private String direccion;
    
    private boolean es_matriz;
    
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")//este es el nombre que utilizo en el json
    private Cliente cliente; 
    
    //Constructor
    public DireccionCliente() {
    }

    public DireccionCliente(String provincia, String ciudad, String direccion, boolean es_matriz, Cliente cliente) {
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.es_matriz = es_matriz;
        this.cliente = cliente;
    }
    
    //Get and Set
    public long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(int id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEs_matriz() {
        return es_matriz;
    }

    public void setEs_matriz(boolean es_matriz) {
        this.es_matriz = es_matriz;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
