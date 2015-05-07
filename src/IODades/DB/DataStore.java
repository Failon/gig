package IODades.DB;

import IODades.DataSource;

public interface DataStore extends DataSource{
	public int Select(String tabla, String[] campos, String where, String valor);
	public int Insert(String tabla, String[] campos, String[] values);
	public int Update(String tabla, String[] campos, String[] values, String where, String valor2);
	public int Delete(String tabla, String where, String valor);
}
