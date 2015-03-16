/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives;

import CheckData.Checking;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author devweb
 * @version la segona versió
 */
public class Person {
    
    protected String name, code, address, postalcode, city, country,email, type, bancCode, phone, comments;
    protected Date entryDate, outDate;
	public Person(String name, String code, String address, String postalcode,
			String city, String country, String email, String type,
			String bancCode, String phone, String comments, Date entryDate,
			Date outDate) {
		this.name = name;
		this.code = code;
		this.address = address;
		this.postalcode = postalcode;
		this.city = city;
		this.country = country;
		this.email = email;
		this.type = type;
		this.bancCode = bancCode;
		this.phone = phone;
		this.comments = comments;
		this.entryDate = entryDate;
		this.outDate = outDate;
	}
	public Person() {

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		if(Checking.CheckDNI(code)==0){ //si pasa el checkDNI lo guardo sino no.
			this.code = code;
		}	
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(Checking.CheckEmail(email)==0){//si pasa el checkemail lo guardo.
			this.email = email;
		}
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBancCode() {
		return bancCode;
	}
	public void setBancCode(String bancCode) {
		this.bancCode = bancCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		SimpleDateFormat mydateformat = new SimpleDateFormat("dd/MM/yyyy");//defino el formato de fecha
		String fecha_entrada = mydateformat.format(entryDate); //saco el string del formato de fecha definido anteriormente para entryDate.
		if(Checking.CheckDates(fecha_entrada)==0){ //si pasa el check lo guardo.
			this.entryDate = entryDate;
		}	
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		SimpleDateFormat mydateformat = new SimpleDateFormat("dd/MM/yyyy");//defino el formato de fecha
		String fecha_salida = mydateformat.format(outDate); //saco el string del formato de fecha definido anteriormente para outDate.
		if(Checking.CheckDates(fecha_salida)==0){ //si pasa el check lo guardo.
			this.outDate = outDate;	
		}		
	
	}
	
	
	
   

   


    
        
    
    
}
