/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives;

/**
 *
 * @author devweb
 */
public interface StakeHolder {

    
 public String getName(); 
 public void setName(String name);
        
 public String getCode();
 public void setCode(String code);
         
        
 public String getAddress();
 public void setAddress(String code);
        
 public String getPostalCode();
 public void setPostalCode(String code);
        
 public String getCity();
 public void setCity(String code);
        
 public String getdelivcountry();
 public void setdelivcountry(String code);
        
 public String getEmail();
 public void setEmail(String code);
        
 public String getPhone();
 public void setPhone(String code);
        
        
       //name customercode y company code Paddress delivpostalcode delivcity delivcountry Pemail Pphone  DE PERSONA
        //code de persona y customercode PERSONA O CUSTOMER ELEGIR CUAL PONEMOS
      
       //i algunos especificos para facturacion que solo aparecen como atributos de empresa
        
      public String getCorpName(); 
      public void setCorpName(String cname);
    
}
