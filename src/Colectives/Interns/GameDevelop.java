/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Interns;

/**
 *
 * @author devweb
 */
public class GameDevelop extends Employee{
    
    protected String games[];
    protected String colaborations[];

    public GameDevelop(String[] games, String[] colaborations, int employeeCode, String department, String contract, String role, String numberSS, float salary, String name, String email) {
        super(employeeCode, department, contract, role, numberSS, salary, name, email);
        this.games = games;
        this.colaborations = colaborations;
    }

    public GameDevelop() {
    }

    public String[] getGames() {
        return games;
    }

    public void setGames(String[] games) {
        this.games = games;
    }

    public String[] getColaborations() {
        return colaborations;
    }

    public void setColaborations(String[] colaborations) {
        this.colaborations = colaborations;
    }
    
}
