/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import CheckData.Checking;
import Colectives.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author devweb
 */
public class Customer extends Person implements StakeHolder {
    
    protected int customerCode;
    protected String billingInfo[], deliveryAddress[], delivpostalcode, delivcity, delivcountry;
    protected Date birthDate;

    
    
    public String getCorpName(){
    return name;
    }
    
    
    public void setCorpName(String cname){
        name=cname;
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

     public String getBirthDate(){
         
          if(birthDate == null){     
           
              return null;
        } else {
            String bDate;
         DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
       
        bDate = formato.format(birthDate);
             return bDate;
        }    
    }
         
         
   

    public void setBirthDate(String NDate){
    if (Checking.CheckDates(NDate)==0){
            try{
                DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);  
                birthDate  =  formato.parse(NDate);  
                }catch (ParseException ex){
                
               }
          }else{
        birthDate=null;
        }  
    }
    }

   
    
    
   
    
    
    

