/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Products;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class PcComponent extends Products {
    protected String Model, Dimensions;
    protected float Weight;

    public PcComponent(String Model, String Dimensions, float Weight, float lenght, float weigth, float width, float high, float indexRating, String manufacturer, String model, String series, String content, String reviews, Date releaseDate, String Name, String Description, String Category, String InternalComments, float Price, int Code) {
        super(lenght, weigth, width, high, indexRating, manufacturer, model, series, content, reviews, releaseDate, Name, Description, Category, InternalComments, Price, Code);
        this.Model = Model;
        this.Dimensions = Dimensions;
        this.Weight = Weight;
    }

    public PcComponent() {
    }

    public String getDimensions() {
        return Dimensions;
    }

    public void setDimensions(String Dimensions) {
        this.Dimensions = Dimensions;
    }

    public float getWeight() {
        return Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }
}
   