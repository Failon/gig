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
public class BasicDetail{
    int amount;
    CommercialGood idResource;

    public BasicDetail(int amount, CommercialGood idResource) {
        this.amount = amount;
        this.idResource = idResource;
    }

    public BasicDetail() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public CommercialGood getIdResource() {
        return idResource;
    }

    public void setIdResource(CommercialGood idResource) {
        this.idResource = idResource;
    }
    
    
    
    }

