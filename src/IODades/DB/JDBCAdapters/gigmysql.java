package IODades.DB.JDBCAdapters;
import IODades.DB.jdbc;
import Operations.Order;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class gigmysql extends jdbc{
	protected String url;
	protected int error = 0;
	
	@Override
	public int open(String source, int mode){
		int error;
		error = setConnect();
		return error;
	}
	@Override
	public int close(String source){
		int error = 0;
		try {
			connect.close();
		} catch (SQLException e) {
			error = -1;
		}
		return error;
	}
	
	@Override
	protected int setConnect() {
		setUrl();
		try {
			this.connect = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			error = -1;
		}
		return error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl() {
		setDriver("mysql");
		this.url = "jdbc:"+this.driver+"://"+this.host+"/"+this.database;
	}
	@Override
	public int exportdades(ArrayList dades, String source, int mode) {
		int error = 0; //codigo de error;
		Object obj = dades.get(0); //objeto en el arraylist
		Method[] method = obj.getClass().getMethods(); //array con los metodos
		String[] campos; //campos para las consultas sql (redimensionados)
		String[] campos_test = new String[method.length]; //candidatos de campos (sin dimension adecuada)
		String[] campo_aux = new String[1]; //campo para el testdrive
		String[] values;//values para las consultas sql (redimensionados)
		String[] values_test = new String[method.length]; //candidatos de valores (sin dimension adecuada)
		String[] line; // array para los campos de los detalles de orderdetail
		int sizeDetalle; //numero de lineas de detalles
		int k; //variable que dimensionará los arrays de campos y values.
		int testdrive; //codigo de error que determina si un campo existe en la base de datos
		
		switch(mode){
		case 1: //insert
			k=0; //contador a 0
			 for(int i = 0; i < method.length; i++){ //recorremos el array de metodos
				 String metodo_nombre = method[i].getName(); //capturamos el nombre del metodo
				 if(metodo_nombre.substring(0, 3).equals("get")){ //si empieza por get
					 campos_test[k] = (metodo_nombre.substring(3)).toLowerCase(); //guardamos el candidato del nombre del campo en minusculas
					 campo_aux[0] = campos_test[k]; //preparamos el campo para el test drive
					 testdrive = Select(source, campo_aux, null, null);
					 System.out.println(testdrive);
					if(testdrive == 0){
						try {
							Object invocado = method[i].invoke(obj); //llamamos al get y guardamos su valor como objeto
							values_test[k] = invocado.toString(); //pasamos el contenido a string
							k++; //subimos el contador (como se observa solo se guardan los casos en que exista el campo en la bd y además si y solo si el metodo devuelve algo, así acotamos los casos en caso de que el objeto esté parcialmente vacio.
							System.out.println(invocado.getClass().getName());
						} catch (IllegalAccessException e) {
							error = -4;
						} catch (IllegalArgumentException e) {
							error = -5;
						} catch (InvocationTargetException e) {
							error = -6;
						} catch (NullPointerException e){
							error = -10;
						}
					}				
				 }
			 }
			 if(k>0){ //si se ha guardado algun campo y valor
				 campos = new String[k]; //dimensionamos el array de campos
				 values = new String[k]; //dimensionamos el array de values
				 for(int i = 0; i < k; i++){
					 campos[i] = campos_test[i]; //los llenamos con los campos de los tests
					 values[i] = values_test[i]; //los llenamos con los valores de los tests
				 }
				//llamamos a insert.	
				 error = Insert(source, campos, values);
			 }else{
				error = -7; //si ningun campo era candidato
			 }
			 if(error > -7 && source == "orders" && obj.getClass().getName()=="Order"){ //si ha habido Insert y la tabla era orders y el objeto era Order
				 source = "ordersdetails"; //revisar nombre de tabla
				 sizeDetalle = ((Order) obj).numLines(); //capturamos el numero de detalles que tiene el Order
				 campos = new String[5]; //dimensiono el array de campos y posteriormente asigno los nombres de los estos
				 campos[0] = "receivedunits";
				 campos[1] = "price";
				 campos[2] = "details";
				 campos[3] = "amount";
				 campos[4] = "code";
				 for(int i = 0; i < sizeDetalle; i++){ //bucle para realizar los inserts en la tabla de detalles.
					 line = ((Order)obj).getLine(i).split(";"); //capturo el array de valores
					 if(line.length > 1){// get Line devuelve el string "error" si falla que daría lugar a un array de una posicion, discrimino este caso y ejecuto el insert solo si ha capturado valores.
						 error = Insert(source, campos, line); //LLamo a Insert.
					 }					 
				 }				 
			 }		 					
			
		break;
		case 2: //Update
			String[] datos_query = source.split("@");
			String tabla = datos_query[0];
			String[] condicion = datos_query[1].split(";");
			k=0;
			 for(int i = 0; i < method.length; i++){
				 String metodo_nombre = method[i].getName();
				 if(metodo_nombre.substring(0, 3)=="get"){
					 campos_test[k] = (metodo_nombre.substring(3)).toLowerCase();
					 campo_aux[0] = campos_test[k];
					 try {
						Object invocado = method[i].invoke(obj);
						values_test[k] = invocado.toString();
					} catch (IllegalAccessException e) {
						error = -4;
					} catch (IllegalArgumentException e) {
						error = -5;
					} catch (InvocationTargetException e) {
						error = -6;
					}
					 testdrive = Select(source, campo_aux, null, null);
					 if(testdrive == 0){
						k++;
					 }				
				 }
			 }
			 if(k>0){
				 campos = new String[k];
				 values = new String[k];
				 for(int i = 0; i < k; i++){
					 campos[i] = campos_test[i];
					 values[i] = values_test[i];
				 }
				//llamamos a Update.
				 error = Update(tabla, campos, values, condicion[0], condicion[1]);
			 }else{
				 error = -7;
			 }
			 if(error > -7 && source == "orders" && obj.getClass().getName()=="Order"){
				 source = "ordersdetails"; //revisar nombre de tabla.
				 sizeDetalle = ((Order) obj).numLines();
				 campos = new String[5];
				 campos[0] = "receivedunits";
				 campos[1] = "price";
				 campos[2] = "details";
				 campos[3] = "amount";
				 campos[4] = "code";
				 for(int i = 0; i < sizeDetalle; i++){
					 line = ((Order)obj).getLine(i).split(";");
					 error = Update(source, campos, line, campos[4], line[4]);
				 }				 
			 }	
			
			
		break;
		case 3: //Delete
			String[] datosquery = source.split("@");//extraigo la informacion
			String table = datosquery[0];//tabla
			String[] where = datosquery[1].split(";");//where.
			
			error = Delete(table, where[0], where[1]);
			if(table == "Orders"){//si la tabla era de Orders
				table = "OrdersDetail"; //revisar nombre
				error = Delete(table, "order", where[1]); //borramos los detalles que fueran de ese Order.
			}
		break;
		default:
			error = -8; //operacion incorrecta.
		break;
		}
		return error;
	}
	
}