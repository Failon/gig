/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;
import Colectives.Interns.Employee;
import Colectives.StakeHolder;
import GoodsandServices.CommercialGood;
import Operations.Details.BillDetail;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement; // imports especifics de JAXB
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author devweb
 */
@XmlType(propOrder = { "cliente", "codigoVenta", "tipoVenta", "lineasDetalle"})
public class Sale extends Bill implements Billable {
    protected StakeHolder client;
    protected int SaleIdCode;
    protected String typeSale;
    protected ArrayList<BillDetail> resources;

    public Sale() {
    }

    public Sale(StakeHolder client, int SaleIdCode, String typeSale, Date dataPayment, Float discount, Float taxes, double totalPrice, String payConditions, Boolean budget, int code, int type, Employee EmployeeGen, Date dataOpen, Date dataClose) {
        super(dataPayment, discount, taxes, totalPrice, payConditions, budget, code, type, EmployeeGen, dataOpen, dataClose);
        this.client = client;
        this.SaleIdCode = SaleIdCode;
        this.typeSale = typeSale;
    }
    @XmlElement(name = "cliente") 
    public StakeHolder getClient() {
        return client;
    }

    public void setClient(StakeHolder client) {
        this.client = client;
    }
    @XmlElement(name = "codigoVenta") 
    public int getSaleIdCode() {
        return SaleIdCode;
    }
    
    public void setSaleIdCode(int SaleIdCode) {
        this.SaleIdCode = SaleIdCode;
    }
    @XmlElement(name = "tipoVenta") 
    public String getTypeSale() {
        return typeSale;
    }

    public void setTypeSale(String typeSale) {
        this.typeSale = typeSale;
    }
    @XmlElement(name = "lineasDetalle") 
    public ArrayList<BillDetail> getResources() {
        return resources;
    }

    public void setResources(ArrayList<BillDetail> resources) {
        this.resources = resources;
    }

    public Employee getEmployeeGen() {
        return EmployeeGen;
    }

    public void setEmployeeGen(Employee EmployeeGen) {
        this.EmployeeGen = EmployeeGen;
    }
    @Override
    public int getType() {
    	//para establecer el tipo de factura segun la interface billable, devuelve 1 por ser una venta.
        return 1;
    }

    @Override
    public double getTotalPrice() {
    	//devuelve el precio total de cada linea.
        int longitud = resources.size();
        double precio_total = 0;
        double precio_linea;
        int cantidad;
        for(int i=0;i<longitud;i++){
            BillDetail aux = resources.get(i);
            cantidad = aux.getAmount();
            precio_linea = aux.getPrice();
            precio_total = precio_total + (precio_linea*cantidad);
        }
        return precio_total;
    }
    

    @Override
    public int numLines() {
    	//devuelve el numero de lineas del detalle.
        int longitud = resources.size();
        return longitud;
    }

    @Override
    public int addLine(CommercialGood Cg, String newdetail) {
        //Parsear el  string para obtener cada atributo necesario
        //para añadir un nuevo detalle que cumpla con los atributos de DetailsOrders
        //Estructura del string: "int,Double,String,int
        String[] details = newdetail.split(";");
        
        
        double precio_real = Double.parseDouble(details[0]);
        String detalles = details[1];
        int can = Integer.parseInt(details[2]);
        
     	//Para añadir una linea devemos comprobar primero que el producto no está incluído ya en la lista.
     	int longitud = resources.size();
     	int flag = 0;
     	String nombre = Cg.getName();
     	for(int i = 0;i<longitud && flag==0;i++){
     		String cg_name = resources.get(i).getIdResource().getName();
     		if(nombre.equals(cg_name)){
     			//si efectivamente encontramos el producto en alguna linea, actualizamos la información en vez de añadir una linea nueva.
     			flag = 1;
     			resources.get(i).setDetails(detalles);
     			resources.get(i).setAmount(resources.get(i).getAmount()+can);
     		}	
     	}
     	if(flag==0){
     		//si no se ha encontrado el producto se añade linea nueva.
     		resources.add(new BillDetail(precio_real, detalles, can, Cg));
     	}
        return 1;
    }

