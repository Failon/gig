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
@XmlType(propOrder = { "unidadesRecividas"})
public class DetailsOrders extends BillDetail{
    protected int Received_units;

    public DetailsOrders() {
        
    }

    public DetailsOrders(int Received_units, double price, String details, int amount, CommercialGood idResource) {
        super(price, details, amount, idResource);
        this.Received_units = Received_units;
    }
    @XmlElement(name = "unidadesRecividas")
    public int getReceived_units() {
        return Received_units;
    }

    public void setReceived_units(int Received_units) {
        this.Received_units = Received_units;
    }
        
   
}
