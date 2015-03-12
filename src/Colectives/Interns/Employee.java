/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Interns;
import java.util.Date; //para que funcionen los datos
import Colectives.Person;

/**
 *
 * @author devweb
 */
public class Employee extends Person{
    
    int employeeCode;
    protected String department, contract, role, numberSS;
    protected float salary;

    public Employee(int employeeCode, String department, String contract, String role, String numberSS, float salary, String name, String email) {
        super(name, email);
        this.employeeCode = employeeCode;
        this.department = department;
        this.contract = contract;
        this.role = role;
        this.numberSS = numberSS;
        this.salary = salary;
    }

    public Employee() {
    }

    public int getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(int employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNumberSS() {
        return numberSS;
    }

    public void setNumberSS(String numberSS) {
        this.numberSS = numberSS;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    
}
