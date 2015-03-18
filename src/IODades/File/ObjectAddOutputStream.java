package IODades.File;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectAddOutputStream extends ObjectOutputStream {
    /** Constructor que rep OutputStream */
    public ObjectAddOutputStream(OutputStream out) throws IOException
    {
        super(out);
          
    }

    /** Constructor sense paràmetres */
    public ObjectAddOutputStream() throws IOException, SecurityException
    {
        super();
    }

    /** Redefinició del métode que escriu la capcelera per que no ho faci*/
    protected void writeStreamHeader() throws IOException
    {
    } 
}
