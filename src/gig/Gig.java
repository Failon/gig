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
import GraficInterface.*;
import Operations.*;
import CheckData.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
public class Gig {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       TransportSale transporte1 = new TransportSale();
       TransportSale transporte2 = new TransportSale();
       TransportSale transporte3 = new TransportSale();
       TransportSale transporte4 = new TransportSale();
       
       transporte1.setCity("Barcelona");
       transporte1.setPlacetosend("Via Augusta");
       transporte1.setPostalcode("08830");
       transporte1.setCountry("Espanya");
 
       transporte2.setCity("Madrid");
       transporte2.setPlacetosend("Calle Castellon");
       transporte2.setPostalcode("54306");
       transporte2.setCountry("Espanya");
       
       transporte3.setCity("Zaragoza");
       transporte3.setPlacetosend("Calle del general");
       transporte3.setPostalcode("07659");
       transporte3.setCountry("Espanya");
       
       transporte4.setCity("Valencia");
       transporte4.setPlacetosend("Caloret");
       transporte4.setPostalcode("666");
       transporte4.setCountry("Espanya el pais de la patranya");
       
       ArrayList<TransportSale> transportes = new ArrayList<TransportSale>();
       transportes.add(transporte1);
       transportes.add(transporte2);
       transportes.add(transporte3);
       transportes.add(transporte4);
       
       String[] hojaruta = StockController.ManageTransportSales(transportes);
       
       for(int cont=0; cont < hojaruta.length;cont++){
    	   System.out.println(hojaruta[cont]);
    	   
       }
    }
    
}
