/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import Colectives.Externs.Provider; //importar datos de proveedores
import Colectives.Interns.Employee;
import GoodsandServices.CommercialGood;
import Operations.Details.DetailsOrders;

import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author devweb
 */
public class Order extends Bill implements Billable{
        protected Provider provider;
        protected int status; //indica si el pedido s'ha satisfet
        protected int OrderIdCode;
        protected Employee EmpReceiver;
        protected ArrayList<DetailsOrders> resources;

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Employee getEmpReceiver() {
        return EmpReceiver;
    }

    public void setEmpReceiver(Employee EmpReceiver) {
        this.EmpReceiver = EmpReceiver;
    }

    public ArrayList<DetailsOrders> getResources() {
        return resources;
    }

    public void setResources(ArrayList<DetailsOrders> resources) {
        this.resources = resources;
    }

    public Order() {
    }

    public Order(Provider provider, int status, int OrderIdCode, Employee EmpReceiver, Date dataPayment, Float discount, Float taxes, double totalPrice, String payConditions, Boolean budget, int code, int type, Employee EmployeeGen, Date dataOpen, Date dataClose) {
        super(dataPayment, discount, taxes, totalPrice, payConditions, budget, code, type, EmployeeGen, dataOpen, dataClose);
        this.provider = provider;
        this.status = status;
        this.OrderIdCode = OrderIdCode;
        this.EmpReceiver = EmpReceiver;
    }

    @Override
    public int getType() {
        return -1; //para el tipo de factura en caso de ser un order devuelve -1.
    }

    @Override
    //calcula el precio total del detalle de la factura.
    public double getTotalPrice() {
        int longitud = resources.size();
        double precio_total = 0;
        double precio_linea;
        int cantidad;
        for(int i=0;i<longitud;i++){
            DetailsOrders aux = resources.get(i);
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
       
       int RU = Integer.parseInt(details[0]);
       double precio_real = Double.parseDouble(details[1]);
       String detalles = details[2];
       int can = Integer.parseInt(details[3]);
       
    	//Para añadir una linea devemos comprobar primero que el producto no está incluído ya en la lista.
    	int longitud = resources.size();
    	int flag = 0;
    	String nombre = Cg.getName();
    	for(int i = 0;i<longitud && flag==0;i++){
    		String cg_name = resources.get(i).getIdResource().getName();
    		if(nombre.equals(cg_name)){
    			//si efectivamente encontramos el producto en alguna linea, actualizamos la información en vez de añadir una linea nueva.
    			flag = 1;
    			resources.get(i).setReceived_units(resources.get(i).getReceived_units()+RU);
    			resources.get(i).setDetails(detalles);
    			resources.get(i).setAmount(resources.get(i).getAmount()+can);
    		}	
    	}
    	if(flag==0){
    		//si no se ha encontrado el producto se añade linea nueva.
    		resources.add(new DetailsOrders(RU, precio_real, detalles, can, Cg));
    	}
       return 1;
    }

    @Override
    public String getLine(int n) {
        String error = "";
        int longitud = resources.size();
        //comrpuebo la longitud de la lista
        if(n<longitud){
        //guardo en una variable auxiliar de tipo DetailsOrders la linea del array list pasada por parametro
        DetailsOrders aux = resources.get(n);
        //Lo desconpongo utilizando tambiÃ©n variables auxiliares en sus campos.
        
        String RU_aux = Integer.toString(aux.getReceived_units());
        String precio_aux = Double.toString(aux.getPrice());
        String details = aux.getDetails();
        String cantidad = Integer.toString(aux.getAmount());
        String cg_name = aux.getIdResource().getName();
        //concateno en el string error todos los campos convertidos a string para luego ser devueltos.
        error = RU_aux+";"+precio_aux+";"+details+";"+cantidad+";"+cg_name;
        }
        else {
            error = "error";     
        }
        return error;
    }

    @Override
    public String getLine(String n) {
        String error = "";
        int flag = 0;
        //recorro el arraylist resources elemento a elemento, extrayendo el CG y invocando el metodo getName
        //luego lo comparo (con equals) a "n" que me pasan por parametro.
        int longitud = resources.size();
        for(int i = 0; i < longitud && flag==0; i++){
            //guardo el elemento i del array list resources en un DO auxiliar.
            DetailsOrders aux = resources.get(i);
            //extraigo el commercial good del elemento guardado en un CG auxiliar
            CommercialGood cg_aux = aux.getIdResource();
            //extraigo el nombre del cg_aux.
            String nombre = cg_aux.getName();
            //comparo el nombre extraido con el que me han pasado por parametro.
            if(nombre.equals(n)){
                String RU_aux = Integer.toString(aux.getReceived_units());
                String precio_aux = Double.toString(aux.getPrice());
                String details = aux.getDetails();
                String cantidad = Integer.toString(aux.getAmount());
                String cg_name = aux.getIdResource().getName();
                //concateno en el string error todos los campos convertidos a string para luego ser devueltos.
                error = RU_aux+";"+precio_aux+";"+details+";"+cantidad+";"+cg_name;
                flag = 1;
            }
        }
        //si el flag no ha cambiado, no se ha encontrado la linea.
        if (flag==0){
            error = "error";
        }
        return error;
    }

    @Override
    public int updateLine(int n, String newdetail) {
        //separo el contenido por ;
       String[] details = newdetail.split(";");
       //guardo en variables del tipo de objeto adecuado cada uno de los campos necesitados.
       int Received_Units = Integer.parseInt(details[0]);
       double precio = Double.parseDouble(details[1]);
       String detalles = details[2];
       int cantidad = Integer.parseInt(details[3]);
       //extraigo el commercial good de la linea que me han pasado por parametro.
       DetailsOrders aux = resources.get(n);
       CommercialGood cg_aux = aux.getIdResource();
       //monto el nuevo DetailsOrder con la informaciÃ³n actualizada
       aux = new DetailsOrders(Received_Units, precio, detalles, cantidad, cg_aux);
       //y finalmente actualizo la linea.
       resources.set(n, aux);
       
       return 1;
    }

    @Override
    public int updateLine(String n, String newdetail) {
       //separo el contenido por ;
       String[] details = newdetail.split(";");
       //guardo en variables del tipo de objeto adecuado cada uno de los campos necesitados.
       int Received_Units = Integer.parseInt(details[0]);
       double precio = Double.parseDouble(details[1]);
       String detalles = details[2];
       int cantidad = Integer.parseInt(details[3]);        
       int longitud = resources.size();
       int flag = 0;
        for(int i = 0;i<longitud && flag==0;i++){
            //Extraigo el nombre del commercialgood
            String nombre = resources.get(i).getIdResource().getName();
            if(nombre.equals(n)){
                resources.get(i).setReceived_units(Received_Units);
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
