/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Operations;
import Colectives.Interns.Employee;

import java.util.Date;
/**
 *
 * @author devweb
 */
public class Operation{
    
    protected int code;
    protected int type;
    protected Employee EmployeeGen;
    protected Date dataOpen, dataClose;

    public Operation(int code, int type, Employee EmployeeGen, Date dataOpen, Date dataClose) {
        this.code = code;
        this.type = type;
        this.EmployeeGen = EmployeeGen;
        this.dataOpen = dataOpen;
        this.dataClose = dataClose;
    }

    public Operation() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Employee getEmployeeGen() {
        return EmployeeGen;
    }

    public void setEmployeeGen(Employee EmployeeGen) {
        this.EmployeeGen = EmployeeGen;
    }

    public Date getDataOpen() {
        return dataOpen;
    }

    public void setDataOpen(Date dataOpen) {
        this.dataOpen = dataOpen;
    }

    public Date getDataClose() {
        return dataClose;
    }

    public void setDataClose(Date dataClose) {
        this.dataClose = dataClose;
    }

  
 
     
}
