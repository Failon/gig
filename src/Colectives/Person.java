/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives;

import CheckData.Checking;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Pattern;

/**
 *
 * @author devweb
 * @version la segona versió
 */
public class Person {
    
    protected String name, code, address, postalcode, city, country,email, type, bancCode, phone, comments;
    protected Date entryDate, outDate;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Pattern patro = Pattern.compile("\\p{Upper}(\\p{Lower}+\\s?)");
        this.name = name;
    }

    public String getCode() {
        if (code!=null){
       return code;
        }else{
        return null;
        }
        
    }

    public void setCode(String code) {
        if (Checking.CheckDNI(code)==0){
        this.code = code;
        }else{
            System.out.println("DNI incorrecto");
            this.code = null;
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
         if (email!=null){
       return email;
        }else{
        return null;
        }
        
    }

    public void setEmail(String email) {
        if (Checking.CheckEmail(email)==0){
        this.email = email;
    }else{
            System.out.println("Email incorrecto");
            this.email = null;
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
       // if (phone!=null){
            return phone;
      //  }else{
       //    return null; 
      //  }
    }

    public void setPhone(String phone) {
      //  if (phone==null || phone.length()>9){
      //  this.phone = null;}
     //   else{
        
        this.phone = phone;
      //  }

       // this.phone = phone;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    
     public String getEntryDate(){
         if(entryDate == null){
         return null;
         }else{
         String eDate;
     DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
     eDate = formato.format(entryDate);
     return eDate;
         
         }
    
    }

    public void setEntryDate(String NDate){
    if (Checking.CheckDates(NDate)==0){
    try{
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        
        entryDate = formato.parse(NDate);
    }catch (ParseException ex){}
    }else{
        entryDate= null;
            }
    }
 
   
  public String getOutDate() {
          
        if(outDate == null){     
           
              return null;
        } else {
            String oDate;
         DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
       
        oDate = formato.format(outDate);
             return oDate;
        }    
    }
    public void setOutDate(String NDate) { 
        if (Checking.CheckDates(NDate)==0){
            try{
                DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);  
                outDate  =  formato.parse(NDate);  
                }catch (ParseException ex){
                
               }
          }else{
        outDate=null;
        }  
    }
    
  

   


    
        
    
    
}
