package CheckData;
import java.util.ArrayList;

public class StringsStack {
	private int mida;    
	private ArrayList<String> pila;
 
    public void Pila() {
         pila = new ArrayList<String>();
         mida = 0;
     }
    /**
     * @return Retorna false si la pila resta buida, true en cas contrari
     */
    public boolean pilaBuida () {
         if (mida == 0) {
             return true;
         }
         return false;
     }
 
    public void push (String n ) {
         
    	if (n != null)
    	{	
    		pila.add(n);
    		mida++;
    	}
     }
    
 /**
  * @return Retorna un null si la pila resta buida, sino un objecte de tipus Integer 
  */
    public String pop () {
      
        if(pilaBuida())
           return null;
        else {
        	mida--;
        	return pila.get(mida);
        }
     }
    
    /**
     * @return Retorna el nombre d'elements de la pila 
     */
    public int getNumElements() {
         return mida;
     }    
}
