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
public class BillDetail extends BasicDetail{
   protected double price;
   protected String details;

    public BillDetail() {
    }

    public BillDetail(double price, String details, int amount, CommercialGood idResource) {
        super(amount, idResource);
        this.price = price;
        this.details = details;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

   
   
   
   
}
