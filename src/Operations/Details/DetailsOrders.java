/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.Details;
import GoodsandServices.CommercialGood;

/**
 *
 * @author devweb
 */
public class DetailsOrders extends BillDetail{
    protected int Received_units;

    public DetailsOrders() {
        
    }

    public DetailsOrders(int Received_units, double price, String details, int amount, CommercialGood idResource) {
        super(price, details, amount, idResource);
        this.Received_units = Received_units;
    }

    public int getReceived_units() {
        return Received_units;
    }

    public void setReceived_units(int Received_units) {
        this.Received_units = Received_units;
    }
        
   
}
