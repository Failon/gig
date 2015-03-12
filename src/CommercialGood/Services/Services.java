/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Services;
import CheckData.Checking;
import GoodsandServices.CommercialGood;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *
 * @author devweb
 */
public class Services extends CommercialGood{
    protected Date StartDate, EndDate;
    protected String Rate;

    public Services() {
    }

    public Services(Date StartDate, Date EndDate, String Rate) {
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Rate = Rate;
    }

     public String getStartDate(){
     String eDate;
     DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
     eDate = formato.format(StartDate);
     
     if(eDate== null){
     return null;
     }else{
     return eDate;
     }
    
    }

    public void setStartDate(String NDate){
    if (Checking.CheckDates(NDate)==0){
    try{
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        
        StartDate = formato.parse(NDate);
    }catch (ParseException ex){
        StartDate= null;
    }
    }
    
    
    }
    
    public String getEndDate(){
     String eDate;
     DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
     eDate = formato.format(EndDate);
     
     if(eDate== null){
     return null;
     }else{
     return eDate;
     }
    
    }

    public void setEndDate(String NDate){
    if (Checking.CheckDates(NDate)==0){
    try{
        DateFormat formato = DateFormat.getDateInstance(DateFormat.SHORT);
        
        EndDate = formato.parse(NDate);
    }catch (ParseException ex){
        EndDate= null;
    }
    }
    
    
    }

    
    public String getRate() {
        return Rate;
    }

    public void setRate(String Rate) {
        this.Rate = Rate;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    
}
