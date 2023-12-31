/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author EQUIPO
 */
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private String nombre;
    private String apellido;
    @OneToOne
    private EntidadBancaria entidadBancaria;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, EntidadBancaria entidadBancaria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.entidadBancaria = entidadBancaria;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public EntidadBancaria getEntidadBancaria() {
        return entidadBancaria;
    }

    public void setEntidadBancaria(EntidadBancaria entidadBancaria) {
        this.entidadBancaria = entidadBancaria;
    }
    
    
}
