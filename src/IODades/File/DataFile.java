package IODades.File;

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
	public int open(String source, int mode) {
		int error;
		try {
			switch(mode){
			case 0: //para leer
				fileIn = new ObjectInputStream(new FileInputStream(source));
				error = 0;
			break;
			case 1: //para escribir sobreescribiedo.
				fileOutCat = new ObjectAddOutputStream(new FileOutputStream(source, true));
				error = 0;
			break;
			case 2:
				fileOutOverride = new ObjectOutputStream(new FileOutputStream(source));
				error = 0;
			break;
			default:
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
	public int close(String source) {
		int error;
	
		switch(source){
		case "in":
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
				error = -1;
			}
		break;
		case "cat":
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
		case "ovr":
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
		default:
			error = -5;
		break;
		}	
		return error;
	}

	@Override
	public int importdades(ArrayList dades, String source) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int exportdades(ArrayList dades, String source, int mode) {
		// TODO Auto-generated method stub
		return 0;
	}

}
