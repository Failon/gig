/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

//import Colectives.StakeHolder;
//import GoodAndServices.ComercialGood;
import java.util.ArrayList;

/**
 *
 * @author devweb
 */
public class Provider extends Company {
    
    protected int typeProvider;
    protected String typeResource; //tipo de recurso que me da el proveedor
 //  protected ArrayList<ComercialGood> resources;
        //comercialGood es un abstracto de producto o servicio

    public int getTypeProvider() {
        return typeProvider;
    }

    public void setTypeProvider(int typeProvider) {
        this.typeProvider = typeProvider;
    }

    public String getTypeResource() {
        return typeResource;
    }

    public void setTypeResource(String typeResource) {
        this.typeResource = typeResource;
    }
    
    
    
    
    
}
