package Operations.Details;
import CommercialGood.Services.Transport;

public class TransportDetails{
	protected Transport transportService;
	protected double price;
	protected String details;
	
	public TransportDetails(Transport transportService, double price, String details) {
		this.transportService = transportService;
		this.price = price;
		this.details = details;
	}

	public Transport getTransportService() {
		return transportService;
	}

	public void setTransportService(Transport transportService) {
		this.transportService = transportService;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
	
	
}
