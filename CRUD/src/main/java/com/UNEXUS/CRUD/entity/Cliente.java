package com.UNEXUS.CRUD.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_cliente;
    
    private String tipo_identif;
    
    private long num_identif;
    
    private String nombre_y_apellido;
    
    private String email;
    
    private long celular;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    private List<DireccionCliente> direccionCliente;
    
    //constructor

    public Cliente() {
    }

    public Cliente(String tipo_identif, long num_identif, String nombre_y_apellido, String email, long celular, DireccionCliente direccionesCliente) {
        this.tipo_identif = tipo_identif;
        this.num_identif = num_identif;
        this.nombre_y_apellido = nombre_y_apellido;
        this.email = email;
        this.celular = celular;
        this.direccionCliente = (List<DireccionCliente>) direccionesCliente;
    }
    
    
    //Set and get

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_identif() {
        return tipo_identif;
    }

    public void setTipo_identif(String tipo_identif) {
        this.tipo_identif = tipo_identif;
    }

    public long getNum_identif() {
        return num_identif;
    }

    public void setNum_identif(long num_identif) {
        this.num_identif = num_identif;
    }

    public String getNombre_y_apellido() {
        return nombre_y_apellido;
    }

    public void setNombre_y_apellido(String nombre_y_apellido) {
        this.nombre_y_apellido = nombre_y_apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public DireccionCliente getDireccionCliente() {
        return (DireccionCliente) direccionCliente;
    }

    public void setDireccionCliente(DireccionCliente direccionCliente) {
        this.direccionCliente = (List<DireccionCliente>) direccionCliente;
    }
    
    
    
}
