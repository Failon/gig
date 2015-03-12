package Operations.Details;
import java.util.Date;

import GoodsandServices.CommercialGood;
public class ServiceDetail extends BillDetail {
	protected Date fecha_inicio, fecha_fin;

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public ServiceDetail(double price, String details, int amount,
			CommercialGood idResource, Date fecha_inicio, Date fecha_fin) {
		super(price, details, amount, idResource);
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
	}

	public ServiceDetail(){
		
	}
}
