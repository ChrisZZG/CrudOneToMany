/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.historialcredito.Persistencia;

import com.mycompany.historialcredito.Logica.EntidadBancaria;
import com.mycompany.historialcredito.Logica.Persona;
import com.mycompany.historialcredito.Logica.TipoCredito;
import com.mycompany.historialcredito.Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author EQUIPO
 */
public class ControladoraPersistencia {
    
//Persona
    PersonaJpaController persoJpa = new PersonaJpaController();
    //Crear Persona
    public void crearPersona(Persona persona){
        persoJpa.create(persona);
    }
    //Eliminar Persona
    public void eliminarPersona(int id){
        try {
            persoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Editar Persona
    public void editarPersona(Persona persona){
        try {
            persoJpa.edit(persona);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Buscar y Mostrar una Persona por el ID
    public Persona findPersona(int id){
        return persoJpa.findPersona(id);
    }
    //Busar y Mostrar todas las Personas
    public ArrayList<Persona> findPersonaEntities(){
        List<Persona> listaPersonas = persoJpa.findPersonaEntities();
        ArrayList<Persona> arrayPersonas = new ArrayList<Persona> (listaPersonas);
        return arrayPersonas;
    }
    
//Entidad Bancaria
    EntidadBancariaJpaController entidadJpa = new EntidadBancariaJpaController();
    //Crear una Entidad Bancaria
    public void crearEntidad(EntidadBancaria entidad){
        entidadJpa.create(entidad);
    }
    //Eliminar una Entidad Bancaria
    public void eliminarEntidad(int id){
        try {
            entidadJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Editar una Entidad Bancaria
    public void editarEntidad(EntidadBancaria entidad){
        try {
            entidadJpa.edit(entidad);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Buscar y Mostrar una Entidad por ID
    public EntidadBancaria findEntidad(int id){
        return entidadJpa.findEntidadBancaria(id);
    }
    //Buscar y Mostrar todas las Entidades Bancarias
    public ArrayList<EntidadBancaria> findEntidadEntitites(){
        List<EntidadBancaria> listaEntidades = entidadJpa.findEntidadBancariaEntities();
        ArrayList<EntidadBancaria> arrayEntidades = new ArrayList<EntidadBancaria> (listaEntidades);
        return arrayEntidades;
    }
    
    
//Tipo Credito
  TipoCreditoJpaController creditoJpa = new TipoCreditoJpaController();  
    //Crear un Tipo de Credito
  public void crearCredito(TipoCredito credito){
      creditoJpa.create(credito);
  }
    //Eliminar un Tipo de Credito
  public void eliminarCredito(int id){
        try {
            creditoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    //Editar un Tipo de Credito
  public void editarCredito(TipoCredito credito){
        try {
            creditoJpa.edit(credito);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    //Buscar y Mostrar un Tipo de Credito por Id
  public TipoCredito findCredito(int id){
      return creditoJpa.findTipoCredito(id);
  }
    //Buscar y Mostar Todos los Tipos de Creditos
  public LinkedList<TipoCredito> findCreditoEntities(){
      List<TipoCredito> listaCreditos = creditoJpa.findTipoCreditoEntities();
      LinkedList<TipoCredito> linkedCreditos = new LinkedList<TipoCredito> (listaCreditos);
      return linkedCreditos;
  }
}
