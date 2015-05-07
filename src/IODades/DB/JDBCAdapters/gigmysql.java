package IODades.DB.JDBCAdapters;
import IODades.DB.jdbc;
import java.sql.DriverManager;
import java.sql.SQLException;


public class gigmysql extends jdbc{
	protected String url;
	protected int error = 0;
	
	@Override
	public int open(){
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
	
	
}

