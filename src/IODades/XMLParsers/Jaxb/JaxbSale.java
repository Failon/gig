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
import Operations.GSale;

public class JaxbSale implements DataSource{
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
		// no la utilizo
		return 0;
	}

	@Override
	public int importdades(ArrayList llista, String pathname) {
		int error=0;
		try { // Lectura Document XML amb JAXB
			 context = JAXBContext.newInstance ( GSale.class );
			 xmltojava = context.createUnmarshaller ();
			 GSale grup = (GSale) xmltojava.unmarshal ( new FileReader ( pathname ) );
			 int max = grup.numSales();
			 for (int cont = 0; cont < max; cont++) //transferim els sales a la llista
			 {
			 llista.add(grup.getSale(cont));
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
			 context = JAXBContext.newInstance ( GSale.class );
			 javaToXml = context.createMarshaller ();
			 javaToXml.setProperty ( Marshaller.JAXB_FORMATTED_OUTPUT, true );
			 GSale grup = new GSale ( llista );
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
