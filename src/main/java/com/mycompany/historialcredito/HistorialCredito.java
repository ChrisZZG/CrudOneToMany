/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.historialcredito;

import com.mycompany.historialcredito.Logica.Controladora;
import com.mycompany.historialcredito.Logica.EntidadBancaria;
import com.mycompany.historialcredito.Logica.Persona;
import com.mycompany.historialcredito.Logica.TipoCredito;
import java.util.LinkedList;

/**
 *
 * @author EQUIPO
 */
public class HistorialCredito {

    public static void main(String[] args) {
        //Instancia Controladora
        Controladora control = new Controladora();
        //Nivel Logica
        //Crear LinkedList para los Tipos de Credito
        LinkedList<TipoCredito> listaCreditos = new LinkedList<TipoCredito>();
        //Nivel Logica
        //Crear una Entidad Bancaria
        EntidadBancaria entidadBanc = new EntidadBancaria(1, "Banco Nacion", listaCreditos);
        //Nivel Base Datos
        //Cargar la Entidad Bancaria
        control.crearEntidad(entidadBanc);
        //Nivel Logico
        //Crear Los Tipos de Credito
        TipoCredito credito1 = new TipoCredito(1, "Habitacional", entidadBanc);
        TipoCredito credito2 = new TipoCredito(2, "Automotriz", entidadBanc);
        //Nivel BaseDatos
        //Cargar los Tipos de Credito
        control.crearCredito(credito1);
        control.crearCredito(credito2);
        //Nivel Logico
        //Asignar a la LinkedList los tipos de Credito
        listaCreditos.add(credito1);
        listaCreditos.add(credito2);
        //Nivel Logico
        //Modificar la Entidad Bancaria con los Tipos de Credito
        entidadBanc.setTipoCredito(listaCreditos);
        //Nivel Base Datos
        //Editar la Entidad Bancaria
        control.editarEntidad(entidadBanc);
        //Nivel Logico
        //Crear a la Persona
        Persona perso1 = new Persona(1, "Mowgly", "Jey", entidadBanc);
        //Nivel Base de Datos
        //Cargar a la Persona
        control.crearPersona(perso1);
        
        
        
    }
}
