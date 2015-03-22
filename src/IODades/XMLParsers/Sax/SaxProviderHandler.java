package IODades.XMLParsers.Sax;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import Colectives.Externs.Provider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SaxProviderHandler extends DefaultHandler{


	 private final XMLReader saxReader;
	 private final ArrayList llista;
	 private int numProviders=0;
	 String valor;
	 SimpleDateFormat mydateformat = new SimpleDateFormat("dd/MM/yyyy");
	 
	 public SaxProviderHandler(ArrayList providers) throws SAXException {
	 llista = providers;
	 saxReader = XMLReaderFactory.createXMLReader();
	 saxReader.setContentHandler(this);
	 saxReader.setErrorHandler(this);
	 }
	 @Override
	 public void startDocument() { //aqui es poden especificar les accions al inici del document
	 //System.out.println("Inici del Document XML"); //per revisio de tasca
	 }
	 @Override
	 public void endDocument() { //aqui es poden especificar les accions al final del document
	 //System.out.println("Fi del Document XML"); //per revisio de tasca
	 }
	 @Override //lectura dels valors dels elements
	 public void characters(char[] contingut, int ini, int fi) throws SAXException {
	 valor = new String(contingut, ini, fi);
	 } 
	 @Override
	 public void startElement(String uri, String name, String qName, Attributes atts) {
	 /* //Per mostrar com es carregarien els atributs dels nodes
	 for (int i = 0; i < atts.getLength(); i++) {
	 System.out.print("Atributs : " + atts.getLocalName(i) + " = " + atts.getValue(i));
	 }*/
	 //System.out.print("\n Afegint Element: " + name + ". " );
	 if (name.equals("Provider")) { //trobem un element de classe element
	 llista.add (new Provider());
	 }
	 }
	 @Override
	 public void endElement(String uri, String name, String qName) {
	 //System.out.print (" Valor= " + valor + " Fi Element: " + name); //per revisio de tasca

	 if (name.equals("nombre")) {
	 ((Provider)llista.get(numProviders)).setName(valor);
	 }
	 if (name.equals("codigo")) {
	 ((Provider)llista.get(numProviders)).setCode(valor);
	 }
	 if (name.equals("Direccion")) {
	 ((Provider)llista.get(numProviders)).setAddress(valor);
	 }
	 if (name.equals("codigopostal")) {
	 ((Provider)llista.get(numProviders)).setPostalcode(valor);
	 }
	 if (name.equals("ciudad")) {
	 ((Provider)llista.get(numProviders)).setCity(valor);
	 }
	 if (name.equals("pais")) {
	 ((Provider)llista.get(numProviders)).setCountry(valor);
	 }
	 if (name.equals("email")) {
	 ((Provider)llista.get(numProviders)).setEmail(valor);
	 }
	 if (name.equals("tipo")) {
	 ((Provider)llista.get(numProviders)).setType(valor);
	 }
	 if (name.equals("codigoBancario")) {
	 ((Provider)llista.get(numProviders)).setBancCode(valor);
	 }
	 if (name.equals("telefono")) {
	 ((Provider)llista.get(numProviders)).setPhone(valor);
	 }
	 if (name.equals("comentarios")) {
	 ((Provider)llista.get(numProviders)).setComments(valor);
	 }
	 if (name.equals("fechaEntrada")) {
	 try {
		((Provider)llista.get(numProviders)).setEntryDate(mydateformat.parse(valor));
	 } catch (ParseException e) {
		((Provider)llista.get(numProviders)).setEntryDate(null);
	 }
	 }
	 if (name.equals("fechaSalida")) {
	 try {
			((Provider)llista.get(numProviders)).setOutDate(mydateformat.parse(valor));
		 } catch (ParseException e) {
			((Provider)llista.get(numProviders)).setOutDate(null);
		 }	 
	 }
	 if (name.equals("fax")) {
	 ((Provider)llista.get(numProviders)).setFax(valor);
	 }
	 if (name.equals("sitioweb")) {
	 ((Provider)llista.get(numProviders)).setWebsite(valor);
	 }
	 if (name.equals("CUIT")) {
	 ((Provider)llista.get(numProviders)).setCUIT(valor);
	 }
	 if (name.equals("nombreCorporaivo")) {
	 ((Provider)llista.get(numProviders)).setCorporateName(valor);
	 }
	 if (name.equals("DireccionEntrega")) {
	 ((Provider)llista.get(numProviders)).setDelivAddress(valor);
	 }
	 if (name.equals("CodigoPostalEntrega")) {
	 ((Provider)llista.get(numProviders)).setDelivPostalcode(valor);
	 }
	 if (name.equals("ciudadEntrega")) {
	 ((Provider)llista.get(numProviders)).setDelivCity(valor);
	 }
	 if (name.equals("paisEntrega")) {
	 ((Provider)llista.get(numProviders)).setDelivCountry(valor);
	 }
	 if (name.equals("codigoCompany")) {
	 ((Provider)llista.get(numProviders)).setCompanyCode(Integer.valueOf(valor));
	 }
	 if (name.equals("descuento")) {
	 ((Provider)llista.get(numProviders)).setDiscount(Float.valueOf(valor));
	 }
	 if (name.equals("tipoProveedor")) {
	 ((Provider)llista.get(numProviders)).setTypeProvider(Integer.valueOf(valor));
	 }
	 if (name.equals("TipoRecurso")) {
	 ((Provider)llista.get(numProviders)).setTypeResource(valor);
	 }
	 if (name.equals("Provider")) { //acabem amb la lectura d'un objecte de classe Client
	 numProviders++;
	 }
	 }
	}
	
