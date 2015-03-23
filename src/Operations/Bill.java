/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Colectives.Interns.Employee;
import java.util.Date;
import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "fechaPago", "descuento", "impuestos", "precioTotal", "condicionesDePago"})
public class Bill extends Operation {
    
            protected Date dataPayment;
            protected Float discount, taxes;
            protected double totalPrice;
            protected String payConditions;
            protected Boolean budget;

    public Bill() {
    }

    public Bill(Date dataPayment, Float discount, Float taxes, Double totalPrice, String payConditions, Boolean budget, int code, int type, Employee EmployeeGen, Date dataOpen, Date dataClose) {
        super(code, type, EmployeeGen, dataOpen, dataClose);
        this.dataPayment = dataPayment;
        this.discount = discount;
        this.taxes = taxes;
        this.totalPrice = totalPrice;
        this.payConditions = payConditions;
        this.budget = budget;
    }
    @XmlElement(name = "fechaPago") 
    public Date getDataPayment() {
        return dataPayment;
    }
    
    public void setDataPayment(Date dataPayment) {
        this.dataPayment = dataPayment;
    }
    @XmlElement(name = "descuento") 
    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
    @XmlElement(name = "impuestos") 
    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }
    @XmlElement(name = "precioTotal") 
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    @XmlElement(name = "condicionesDePago") 
    public String getPayConditions() {
        return payConditions;
    }

    public void setPayConditions(String payConditions) {
        this.payConditions = payConditions;
    }

    public Boolean getBudget() {
        return budget;
    }

    public void setBudget(Boolean budget) {
        this.budget = budget;
    }
             
}
