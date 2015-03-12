package CheckData;
import Operations.*;

public class StockController {
	
	static int checkbill(Billable Fact, StockManager Stock ){
		int tipo = Fact.getType(); //primero averiguamos si se trata de un Sale o un Order.
		int error = 0; //devolveremos este error
		String[] lineas_stock = Stock.getLines(); //las lineas de stock que contienen el producto y la cantidad
		int longitud_stock = lineas_stock.length; //cantidad de lineas (productos) del stock.
		int num_lineas = Fact.numLines(); //numero de lineas de la factura.
		switch(tipo){
		case 1: //si es una venta.
			
			for(int i = 0; i<num_lineas && error == 0;i++){	//recorremos la factura			
				String linea[] = Fact.getLine(i).split(";"); //descomponemos la linea en:
				String producto = linea[3]; //producto
				int cantidad = Integer.parseInt(linea[3]); //cantidad
				int flag = 0; 
				for(int k = 0;k<longitud_stock && flag==0;k++){ //buscamos en el stock si existe el producto que vamos a vender.
					if(producto.equals(lineas_stock[k])){ //si lo encuentra
						flag = 1; //cambiamos la bandera para que deje de buscar
						if(cantidad <= Stock.getTotal(producto)){ //si la cantidad que vamos a vender es menor o igual que la del stock
							int nueva_cantidad = Stock.getTotal(producto) - cantidad;
							Stock.updateStock(producto, nueva_cantidad);
						}
						else{
							error = -1;
						}
					}
				}
				if(flag==0){
					error = -2;
				}
			}
		break;
		case -1:
			for(int i = 0;i<num_lineas;i++){ //si es un pedido
				String linea[] = Fact.getLine(i).split(";"); //separamos la linea en sus valores
				String producto = linea[4]; //guardamos el nombre del producto
				int unidades_recividas = Integer.parseInt(linea[0]); //guardamos las unidades recividas
				int flag = 0; //bandera para determinar si hay stock del producto
				for(int k = 0;k < longitud_stock && flag==0;k++){
					if(producto.equals(lineas_stock[k])){ //si encuentra el producto en el stock
						flag = 1; //cambiamos el valor de la bandera
						int nueva_cantidad = Stock.getTotal(producto)+unidades_recividas; //la nueva cantidad es la que teniamos mas las recividas
						Stock.updateStock(producto, nueva_cantidad);//actualizamos el stock con la nueva cantidad
					}
				}
				if(flag==0){ //si no habia stock del producto pedido
					Stock.updateStock(producto, unidades_recividas); //añadimos una linea al stock con el producto y las unidades recividas.
				}
			}
		break;
		}
		return error;
	}
}
