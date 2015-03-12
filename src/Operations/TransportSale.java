
package Operations;

import Colectives.StakeHolder;
import Colectives.Externs.ServiceProvider;
import Colectives.Interns.Employee;
import Operations.Details.TransportDetails;

import java.util.ArrayList;
import java.util.Date;


 
public class TransportSale extends Sale implements Billable{
    protected String placetosend, country, city, postalcode, TransportComments;
    protected ServiceProvider Transporter;
    protected ArrayList<TransportDetails> resources;
    
	public TransportSale(StakeHolder client, int SaleIdCode, String typeSale,
			Date dataPayment, Float discount, Float taxes, double totalPrice,
			String payConditions, Boolean budget, int code, int type,
			Employee EmployeeGen, Date dataOpen, Date dataClose,
			String placetosend, String country, String city, String postalcode,
			String transportComments, ServiceProvider transporter,
			ArrayList<TransportDetails> resources) {
		super(client, SaleIdCode, typeSale, dataPayment, discount, taxes,
				totalPrice, payConditions, budget, code, type, EmployeeGen,
				dataOpen, dataClose);
		this.placetosend = placetosend;
		this.country = country;
		this.city = city;
		this.postalcode = postalcode;
		TransportComments = transportComments;
		Transporter = transporter;
		this.resources = resources = null;
	}
    
    
}
