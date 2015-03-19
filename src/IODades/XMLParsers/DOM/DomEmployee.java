package IODades.XMLParsers.DOM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Colectives.Interns.Employee;
import IODades.DataSource;

public class DomEmployee implements DataSource {
	
	protected DocumentBuilder builder;
	protected Document doc;
	protected Element elem;
	protected Node nodeArrel, nodeFill, subnode;
	protected NodeList llistaNodes, llistaAtrib;
	@Override
	public int open(String source, int mode) {
		// no la utilitzo
		return 0;
	}
	@Override
	public int close(String source) {
		// no la utilitzo
		return 0;
	}
	@Override
	public int importdades(ArrayList List, String route) {
		int error = 0;
		try {
			 
			 builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			 doc = builder.parse( new File(route) );
			 // Passem el contingut del fitxer XML a un objecte de tipus Document
			 nodeArrel = doc.getFirstChild(); // retorna el node arrel del document XML.
			 llistaNodes = nodeArrel.getChildNodes(); //agafem els nodes client
			 SimpleDateFormat mydateformat = new SimpleDateFormat("dd/MM/yyyy");
			 for (int i = 0 ; i < llistaNodes.getLength(); i++ ) // Per obtenir els nodes fill d’un determinat node
			 {
			 nodeFill = llistaNodes.item(i); //recorrerem la llista de clients
			 llistaAtrib = nodeFill.getChildNodes(); //agafem la llista de nodes de cada client
			 for (int j=0; j < llistaAtrib.getLength(); j++) {
			 subnode = llistaAtrib.item(j);
			 //System.out.println(subnode.getNodeName() + " : " + subnode.getTextContent()); //comprovacio
			 }
			 List.add(new Employee());

			 ((Employee)(List.get(i))).setName(llistaAtrib.item(1).getTextContent());
			 ((Employee)(List.get(i))).setCode(llistaAtrib.item(2).getTextContent());
			 ((Employee)(List.get(i))).setAddress(llistaAtrib.item(3).getTextContent());
			 ((Employee)(List.get(i))).setPostalcode(llistaAtrib.item(4).getTextContent());
			 ((Employee)(List.get(i))).setCity(llistaAtrib.item(5).getTextContent());
			 ((Employee)(List.get(i))).setCountry(llistaAtrib.item(6).getTextContent());
			 ((Employee)(List.get(i))).setEmail(llistaAtrib.item(7).getTextContent());
			 ((Employee)(List.get(i))).setType(llistaAtrib.item(8).getTextContent());
			 ((Employee)(List.get(i))).setBancCode(llistaAtrib.item(9).getTextContent());
			 ((Employee)(List.get(i))).setPhone(llistaAtrib.item(10).getTextContent());
			 ((Employee)(List.get(i))).setComments(llistaAtrib.item(11).getTextContent());
			 ((Employee)(List.get(i))).setEntryDate(mydateformat.parse(llistaAtrib.item(12).getTextContent()));
			 ((Employee)(List.get(i))).setOutDate(mydateformat.parse(llistaAtrib.item(13).getTextContent()));
			 ((Employee)(List.get(i))).setEmployeeCode(Integer.valueOf((llistaAtrib.item(14).getTextContent())));
			 ((Employee)(List.get(i))).setDepartment(llistaAtrib.item(15).getTextContent());
			 ((Employee)(List.get(i))).setContract(llistaAtrib.item(16).getTextContent());
			 ((Employee)(List.get(i))).setRole(llistaAtrib.item(17).getTextContent());
			 ((Employee)(List.get(i))).setNumberSS(llistaAtrib.item(18).getTextContent());
			 ((Employee)(List.get(i))).setSalary(Float.valueOf(llistaAtrib.item(19).getTextContent()));
			 }
			}
			catch (FileNotFoundException ex) {
				error = -1;
			 }
			catch (SAXException ex) {
				error = -11;
			 }
			catch (ParserConfigurationException ex) {
				error = -12;
			 }
			catch (DOMException ex) {
				error = -31;
			 }
			catch (IOException ex) { // errada: fitxer no accessible, format XML incorrecte, etc.
				error = -666;
			 } catch (ParseException ex) {
				//la exceptción que lanza el parseador de fechas
				error = -121;
			}
		return error;
	}
	@Override
	public int exportdades(ArrayList list1, String route, int mode) {
		int error = 0;
		try { // creació del document XML amb DOM
		 int cont=0;

		 builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		 doc = builder.newDocument();
		 elem = doc.createElement("Clients"); //creació del node arrel del document XML
		 doc.appendChild( elem );
		 Element  employee, name, code, address,postalcode, city, country, email, type, bancCode, phone, comments,
			entryDate, outDate, employeeCode, department,contract, role, numberSS, salary;

		 for(cont=0;cont< list1.size();cont++)
		 {
			employee = doc.createElement("Empleado");
			elem.appendChild(employee);
			
			name = doc.createElement("nombre");
			name.setTextContent(String.valueOf(((Employee)list1.get(cont)).getName()));
			employee.appendChild(name);
			 
			code = doc.createElement("codigo");
			code.setTextContent(String.valueOf(((Employee)list1.get(cont)).getCode()));
			employee.appendChild(code);
			
			address = doc.createElement("address");
			address.setTextContent(String.valueOf(((Employee)list1.get(cont)).getAddress()));
			employee.appendChild(address);
			 
			postalcode = doc.createElement("postalcode");
			postalcode.setTextContent(String.valueOf(((Employee)list1.get(cont)).getPostalcode()));
			employee.appendChild(postalcode);
			 
			city = doc.createElement("city");
			city.setTextContent(String.valueOf(((Employee)list1.get(cont)).getCity()));
			employee.appendChild(city);
			 
			country = doc.createElement("country");
			country.setTextContent(String.valueOf(((Employee)list1.get(cont)).getCountry()));
			employee.appendChild(country);
			 
			email = doc.createElement("email");
			email.setTextContent(String.valueOf(((Employee)list1.get(cont)).getEmail()));
			employee.appendChild(email);
			 
			type = doc.createElement("type");
			type.setTextContent(String.valueOf(((Employee)list1.get(cont)).getType()));
			employee.appendChild(type);
			 
			bancCode = doc.createElement("bancCode");
			bancCode.setTextContent(String.valueOf(((Employee)list1.get(cont)).getBancCode()));
			employee.appendChild(bancCode);
			 
			phone = doc.createElement("phone");
			phone.setTextContent(String.valueOf(((Employee)list1.get(cont)).getPhone()));
			employee.appendChild(phone);
			 
			comments = doc.createElement("comments");
			comments.setTextContent(String.valueOf(((Employee)list1.get(cont)).getComments()));
			employee.appendChild(comments);
			 
			entryDate = doc.createElement("entryDate");
			entryDate.setTextContent(String.valueOf(((Employee)list1.get(cont)).getEntryDate()));
			employee.appendChild(entryDate);
			 
			outDate = doc.createElement("outDate");
			outDate.setTextContent(String.valueOf(((Employee)list1.get(cont)).getOutDate()));
			employee.appendChild(outDate);
			
			employeeCode = doc.createElement("CodigoEmpleado");
			employeeCode.setTextContent(String.valueOf(((Employee)list1.get(cont)).getEmployeeCode()));
			employee.appendChild(employeeCode);
			 

			 
			department = doc.createElement("Departamento");
			department.setTextContent(String.valueOf(((Employee)list1.get(cont)).getDepartment()));
			employee.appendChild(department);
			 
			 
			contract = doc.createElement("Contrato");
			contract.setTextContent(String.valueOf(((Employee)list1.get(cont)).getContract()));
			employee.appendChild(contract);
			 
			 
			role = doc.createElement("Rol");
			role.setTextContent(String.valueOf(((Employee)list1.get(cont)).getRole()));
			employee.appendChild(role);
			 

			 
			numberSS = doc.createElement("NúmeroSS");
			numberSS.setTextContent(String.valueOf(((Employee)list1.get(cont)).getNumberSS()));
			employee.appendChild(numberSS);
			 
			salary = doc.createElement("Salario");
			salary.setTextContent(String.valueOf(((Employee)list1.get(cont)).getSalary()));
			employee.appendChild(salary);
		 }
		
		 TransformerFactory transFabric = TransformerFactory.newInstance();
		 Transformer transformer = transFabric.newTransformer();
		 DOMSource source = new DOMSource(doc); // Crea la font XML a partir del document
		 StreamResult result = new StreamResult(new File(route)); // Crear el fitxer
		 transformer.transform(source, result); // Transformació de Document a Fitxer
		 error = 0;
		}
		catch (ParserConfigurationException e) {
		 error = -12;
		 }
		catch (DOMException e) {
		 error = -31;
		 }
		catch (TransformerException e) {
		 error = -33;
		 }
		return error;
	}
	
	
}
