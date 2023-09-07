/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Logica;

import com.mycompany.historialcredito.Persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author EQUIPO
 */
public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    //Persona
    
    //Crear Persona
    public void crearPersona(Persona persona){
        controlPersis.crearPersona(persona);
    }
    //Eliminar Persona
    public void eliminarPersona(int id){
        controlPersis.eliminarPersona(id);
    }
    //Editar Persona
    public void editarPersona(Persona persona){
        controlPersis.editarPersona(persona);
    }
    //Buscar y Mostrar una Persona por el ID
    public Persona findPersona(int id){
        return controlPersis.findPersona(id);
    }
    //Busar y Mostrar todas las Personas
    public ArrayList<Persona> findPersonaEntities(){
        return controlPersis.findPersonaEntities();
    }
    
//Entidad Bancaria
    
    //Crear una Entidad Bancaria
    public void crearEntidad(EntidadBancaria entidad){
        controlPersis.crearEntidad(entidad);
    }
    //Eliminar una Entidad Bancaria
    public void eliminarEntidad(int id){
        controlPersis.eliminarEntidad(id);
    }
    //Editar una Entidad Bancaria
    public void editarEntidad(EntidadBancaria entidad){
        controlPersis.editarEntidad(entidad);
    }
    //Buscar y Mostrar una Entidad por ID
    public EntidadBancaria findEntidad(int id){
        return controlPersis.findEntidad(id);
    }
    //Buscar y Mostrar todas las Entidades Bancarias
    public ArrayList<EntidadBancaria> findEntidadEntities(){
        return controlPersis.findEntidadEntitites();
    }
    
//Tipo Credito
    
    //Crear un Tipo de Credito
    public void crearCredito(TipoCredito credito){
        controlPersis.crearCredito(credito);
    }
    //Eliminar un Tipo de Credito
    public void eliminarCredito(int id){
        controlPersis.eliminarCredito(id);
    }
    //Editar un Tipo de Credito
    public void editarCredito(TipoCredito credito){
        controlPersis.editarCredito(credito);
    }
    //Buscar y Mostrar un Tipo de Credito por Id
    public TipoCredito findCredito(int id){
        return controlPersis.findCredito(id);
    }
    //Buscar y Mostar Todos los Tipos de Creditos
    public LinkedList<TipoCredito> findCreditoEntities(){
        return controlPersis.findCreditoEntities();
    }
}
