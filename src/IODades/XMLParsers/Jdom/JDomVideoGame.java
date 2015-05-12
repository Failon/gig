package IODades.XMLParsers.Jdom;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom2.Document; //imports de JDOM
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.jdom2.output.Format;

import CommercialGood.Products.VideoGames;
import IODades.DataSource;



public class JDomVideoGame implements DataSource {
	protected SAXBuilder builder ; //Classe per crear un document JDOM
	protected Document document; // classe que representa el document
	protected Element rootNode, node; // node arrel
	protected List subnodes; // llista de subnodes
	protected XMLOutputter jdomToXML;
	@Override
	public int open(String source, int mode) {
		// Not used.
		return 0;
	}
	@Override
	public int close(String source) {
		//Not used.
		return 0;
	}
	@Override
	public int importdades(ArrayList dades, String source) {
		int error = 0;
		
		try { // Lectura Document XML amb JDOM
			 builder = new SAXBuilder(); //Classe per crear un document JDOM
			 document = (Document)builder.build(source); //el crea
			 rootNode = document.getRootElement(); //agafa el node arrel
			 //fem la llista de subnodes del node arrel amb un determinat nom
			 subnodes = rootNode.getChildren("client");
			 for ( int i = 0; i < subnodes.size(); i++) {
			 node = (Element)subnodes.get(i); //accedim als nodes de la llista
			 int longitud = node.getChild("Plataformas").getChildren("Plataforma").size();
			 String[] Plataformas = new String[longitud]; //determino cuantas plataformas tiene el juego.
			 dades.add(new VideoGames());
			 // accedirem als subnodes a traves del seu nom
			 ((VideoGames) dades.get(i)).setName(node.getChildText("Nombre"));
			 ((VideoGames) dades.get(i)).setDescription(node.getChildText("Descripcion"));
			 ((VideoGames) dades.get(i)).setCategory(node.getChildText("Categoria"));
			 ((VideoGames) dades.get(i)).setPrice(Float.valueOf(node.getChildText("Precio")));
			 ((VideoGames) dades.get(i)).setCode(Integer.valueOf(node.getChildText("Codi")));
			 ((VideoGames) dades.get(i)).setGametype(node.getChildText("TipoJuego"));
			 ((VideoGames) dades.get(i)).setRequirements(node.getChildText("Requisitos"));
			 ((VideoGames) dades.get(i)).setPEGI(Integer.valueOf(node.getChildText("PEGI")));
			 ((VideoGames) dades.get(i)).setMaxplayers(Integer.valueOf(node.getChildText("maximosJugadores")));
			 ((VideoGames) dades.get(i)).setEdition(node.getChildText("Edicion"));
			 ((VideoGames) dades.get(i)).setPlataforms(node.getChildText("Plataformas"));			
			 } 
			} catch (JDOMException ex){
				error = -31;
			 
			} catch (FileNotFoundException ex){
				error = -1;
			}
			catch (IOException ex){
				error = -666;
			}
		return error;
	}
	@Override
	public int exportdades(ArrayList dades, String source, int mode) {
		int error = 0;
		try { // Escriptura Document XML amb JDOM
			 document = new Document();
			 rootNode = new Element("VideoGames");
			 document.setRootElement(rootNode);
			 for ( int i=0 ; i < dades.size() ; i++)
			 {
			 node = new Element ("Game");
			 node.addContent(new Element ("Nombre").setText(((VideoGames)dades.get(i)).getName()));
			 node.addContent(new Element ("Descripcion").setText(((VideoGames)dades.get(i)).getDescription()));
			 node.addContent(new Element ("Categoria").setText(((VideoGames)dades.get(i)).getCategory()));
			 node.addContent(new Element ("Precio").setText(String.valueOf(((VideoGames) dades.get(i)).getPrice())));
			 node.addContent(new Element ("Codi").setText(String.valueOf(((VideoGames) dades.get(i)).getCode())));
			 node.addContent(new Element ("TipoJuego").setText(((VideoGames)dades.get(i)).getGametype()));
			 node.addContent(new Element ("Requisitos").setText(((VideoGames)dades.get(i)).getRequirements()));
			 node.addContent(new Element ("PEGI").setText(String.valueOf(((VideoGames) dades.get(i)).getPEGI())));
			 node.addContent(new Element ("maximosJugadores").setText(String.valueOf(((VideoGames) dades.get(i)).getMaxplayers())));
			 node.addContent(new Element ("Edicion").setText(((VideoGames)dades.get(i)).getEdition()));
			 node.addContent(new Element ("Plataformas").setText(((VideoGames)dades.get(i)).getPlataforms()));
			 rootNode.addContent(node);
			 
			 }
			 jdomToXML = new XMLOutputter(); //crearem l'objecte que realitzarà la transformació
			 jdomToXML.setFormat(Format.getPrettyFormat()); //format de presentació
			 jdomToXML.output(document, new FileWriter(source));
			} catch (FileNotFoundException ex) {
				error = -1;
			} catch (IOException ex) { 
				error = -666;
			} 	
		return error;
	}
	
	
}
