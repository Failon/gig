/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Products;
import CheckData.Checking;
import GoodsandServices.CommercialGood;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author devweb
 */
public class Products extends CommercialGood {
    protected float lenght, weigth, width, high, indexRating;
    protected String manufacturer, model, series, content, reviews;
    protected Date releaseDate;
// review es la critica de la pagina

    public float getLenght() {
        return lenght;
    }

 
    public void setLenght(float lenght) {
        this.lenght = lenght;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getIndexRating() {
        return indexRating;
    }

    public void setIndexRating(float indexRating) {
        this.indexRating = indexRating;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    
         public String getReleaseDate(){
     String eDate;
     DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
     eDate = formato.format(releaseDate);
     
     if(eDate== null){
     return null;
     }else{
     return eDate;
     }
    
    }

    public void setReleaseDate(String NDate){
        
    if (Checking.CheckDates(NDate)==0){
    try{
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        
        releaseDate = formato.parse(NDate);
    }catch (ParseException ex){
        releaseDate= null;
    }
    }
    else{
    releaseDate= null;
    }
    
    }
    
    

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }
   
       public Products(float lenght, float weigth, float width, float high, float indexRating, String manufacturer, String model, String series, String content, String reviews, Date releaseDate, String Name, String Description, String Category, String InternalComments, float Price, int Code) {
        super(Name, Description, Category, InternalComments, Price, Code);
        this.lenght = lenght;
        this.weigth = weigth;
        this.width = width;
        this.high = high;
        this.indexRating = indexRating;
        this.manufacturer = manufacturer;
        this.model = model;
        this.series = series;
        this.content = content;
        this.reviews = reviews;
        this.releaseDate = releaseDate;
    }

    public Products() {
    }
}


