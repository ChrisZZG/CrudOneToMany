/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Logica;

import java.io.Serializable;
import java.util.LinkedList;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author EQUIPO
 */
@Entity
public class EntidadBancaria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    @OneToMany(mappedBy = "entidadBancaria")
    private LinkedList<TipoCredito> tipoCredito;

    public EntidadBancaria() {
    }

    public EntidadBancaria(int id, String nombre, LinkedList<TipoCredito> tipoCredito) {
        this.id = id;
        this.nombre = nombre;
        this.tipoCredito = tipoCredito;
    }

   

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<TipoCredito> getTipoCredito() {
        return tipoCredito;
    }

    public void setTipoCredito(LinkedList<TipoCredito> tipoCredito) {
        this.tipoCredito = tipoCredito;
    }

   
    
    
    
}
