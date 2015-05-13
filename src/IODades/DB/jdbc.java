package IODades.DB;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;

import CommercialGood.Products.VideoGames;

public class jdbc implements DataStore{
	protected Connection connect;
	protected Statement statement;
	protected ResultSet resultado;
	protected String host, database, user, password, driver;
	@Override
	public int Select(String tabla, String[] campos, String where, String valor) {
		int error = 0; //codigo de error
		String seleccion = ""; //campos de la seleccion
		String query;
		for(int i=0; i<campos.length;i++){ //concateno los campos con ,
			seleccion = seleccion+campos[i];
			if(campos.length - i >1) seleccion = seleccion + ",";
		}
		if(where == null){
			query = "SELECT "+seleccion+" FROM "+tabla;
		}
		else{
			query = "SELECT "+seleccion+" FROM "+tabla+" WHERE "+where+" = '"+valor+"'";
		}
		
		try {
			statement = connect.createStatement();
			resultado = statement.executeQuery(query);
			/*while(resultado.next()){
				System.out.println(resultado.getInt("code")+" "+resultado.getString(2));
			}*/
		} catch (SQLException e) {
			error = -1;
		}

		return error;
	}
	@Override
	public int Insert(String tabla, String[] campos, String[] values) {
		int error = 0;
		String seleccion = ""; //campos de la seleccion
		String valores = "'";//valores de los campos
		if(campos.length==values.length){
		for(int i=0; i<campos.length;i++){ //concateno los campos y valores con ,
			seleccion = seleccion+campos[i];
			valores = valores+values[i];
			if(campos.length - i >1){
				seleccion = seleccion + ",";
				valores = valores + "','";
			}
		}
		String query = "INSERT INTO "+tabla+" ("+seleccion+") VALUES("+valores+"')";
		System.out.println(query);
		try {
			statement = connect.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			error = -1;
		}
		}else{
			error = -2;
		}
		return error;
		
	}
	
	@Override
	public int Update(String tabla, String[] campos, String[] values, String where, String valor2) {
		int error = 0;
		String set = "";
		if(campos.length==values.length){
		for(int i=0; i<campos.length;i++){ //concateno los campos y valores con ,
			set += campos[i]+"='"+values[i]+"'";
			if(campos.length - i >1){
				set+=",";
			}
		}
		String query = "UPDATE "+tabla+" SET "+set+" WHERE "+where+" = '"+valor2+"'";
		try {
			statement = connect.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			error = -1;
		}
		}else{
			error = -2;
		}
		return error;
	}
	@Override
	public int Delete(String tabla, String where, String valor) {
		int error = 0;
		String query = "DELETE FROM "+tabla+" WHERE "+where+" = '"+valor+"'";
		try {
			statement = connect.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			error = -1;
		}
		return error;
	}
	public Connection getConnect() {
		return connect;
	}
	protected int setConnect() {
		return 0;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	@Override
	public int open(String source, int mode) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int close(String source) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int importdades(ArrayList dades, String source) {
		//extraigo los datos para realizar la consulta
		int fila = 0;
		String[] datos_consulta = source.split("@");
		String[] campos = datos_consulta[0].split(";");
		String tabla = datos_consulta[1];
		String[] where = datos_consulta[2].split(";");
		//preparo el objeto del array list.
		Object obj = dades.get(0);
		Class<?> clase = obj.getClass();
		Method method; //declaro el metodo
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
						//para campos compuestos
						int ifcompuesto = column.split("\\.").length; //separa por puntos y compara cuantos campos hay
						if(ifcompuesto > 1){ //si hay mas de un campo
							column = column.split("\\.")[ifcompuesto-1]; //se guarda el nombre después del último punto que corresponderá al nombre del setter.
						}
						String method_name = "set"+column.substring(0,1).toUpperCase()+column.substring(1);//perparo el nombre del setter.
						if(type == Types.VARCHAR || type == Types.CHAR){//si es char o Varchar						
							try {							
								  method = obj.getClass().getMethod(method_name, String.class); //metodo de la clase del objeto pasado en el Arratlist
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
							try {
								  method = obj.getClass().getMethod(method_name, Date.class);
								  method.invoke(obj, resultado.getString(i));							  
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
						if(type == Types.REAL){//para tipo float
							try {
								  method = obj.getClass().getMethod(method_name, float.class);
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
						if(type == Types.INTEGER){//para enteros
							try {
								  method = obj.getClass().getMethod(method_name, int.class);
								  method.invoke(obj, Integer.valueOf(resultado.getInt(i)));
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
						if(type == Types.ARRAY){ //para arrays (postgresql)
							try {
								  method = obj.getClass().getMethod(method_name, ArrayList.class);
								  method.invoke(obj, resultado.getArray(i));
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
					dades.add(fila, obj);
					fila++;
					try {
						obj = clase.newInstance();
					} catch (InstantiationException | IllegalAccessException e) {
	
						e.printStackTrace();
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
		// TODO Auto-generated method stub
		return 0;
	}
}