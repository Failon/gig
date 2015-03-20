/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import java.util.Date;

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
    
    public Company() {
		
	}
        
	public Company(String name, String code, String address, String postalcode,
			String city, String country, String email, String type,
			String bancCode, String phone, String comments, Date entryDate,
			Date outDate, String fax, String website, String cUIT,
			String corporateName, String[] contacts,
			String[] additionalsPhones, String[] billingInfo,
			String delivAddress, String delivPostalcode, String delivCity,
			String delivCountry, int companyCode, float discount) {
		super(name, code, address, postalcode, city, country, email, type,
				bancCode, phone, comments, entryDate, outDate);
		this.fax = fax;
		this.website = website;
		CUIT = cUIT;
		CorporateName = corporateName;
		this.contacts = contacts;
		this.additionalsPhones = additionalsPhones;
		this.billingInfo = billingInfo;
		this.delivAddress = delivAddress;
		this.delivPostalcode = delivPostalcode;
		this.delivCity = delivCity;
		this.delivCountry = delivCountry;
		CompanyCode = companyCode;
		this.discount = discount;
	}



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

	public String getDelivAddress() {
		return delivAddress;
	}

	public void setDelivAddress(String delivAddress) {
		this.delivAddress = delivAddress;
	}
    
}
