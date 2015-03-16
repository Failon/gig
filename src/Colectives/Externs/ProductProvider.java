/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class ProductProvider extends Provider{
    //los representantes de juegos seran objetos de este tipo
    protected Integer stock;
    protected Float product_price;
    protected String TypeProduct;

    
    public ProductProvider() {
		super();
	}

	public ProductProvider(String name, String code, String address,
			String postalcode, String city, String country, String email,
			String type, String bancCode, String phone, String comments,
			Date entryDate, Date outDate, String fax, String website,
			String cUIT, String corporateName, String[] contacts,
			String[] additionalsPhones, String[] billingInfo,
			String delivAddress, String delivPostalcode, String delivCity,
			String delivCountry, int companyCode, float discount,
			int typeProvider, String typeResource, Integer stock,
			Float product_price, String typeProduct) {
		super(name, code, address, postalcode, city, country, email, type,
				bancCode, phone, comments, entryDate, outDate, fax, website,
				cUIT, corporateName, contacts, additionalsPhones, billingInfo,
				delivAddress, delivPostalcode, delivCity, delivCountry,
				companyCode, discount, typeProvider, typeResource);
		this.stock = stock;
		this.product_price = product_price;
		TypeProduct = typeProduct;
	}


	public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(Float product_price) {
        this.product_price = product_price;
    }

    public String getTypeProduct() {
        return TypeProduct;
    }

    public void setTypeProduct(String TypeProduct) {
        this.TypeProduct = TypeProduct;
    }

    
}
