/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gig;

/**
 *
 * @author m3daw
 */
import IODades.File.DataFile;
import Operations.*;
import CheckData.*;
import Colectives.Externs.User;

import java.util.ArrayList;
public class Gig {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	DataFile prueba = new DataFile();
    	int i = 1;
    	ArrayList<User> usuarios = new ArrayList<User>();
    	
    	User usuario1 = new User();
    	User usuario2 = new User();
    	
    	usuario1.setNick("piter");
    	usuario1.setEmail("hola@hola.com");
    	
    }
    
}