    @Override
    public String getLine(int n) {
        String error = "";
        int longitud = resources.size();
        if(n<longitud){
        	BillDetail aux = resources.get(n);
            String precio_aux = Double.toString(aux.getPrice());
            String details = aux.getDetails();
            String cantidad = Integer.toString(aux.getAmount());
            String cg_name = aux.getIdResource().getName();
            //String id_Cg = Integer.toString(Cgaux.getCode());
            //concateno en el string error todos los campos convertidos a string para luego ser devueltos.
            error = precio_aux+";"+details+";"+cantidad+";"+cg_name;
        }
        else{
        	error = "error";
        }
        return error;
    }

    @Override
    public String getLine(String n) {
        int longitud = resources.size(), flag = 0;
        String error = "";
        for(int i = 0; i<longitud && flag==0;i++){
        	BillDetail aux = resources.get(i);
        	String nombre = aux.getIdResource().getName();
        	if(nombre.equals(n)){
        		flag = 1;
                String precio_aux = Double.toString(aux.getPrice());
                String details = aux.getDetails();
                String cantidad = Integer.toString(aux.getAmount());
                String cg_name = aux.getIdResource().getName();
                //concateno en el string error todos los campos convertidos a string para luego ser devueltos.
                error = precio_aux+";"+details+";"+cantidad+";"+cg_name;        		        		
        	}
        }
        if(flag==0){
        	error = "error";
        }
        
        return error;
    }

    @Override
    public int updateLine(int n, String newdetail) {
        //separo el contenido por ;
       String[] details = newdetail.split(";");
       //guardo en variables del tipo de objeto adecuado cada uno de los campos necesitados.
       double precio = Double.parseDouble(details[0]);
       String detalles = details[1];
       int cantidad = Integer.parseInt(details[2]);
       //extraigo el commercial good de la linea que me han pasado por parametro.
       BillDetail aux = resources.get(n);
       CommercialGood cg_aux = aux.getIdResource();
       //monto el nuevo DetailsOrder con la informacion actualizada
       aux = new BillDetail(precio, detalles, cantidad, cg_aux);
       //y finalmente actualizo la linea.
       resources.set(n, aux);
       
       return 1;
    }

    @Override
    public int updateLine(String n, String newdetail) {
        //separo el contenido por ;
        String[] details = newdetail.split(";");
        //guardo en variables del tipo de objeto adecuado cada uno de los campos necesitados.
        double precio = Double.parseDouble(details[0]);
        String detalles = details[1];
        int cantidad = Integer.parseInt(details[2]);        
        int longitud = resources.size();
        int flag = 0;
         for(int i = 0;i<longitud && flag==0;i++){
             //Extraigo el nombre del commercialgood
             String nombre = resources.get(i).getIdResource().getName();
             if(nombre.equals(n)){
                 resources.get(i).setPrice(precio);
                 resources.get(i).setDetails(detalles);
                 resources.get(i).setAmount(cantidad);
                 flag = 1;
             }
         }
         //si no ha encontrado devuelve -1
         if(flag==0) return (-1);
         //si ha encontrado devuelve 1
         else return 1;
    }

    @Override
    public int delLine(int n) {
    	//borra la linea del detalle seleccionada.
        int longitud = resources.size();
        int error;
        if(n<longitud){
     	   resources.remove(n);
     	   error = 1;
        }
        else error = -1;
        return error;
    }

    @Override
    public int delLine(String n) {
        int longitud = resources.size();
        int flag = 0;
        int error;
        //recorremos la lista en busca del CG con el nombre pasado por parametro
        for(int i= 0; i<longitud && flag==0;i++){
        	String nombre_cg = resources.get(i).getIdResource().getName();
        	//si lo encontramos pasamos a flag 1 para dejar de buscar y removemos la linea.
        	if(nombre_cg.equals(n)){
        		flag = 1;
        		resources.remove(i);
        	}
        }
        //si el flag es 0, no se ha encontrado el objeto por tanto no se ha removido ninguna linea y devolvemos -1
        if(flag==0){
        	error = -1;
        }
        //por el contrario si el flag es 1 se ha borrado la linea y devolvemos 1.
        else error = 1;
        
        return error;
    }
    
    
}
