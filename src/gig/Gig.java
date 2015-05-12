/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gig;

import java.util.ArrayList;

import CommercialGood.Products.VideoGames;
import IODades.DB.JDBCAdapters.gigmysql;

/**
 *
 * @author m3daw
 */

public class Gig {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    	gigmysql prueba = new gigmysql();
    	
    	prueba.setHost("localhost");
    	prueba.setUser("root");
    	prueba.setPassword("");
    	prueba.setDatabase("gig");
    	prueba.setConnect();
    	String[] campos = {"code", "name", "description"};
    	String[] values = {"4", "fifa", "juego de futbol"};
    	ArrayList<VideoGames> VideoArray = new ArrayList<VideoGames>();
    	VideoGames juego = new VideoGames();
    	VideoArray.add(juego);
    	String query = "edition;name@videogames@code;1";
    	
    	int error = prueba.importdades(VideoArray, query);
    	System.out.println(error);
    	/*int error = prueba.Select("videogames", campos, "code", "2");
    	System.out.println(error);
    	System.out.println("-------");
    	error = prueba.Insert("videogames", campos, values);
    	System.out.println(error);
    	error = prueba.Update("videogames", campos, values, "code", "2");
    	System.out.println(error);
    	System.out.println("-------");
    	int error = prueba.Select("videogames", campos, "code", "4");
    	System.out.println(error);
    	System.out.println("-------");
    	int error = prueba.Select("videogames", campos, null , "4");
    	System.out.println(error);
    	System.out.println("-------");
    	/*
    	error = prueba.Delete("videogames", "code", "4");
    	System.out.println(error);
    	System.out.println("-------");
    	error = prueba.Select("videogames", campos, "code", "4");
    	System.out.println(error);
    	System.out.println("-------");*/
    	
    }
    
}
