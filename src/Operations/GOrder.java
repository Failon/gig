package Operations;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "Orders") // notacio JAXB pel node arrel
public class GOrder {
	protected ArrayList<Order> llistat;
	 // Constructors
	 public GOrder () { llistat = new ArrayList(); }
	 public GOrder ( ArrayList<Order> llista ) { llistat = llista; }
	 @XmlElement (name = "Order") // tag per separar els Orders del grup
	 public void setGrupOrders ( ArrayList<Order> llista ) { llistat = llista; }
	 public ArrayList<Order> getGrupOrders () { return llistat; }
	 public Order getOrder ( int pos ) { return llistat.get(pos) ; }
	 public void setOrder ( Order cli ) { llistat.add (cli); }
	 public int numOrders () { return llistat.size(); }
	}
