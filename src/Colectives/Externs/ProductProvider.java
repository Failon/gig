/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

/**
 *
 * @author devweb
 */
public class ProductProvider {
    //los representantes de juegos seran objetos de este tipo
    protected Integer stock;
    protected Float product_price;
    protected String TypeProduct;

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

    public ProductProvider() {
    }

    public ProductProvider(Integer stock, Float product_price, String TypeProduct) {
        this.stock = stock;
        this.product_price = product_price;
        this.TypeProduct = TypeProduct;
    }
}
