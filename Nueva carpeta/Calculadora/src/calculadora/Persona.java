/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.io.Serializable;

/**
 *
 * @author alma_
 */
public class Persona implements Serializable{
 
    
    private String nombre;

    public Persona() {
    }

    
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
           
}
