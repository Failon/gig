/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;

import GoodsandServices.CommercialGood;

/**
 *
 * @author devweb
 */
public interface Billable {
    
    public int getType ();
    public double getTotalPrice ();
    public int numLines ();
    public int addLine (CommercialGood cg, String newdetail);
    public String getLine (int n);
    public String getLine (String n);
    public int updateLine (int n, String newdetail);
    public int updateLine (String n, String newdetail);
    public int delLine (int n);
    public int delLine (String n); 
    
}
