/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations.Details;

import GoodsandServices.CommercialGood;
import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "precio","detalles"})
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
    @XmlElement(name = "precio")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    @XmlElement(name = "detalles")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

   
   
   
   
}
