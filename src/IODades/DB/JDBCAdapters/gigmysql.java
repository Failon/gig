package IODades.DB.JDBCAdapters;
import IODades.DB.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.DriverManager;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
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
	public int setConnect() {
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
	public int importdades(ArrayList dades, String source) {
		//extraigo los datos para realizar la consulta
		String[] datos_consulta = source.split("@");
		String[] campos = datos_consulta[0].split(";");
		String tabla = datos_consulta[1];
		String[] where = datos_consulta[2].split(";");
		//preparo el objeto del array list.
		Object obj = dades.get(0);
		//realizo la consulta
		int error = Select(tabla, campos, where[0], where[1]);
		//si la seleccion se ha resultado con exito
		if(error == 0){
			try {
				while(resultado.next()){//iteramos el resultset
					
					ResultSetMetaData meta = resultado.getMetaData();//caputramos la metadata de la tabla(numero de columnas, nombres de las columnas, tipo de datos de las columnas etc)
					int numColumns = meta.getColumnCount();//numero de columnas
					for(int i = 1; i<= numColumns; i++){//bucle para recorrer las columnas
						int type = meta.getColumnType(i);//capturamos el tipo
						String column = meta.getColumnName(i);//capturamos el nombre
						String method_name = "set"+column.substring(0,1).toUpperCase()+column.substring(1);//perparo el nombre del setter.
						if(type == Types.VARCHAR || type == Types.CHAR){//si es char o Varchar
							Method method; //declaro el metodo
							try {
								
								  method = obj.getClass().getMethod(method_name, String.class); //metodo de la clase del objeto pasado en el Arratlist
								  System.out.println(method);
								  method.invoke(obj, resultado.getString(i));//invoco el setter del objeto con el correspondiente valor del resultset
								} catch (SecurityException e) {
								  error = -3;//error de seguridad
								} catch (NoSuchMethodException e) {
								  error = -4;//metodo no encontrado
								} catch (IllegalAccessException e) {
									error = -5;//acceso al metodo no posible
								} catch (IllegalArgumentException e) {
									error = -6;//argumento incorrecto
								} catch (InvocationTargetException e) {
									error = -7;//error de invocacion
								}
						}
						if(type == Types.DATE){//para tipo fechas
							java.lang.reflect.Method method;
							try {
								  method = obj.getClass().getMethod(method_name);
								  method.invoke(obj, resultado.getDate(i));
								} catch (SecurityException e) {
								  error = -3;
								} catch (NoSuchMethodException e) {
								  error = -4;
								} catch (IllegalAccessException e) {
									error = -5;
								} catch (IllegalArgumentException e) {
									error = -6;
								} catch (InvocationTargetException e) {
									error = -7;
								}
						}
						if(type == Types.FLOAT){//para tipo float
							java.lang.reflect.Method method;
							try {
								  method = obj.getClass().getMethod(method_name);
								  method.invoke(obj, resultado.getFloat(i));
								} catch (SecurityException e) {
								  error = -3;
								} catch (NoSuchMethodException e) {
								  error = -4;
								} catch (IllegalAccessException e) {
									error = -5;
								} catch (IllegalArgumentException e) {
									error = -6;
								} catch (InvocationTargetException e) {
									error = -7;
								}
						}
						if(type == Types.NUMERIC){//para enteros
							java.lang.reflect.Method method;
							try {
								  method = obj.getClass().getMethod(method_name);
								  method.invoke(obj, resultado.getInt(i));
								} catch (SecurityException e) {
								  error = -3;
								} catch (NoSuchMethodException e) {
								  error = -4;
								} catch (IllegalAccessException e) {
									error = -5;
								} catch (IllegalArgumentException e) {
									error = -6;
								} catch (InvocationTargetException e) {
									error = -7;
								}
						}
					}
				}
			} catch (SQLException e) {//excepcion sql
				error = -1;
			}	    		    
		}
		return error;//devuelvo el tipo de error
	}
	@Override
	public int exportdades(ArrayList dades, String source, int mode) {
		int error = 0;
		Object obj = dades.get(0);
		Method[] method = obj.getClass().getDeclaredMethods();
		String[] campos = new String[method.length];
		String[] values = new String[method.length];
		switch(mode){
		case 1: //insert

			 for(int i = 0, k=0; i < method.length; i++){
				 String metodo_nombre = method[i].toString();
				 if(metodo_nombre.substring(0, 3)=="get"){
					 campos[k] = (metodo_nombre.substring(3)).toLowerCase();

					 try {
						Object invocado = method[i].invoke(obj).toString();
						values[k] = invocado.toString();
					} catch (IllegalAccessException e) {
						error = -4;
					} catch (IllegalArgumentException e) {
						error = -5;
					} catch (InvocationTargetException e) {
						error = -6;
					}
					k++;
				 }
			 }
			 			
			//llamamos a insert.
			error = Insert(source, campos, values);
			
		break;
		case 2: //Update
			String[] datos_query = source.split("@");
			String tabla = datos_query[0];
			String[] condicion = datos_query[1].split(";");
			 for(int i = 0, k=0; i < method.length; i++){
				 String metodo_nombre = method[i].toString();
				 if(metodo_nombre.substring(0, 3)=="get"){
					 campos[k] = metodo_nombre.substring(3);
					 try {
						Object invocado = method[i].invoke(obj).toString();
						values[k] = invocado.toString();
					} catch (IllegalAccessException e) {
						error = -4;
					} catch (IllegalArgumentException e) {
						error = -5;
					} catch (InvocationTargetException e) {
						error = -6;
					}
					k++;
				 }
			 }
			 			
			//llamamos a insert.
			error = Update(tabla, campos, values, condicion[0], condicion[1]);	
		break;
		case 3: //Delete
			String[] datosquery = source.split("@");//extraigo la informacion
			String table = datosquery[0];//tabla
			String[] where = datosquery[1].split(";");//where.
			
			Delete(table, where[0], where[1]);
		break;
		default:
		break;
		}
		return error;
	}
	
}

