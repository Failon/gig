/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GoodsandServices;
import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "nombre","descripcion","categoria","comentariosInternos","precio","impuestos","codigoCG","activo"})
public class CommercialGood {
    protected String Name,Description, Category, InternalComments;
    protected float Price, taxes;
    protected int Code;
    protected Boolean active = true;
    @XmlElement(name = "nombre")
    public String getName() {
        return Name;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    @XmlElement(name = "descripcion")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    @XmlElement(name = "categoria")
    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    @XmlElement(name = "comentariosInternos")
    public String getInternalComments() {
        return InternalComments;
    }

    public void setInternalComments(String InternalComments) {
        this.InternalComments = InternalComments;
    }
    @XmlElement(name = "precio")
    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }
    @XmlElement(name = "codigoCG")
    public int getCode() {
        return Code;
    }

    public void setCode(int Code) {
        this.Code = Code;
    }
    @XmlElement(name = "activo")
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
