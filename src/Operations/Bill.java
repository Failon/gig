/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Colectives.Interns.Employee;
import java.util.Date;

/**
 *
 * @author devweb
 */
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

    public Date getDataPayment() {
        return dataPayment;
    }

    public void setDataPayment(Date dataPayment) {
        this.dataPayment = dataPayment;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

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
