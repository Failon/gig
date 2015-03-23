/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import java.util.Date;

import Colectives.Person;
import Colectives.StakeHolder;

import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "fax", "sitioWeb", "CUIT", "nombreCorporativo", "contactos", "telefonosAdicionales", "datosCobro", "direccionEntrega", "codigoPostalEntrega", "ciudadEntrega", "paisEntrega", "codigoEmpresa", "descuento"})
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



    @XmlElement(name = "fax")
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    @XmlElement(name = "sitioWeb")
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
    @XmlElement(name = "CUIT")
    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }
    @XmlElement(name = "nombreCorporativo")
    public String getCorporateName() {
        return CorporateName;
    }

    public void setCorporateName(String CorporateName) {
        this.CorporateName = CorporateName;
    }
    @XmlElement(name = "contactos")
    public String[] getContacts() {
        return contacts;
    }

    public void setContacts(String[] contacts) {
        this.contacts = contacts;
    }
    @XmlElement(name = "telefonosAdicionales")
    public String[] getAdditionalsPhones() {
        return additionalsPhones;
    }

    public void setAdditionalsPhones(String[] additionalsPhones) {
        this.additionalsPhones = additionalsPhones;
    }
    @XmlElement(name = "datosCobro")
    public String[] getBillingInfo() {
        return billingInfo;
    }

    public void setBillingInfo(String[] billingInfo) {
        this.billingInfo = billingInfo;
    }
    @XmlElement(name = "codigoPostalEntrega")
    public String getDelivPostalcode() {
        return delivPostalcode;
    }
  
    public void setDelivPostalcode(String delivPostalcode) {
        this.delivPostalcode = delivPostalcode;
    }
    @XmlElement(name = "ciudadEntrega")
    public String getDelivCity() {
        return delivCity;
    }

    public void setDelivCity(String delivCity) {
        this.delivCity = delivCity;
    }
    @XmlElement(name = "paisEntrega")
    public String getDelivCountry() {
        return delivCountry;
    }

    public void setDelivCountry(String delivCountry) {
        this.delivCountry = delivCountry;
    }
    @XmlElement(name = "codigoEmpresa")
    public int getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(int CompanyCode) {
        this.CompanyCode = CompanyCode;
    }
    @XmlElement(name = "descuento")
    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    @XmlElement(name = "direccionEntrega")
	public String getDelivAddress() {
		return delivAddress;
	}

	public void setDelivAddress(String delivAddress) {
		this.delivAddress = delivAddress;
	}


	@Override
	public String getPostalCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPostalCode(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getdelivcountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setdelivcountry(String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getCorpName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCorpName(String cname) {
		// TODO Auto-generated method stub
		
	}
    
}
