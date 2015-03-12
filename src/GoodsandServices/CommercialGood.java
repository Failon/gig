/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodsandServices;

/**
 *
 * @author devweb
 */
public class CommercialGood {
    protected String Name,Description, Category, InternalComments;
    protected float Price, taxes;
    protected int Code;
    protected Boolean active = true;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getInternalComments() {
        return InternalComments;
    }

    public void setInternalComments(String InternalComments) {
        this.InternalComments = InternalComments;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public CommercialGood(String Name, String Description, String Category, String InternalComments, float Price, int Code) {
        this.Name = Name;
        this.Description = Description;
        this.Category = Category;
        this.InternalComments = InternalComments;
        this.Price = Price;
        this.Code = Code;
    }

    public CommercialGood() {
    }

       
}
