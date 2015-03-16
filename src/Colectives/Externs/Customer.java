/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import CheckData.Checking;
import Colectives.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author devweb
 */
public class Customer extends Person implements StakeHolder {
    
    protected int customerCode;
    protected String billingInfo[], deliveryAddress[], delivpostalcode, delivcity, delivcountry;
    protected Date birthDate;
	public Customer(String name, String code, String address,
			String postalcode, String city, String country, String email,
			String type, String bancCode, String phone, String comments,
			Date entryDate, Date outDate, int customerCode,
			String[] billingInfo, String[] deliveryAddress,
			String delivpostalcode, String delivcity, String delivcountry,
			Date birthDate) {
		super(name, code, address, postalcode, city, country, email, type,
				bancCode, phone, comments, entryDate, outDate);
		this.customerCode = customerCode;
		this.billingInfo = billingInfo;
		this.deliveryAddress = deliveryAddress;
		this.delivpostalcode = delivpostalcode;
		this.delivcity = delivcity;
		this.delivcountry = delivcountry;
		this.birthDate = birthDate;
	}
	public Customer() {
		
	}
	public int getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(int customerCode) {
		this.customerCode = customerCode;
	}
	public String[] getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(String[] billingInfo) {
		this.billingInfo = billingInfo;
	}
	public String[] getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String[] deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getDelivpostalcode() {
		return delivpostalcode;
	}
	public void setDelivpostalcode(String delivpostalcode) {
		this.delivpostalcode = delivpostalcode;
	}
	public String getDelivcity() {
		return delivcity;
	}
	public void setDelivcity(String delivcity) {
		this.delivcity = delivcity;
	}
	public String getDelivcountry() {
		return delivcountry;
	}
	public void setDelivcountry(String delivcountry) {
		this.delivcountry = delivcountry;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		SimpleDateFormat mydateformat = new SimpleDateFormat("dd/MM/yyyy");//defino el formato de fecha
		String fecha_nacimiento = mydateformat.format(birthDate); //saco el string del formato de fecha definido anteriormente para outDate.
		if(Checking.CheckDates(fecha_nacimiento)==0){ //si pasa el check lo guardo.
			this.birthDate = birthDate;
		}	
		
	}  
   
}

   
    
    
   
    
    
    

