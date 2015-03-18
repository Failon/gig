package IODades.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import IODades.DataSource;

public class DataFile implements DataSource {
	
	protected ObjectAddOutputStream fileOut;
	protected ObjectInputStream fileIn;
	
	@Override
	public int open(String source, boolean mode) {
		int error;
		try {
			fileOut = new ObjectAddOutputStream(new FileOutputStream(source,mode));
			error = 0;
		} catch(FileNotFoundException ex) {
			error = -3;
		} catch(IOException ex){
			error = -2;
		}
		return error;
	}

	@Override
	public int close(String source) {
		// TODO Auto-generated method stub
		return 0;
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
