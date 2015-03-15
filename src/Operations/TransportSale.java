
package Operations;

import Colectives.StakeHolder;
import Colectives.Externs.ServiceProvider;
import Colectives.Interns.Employee;
import Operations.Details.BillDetail;
import Operations.Details.TransportDetails;

import java.util.ArrayList;
import java.util.Date;


 
public class TransportSale extends Sale implements Billable{
    protected String placetosend, country, city, postalcode, TransportComments;
    protected ServiceProvider Transporter;
    protected ArrayList<TransportDetails> transDetails;
    
    
	public TransportSale() {

	}

	public TransportSale(StakeHolder client, int SaleIdCode, String typeSale,
			Date dataPayment, Float discount, Float taxes, double totalPrice,
			String payConditions, Boolean budget, int code, int type,
			Employee EmployeeGen, Date dataOpen, Date dataClose,
			String placetosend, String country, String city, String postalcode,
			String transportComments, ServiceProvider transporter,
			ArrayList<TransportDetails> transDetails) {
		super(client, SaleIdCode, typeSale, dataPayment, discount, taxes,
				totalPrice, payConditions, budget, code, type, EmployeeGen,
				dataOpen, dataClose);
		this.placetosend = placetosend;
		this.country = country;
		this.city = city;
		this.postalcode = postalcode;
		TransportComments = transportComments;
		Transporter = transporter;
		this.transDetails = transDetails;
	}
	
	public String getPlacetosend() {
		return placetosend;
	}

	public void setPlacetosend(String placetosend) {
		this.placetosend = placetosend;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getTransportComments() {
		return TransportComments;
	}

	public void setTransportComments(String transportComments) {
		TransportComments = transportComments;
	}

	public ServiceProvider getTransporter() {
		return Transporter;
	}

	public void setTransporter(ServiceProvider transporter) {
		Transporter = transporter;
	}

	public ArrayList<TransportDetails> getTransDetails() {
		return transDetails;
	}

	public void setTransDetails(ArrayList<TransportDetails> transDetails) {
		this.transDetails = transDetails;
	}

	@Override
	public void setResources(ArrayList<BillDetail> resources) {
		resources = null;
		super.setResources(resources);
	}
   	    
}
