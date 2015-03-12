/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Services;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class Advertise extends Services{

    public String getLocation() {
        return Location; //si se pone en la pagina principal, o en un launcher de un juego
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public Advertise() {
    }

    public Advertise(String Location, Date StartDate, Date EndDate, String Rate) {
        super(StartDate, EndDate, Rate);
        this.Location = Location;
    }

   
    protected String Location;
    
}
