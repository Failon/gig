/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import Colectives.Person;
import Colectives.StakeHolder;

/**
 *
 * @author devweb
 */
public class Company extends Person implements StakeHolder {
    
    protected String fax, website, CUIT, CorporateName, contacts[],
              additionalsPhones[], billingInfo[],delivAddress, delivPostalcode, delivCity, delivCountry;
    protected int CompanyCode;
    protected float discount;
    
    
    
    public String getCorpName(){
        return CorporateName;
    }
    
    public void setCorpName(String cname){
        CorporateName=cname;
    }
    

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public String getCorporateName() {
        return CorporateName;
    }

    public void setCorporateName(String CorporateName) {
        this.CorporateName = CorporateName;
    }

    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }

    public String[] getAdditionalsPhones() {
        return additionalsPhones;
    }

    public void setAdditionalsPhones(String[] additionalsPhones) {
        this.additionalsPhones = additionalsPhones;
    }

    public String[] getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(String[] billingInfo) {
        this.billingInfo = billingInfo;
    }

    public String getDelivPostalcode() {
        return delivPostalcode;
    }

    public void setDelivPostalcode(String delivPostalcode) {
        this.delivPostalcode = delivPostalcode;
    }

    public String getDelivCity() {
        return delivCity;
    }

    public void setDelivCity(String delivCity) {
        this.delivCity = delivCity;
    }

    public String getDelivCountry() {
        return delivCountry;
    }

    public void setDelivCountry(String delivCountry) {
        this.delivCountry = delivCountry;
    }

    public int getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(int CompanyCode) {
        this.CompanyCode = CompanyCode;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
