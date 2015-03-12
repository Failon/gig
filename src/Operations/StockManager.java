package Operations;

import java.util.Map;
import java.util.TreeMap;


public class StockManager {
	 protected TreeMap <String, Integer> stock;

	 public void updateStock ( String name, int amount ) {
			this.stock.put(name, amount); //con.put si existe el name, reemplaza el valor, sino, añade la linea.
	 }
	 public int getTotal ( String name ) { 
		 //si el producto está mapeado devolverá el valor, sinó lo está devolverá 0.
		 int total;
		 if(stock.containsKey(name)){
			 total = stock.get(name);
		 }
		 else{
			 total = -1;
		 }
		 return total;
	 }
	 public int delLine ( String name ) {
		 //si el producto está mapeado lo removemos y devolvemos 1, en caso contrario devolvemos -1
		 int error;
		 if(stock.containsKey(name)){
			 this.stock.remove(name);
			 error = 1;
		 }
		 else error = -1;
		 return error;
	 }
	 public String[] getLines ( ) {
		 String lineas[] = {};
		 int i = 0;
		 for(Map.Entry<String,Integer> entry : stock.entrySet()) {
			 
			  String key = entry.getKey();

			  lineas[i] = key;
			  i++;
			}
		 return lineas;
	 }

}
