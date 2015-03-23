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
@XmlType(propOrder = { "cantidad", "CG"})
public class BasicDetail{
    int amount;
    CommercialGood idResource;

    public BasicDetail(int amount, CommercialGood idResource) {
        this.amount = amount;
        this.idResource = idResource;
    }

    public BasicDetail() {
    }
    @XmlElement(name = "cantidad")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    @XmlElement(name = "CG")
    public CommercialGood getIdResource() {
        return idResource;
    }

    public void setIdResource(CommercialGood idResource) {
        this.idResource = idResource;
    }
    
    
    
    }

