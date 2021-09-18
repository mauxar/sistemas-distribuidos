/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.io.Serializable;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mauag
 */

public class invertirCade {
    public static void main(String[] args){
        Funcionesarchivo fa=new Funcionesarchivo();
        Persona obj= new Persona();
        String h = obj.getNombre();
        char []invertir=h.toCharArray();
        int cont;
        for(cont=h.length()-1;cont>=0;cont--){
            System.out.print(""+invertir[cont]);
        }
        System.out.print("\n"+h);
    } 

   
}
