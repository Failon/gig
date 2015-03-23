package IODades.XMLParsers.Jaxb;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.bind.MarshalException;

import IODades.DataSource;
import Operations.GOrder;
public class JaxbOrder implements DataSource {
	JAXBContext context;
	Marshaller javaToXml;
	Unmarshaller xmltojava;
	
	@Override
	public int open(String source, int mode) {
		// no lo utilizo
		return 0;
	}
	@Override
	public int close(String source) {
		// no lo utilizo
		return 0;
	}
	@Override
	public int importdades(ArrayList llista, String pathname) {
		int error=0;
		try { // Lectura Document XML amb JAXB
			 context = JAXBContext.newInstance ( GOrder.class );
			 xmltojava = context.createUnmarshaller ();
			 GOrder grup = (GOrder) xmltojava.unmarshal ( new FileReader ( pathname ) );
			 int max = grup.numOrders();
			 for (int cont = 0; cont < max; cont++) //transferim els orders a la llista
			 {
			 llista.add(grup.getOrder(cont));
			 }
			}
			catch (FileNotFoundException ex) {
			 System.out.println("FileNotFoundException");
			 error = -1;
			}
			catch (MarshalException ex) {
			 System.out.println("JAXBMarshalException");
			 error = -52;
			}
			catch (JAXBException ex) {
			 System.out.println("JAXBException" + ex.getMessage());
			 error = -51;
			}
		return error;
	}
	@Override
	public int exportdades(ArrayList llista, String pathname, int mode) {
		int error=0;
		try { // Escriptura Document XML amb JAXB
			 context = JAXBContext.newInstance ( GOrder.class );
			 javaToXml = context.createMarshaller ();
			 javaToXml.setProperty ( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			 GOrder grup = new GOrder ( llista );
			 javaToXml.marshal ( grup, new FileWriter ( pathname ) );
			}
			catch (MarshalException ex) {
			 System.out.println("MarshalException"+ ex.getMessage());
			 error = -52;
			}
			catch (JAXBException ex) {
			 System.out.println("JAXBException" + ex.getMessage());
			 error = -51;
			}
			catch (IOException ex) {
			 System.out.println("IOException"+ ex.getMessage());
			 error = -666;
			} 
		
		return error;
	}
	
}
