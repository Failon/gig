package Operations;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement(name = "Sales") // notacio JAXB pel node arrel
public class GSale {
	protected ArrayList<Sale> llistat;
	 // Constructors
	 public GSale () { llistat = new ArrayList(); }
	 public GSale ( ArrayList<Sale> llista ) { llistat = llista; }
	 @XmlElement (name = "Sale") // tag per separar els Sales del grup
	 public void setGrupSales ( ArrayList<Sale> llista ) { llistat = llista; }
	 public ArrayList<Sale> getGrupSales () { return llistat; }
	 public Sale getSale ( int pos ) { return llistat.get(pos) ; }
	 public void setSale ( Sale cli ) { llistat.add (cli); }
	 public int numSales () { return llistat.size(); }
	}

