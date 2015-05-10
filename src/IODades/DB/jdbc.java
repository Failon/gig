package IODades.DB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			while(resultado.next()){
				System.out.println(resultado.getInt("code")+" "+resultado.getString(2));
			}
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
	public int setConnect() {
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
		String[] datos_consulta = source.split("@");
		String[] campos = datos_consulta[0].split(";");
		String tabla = datos_consulta[1];
		String[] where = datos_consulta[2].split(";");
		
		//realizo la consulta
		int error = Select(tabla, campos, where[0], where[1]);
		
		if(error == 0){
		    ResultSetMetaData meta;
		    
			try {
				meta = resultado.getMetaData();
				int numColumns = meta.getColumnCount();
				for(int i = 0; i< numColumns; i++){
					int type = meta.getColumnType(i);
				}
			} catch (SQLException e) {
				error = -1;
			}	    		    
		}
		return error;
	}
	@Override
	public int exportdades(ArrayList dades, String source, int mode) {
		// TODO Auto-generated method stub
		return 0;
	}

}