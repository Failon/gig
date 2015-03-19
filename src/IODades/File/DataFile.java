package IODades.File;

<<<<<<< HEAD
import java.io.EOFException;
=======
>>>>>>> origin/master
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import IODades.DataSource;

public class DataFile implements DataSource {
	
	protected ObjectAddOutputStream fileOutCat;
	protected ObjectOutputStream fileOutOverride;
	protected ObjectInputStream fileIn;
	
	@Override
<<<<<<< HEAD
	public int open(String source, int mode) { //para abrir archivos.
=======
	public int open(String source, int mode) {
>>>>>>> origin/master
		int error;
		try {
			switch(mode){
			case 0: //para leer
				fileIn = new ObjectInputStream(new FileInputStream(source));
				error = 0;
			break;
<<<<<<< HEAD
			case 1: //para escribir a continuacion.
				fileOutCat = new ObjectAddOutputStream(new FileOutputStream(source, true));
				error = 0;
			break;
			case 2: //para escribir sobreescribiendo.
				fileOutOverride = new ObjectOutputStream(new FileOutputStream(source));
				error = 0;
			break;
			default: //cualquier metodo no soportado provocara un error de parametro incorrecto.
=======
			case 1: //para escribir sobreescribiedo.
				fileOutCat = new ObjectAddOutputStream(new FileOutputStream(source, true));
				error = 0;
			break;
			case 2:
				fileOutOverride = new ObjectOutputStream(new FileOutputStream(source));
				error = 0;
			break;
			default:
>>>>>>> origin/master
				error = -5;
			break;
			}
			
		} catch(FileNotFoundException ex) {
			error = -1;
		} catch(IOException ex){
			error = -666;
		}
		return error;
	}

	@Override
<<<<<<< HEAD
	public int close(String source) { //para cerrar ficheros.
		int error;
	
		switch(source){
		case "in": //cerrar ficheros de tipo lectura
=======
	public int close(String source) {
		int error;
	
		switch(source){
		case "in":
>>>>>>> origin/master
			if(fileIn!=null){	     
	            try {            	                
	               fileIn.close();
	               error = 0;
	            }catch (FileNotFoundException ex) {
	                error = -1;     
	            } catch (IOException ex) {
	               error=-666;
	            }				
			}
			else {
<<<<<<< HEAD
				error = -1; //si el fichero está a null, es que mo si no existiera por tanto lanzamos -1 de FileNotFoundException.
			}
		break;
		case "cat": //para cerrar ficheros de añadido.
=======
				error = -1;
			}
		break;
		case "cat":
>>>>>>> origin/master
			if(fileOutCat!=null){	     
	            try {            	                
	               fileOutCat.close();
	               error = 0;
	            }catch (FileNotFoundException ex) {
	                error = -1;     
	            } catch (IOException ex) {
	               error=-666;
	            }				
			}
			else {
				error = -1;
			}
		break;
<<<<<<< HEAD
		case "ovr": //para cerrar objetos sobreescritos.
=======
		case "ovr":
>>>>>>> origin/master
			if(fileOutOverride!=null){
				try{
					fileOutOverride.close();
					error = 0;
				}catch (FileNotFoundException ex){
					error = -1;
				}catch (IOException ex) {
					error = -666;
				}
			}
			else {
				error = -1;
			}
		break;
<<<<<<< HEAD
		default: //cualquier otro parametro no está soportado y lanza un error de parametro incorrecto.
=======
		default:
>>>>>>> origin/master
			error = -5;
		break;
		}	
		return error;
	}

	@Override
	public int importdades(ArrayList dades, String source) { //para importar datos de un archivo.
		int error = open(source, 0); //abrimos el fichero de tipo lectura y nos guardamos el error que en caso de ser diferente de 0, será devuelto por esta funcion
		if(error == 0){ //si la apertura se ha ejecutado con exito...
			try{
				while(true){
					dades.add(fileIn.readObject()); //añadimos objetos al archivo hasta que acabe el archivo.
				}
			} catch(EOFException ex){ //cuando acabe el archivo manejaremos el error, ya que es algo que debe ocurrir siempre y lanzaremos un 0.
				error = 0;		
			} catch (ClassNotFoundException ex) {
				error = -2;
			} catch (IOException ex) {
				error = -666;
			}
		}
		close("in"); //cerramos el archivo de tipo lectura.
		
		return error;
		
	}

	@Override
	public int exportdades(ArrayList dades, String source, int mode) {//para exportar datos a archivos.
		int error;
		switch(mode){
		case 1: //modo añadir.
			error = open(source, mode); //intentamos abrir el archivo, si no se puede lanzaremos el error.
			if(error == 0){ //si la apertura se ha realizado con exito.
			try{
				for(int i=0;i<dades.size();i++){ //recorremos el arrayList y vamos añadiendo lineas al archivo.
					fileOutCat.writeObject(dades.get(i));
				}
			} catch(FileNotFoundException ex){ 
				error = -1;
			} catch (IOException ex) {
				error = -666;
			}
			close("cat"); //cerramos el archivo de tipo añadir.
			}
		break;
		case 2: //modo sobreescrivir.
			error = open(source, mode); //intentamos abrir el archivo, si no se puede lanzaremos el error.
			if(error == 0){ //si la apertura se ha realizado con exito.
			try{
				for(int i=0;i<dades.size();i++){ //recorremos el arrayList y vamos añadiendo lineas al archivo.
					fileOutOverride.writeObject(dades.get(i));
				}
			} catch(FileNotFoundException ex){
				error = -1;
			} catch (IOException ex) {
				error = -666;
			}
			close("ovr"); //cerramos el archivo tipo sobreescribir.
			}
		break;
		default:
			error = -5; //si los metodos no eran ni 1 ni 2, lanzamos un error de tipo parametros incorrectos.
		break;
		}
		return error;
	}

}
