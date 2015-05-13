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
    	prueba.open("gig", 0);
    	String[] campos = {"code", "name", "description"};
    	String[] values = {"4", "fifa", "juego de futbol"};
    	ArrayList<VideoGames> VideoArray = new ArrayList<VideoGames>();
    	VideoGames juego = new VideoGames();
    	juego.setName("Batman Arkham city");
    	juego.setCategory("Arcade");
    	juego.setPEGI(14);
    	juego.setEdition("Collection");
    	juego.setIndexRating(5);
    	juego.setInternalComments("wapo wapo");
    	VideoArray.add(juego);
    	//Insert
    	int error = prueba.exportdades(VideoArray, "videogames", 1);
    	System.out.println(error);
    	
    	
    	/*Seleccion
    	String query = "code;price;PEGI;edition;name@videogames@code;1";
    	
    	 error = prueba.importdades(VideoArray, query);
    	System.out.println(error);
    	System.out.println(VideoArray.get(0).getEdition());
    	System.out.println(VideoArray.get(0).getPrice());
    	System.out.println(VideoArray.get(0).getPEGI());
    	System.out.println(VideoArray.get(0).getName());
    	error = prueba.close("gig");
    	System.out.println(error);*/
    }
    
}
