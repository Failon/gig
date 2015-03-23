/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;
//import Colectives.StakeHolder;
//import GoodAndServices.ComercialGood;


/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "tipoProveedor", "tipoRecurso"})
public class Provider extends Company {
    
    protected int typeProvider;
    protected String typeResource; //tipo de recurso que me da el proveedor

    public Provider() {
    	
    }
      

    public Provider(String name, String code, String address,
			String postalcode, String city, String country, String email,
			String type, String bancCode, String phone, String comments,
			Date entryDate, Date outDate, String fax, String website,
			String cUIT, String corporateName, String[] contacts,
			String[] additionalsPhones, String[] billingInfo,
			String delivAddress, String delivPostalcode, String delivCity,
			String delivCountry, int companyCode, float discount,
			int typeProvider, String typeResource) {
		super(name, code, address, postalcode, city, country, email, type,
				bancCode, phone, comments, entryDate, outDate, fax, website,
				cUIT, corporateName, contacts, additionalsPhones, billingInfo,
				delivAddress, delivPostalcode, delivCity, delivCountry,
				companyCode, discount);
		this.typeProvider = typeProvider;
		this.typeResource = typeResource;
	}
    @XmlElement(name = "tipoProveedor")
	public int getTypeProvider() {
        return typeProvider;
    }

	public void setTypeProvider(int typeProvider) {
        this.typeProvider = typeProvider;
    }
	@XmlElement(name = "tipoRecurso")
    public String getTypeResource() {
        return typeResource;
    }

    public void setTypeResource(String typeResource) {
        this.typeResource = typeResource;
    }
                   
}
