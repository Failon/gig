/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Interns;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class GameDevelop extends Employee{
    
    protected String games[];
    protected String colaborations[];

    public GameDevelop(String name, String code, String address,
			String postalcode, String city, String country, String email,
			String type, String bancCode, String phone, String comments,
			Date entryDate, Date outDate, int employeeCode, String department,
			String contract, String role, String numberSS, float salary,
			String[] games, String[] colaborations) {
		super(name, code, address, postalcode, city, country, email, type,
				bancCode, phone, comments, entryDate, outDate, employeeCode,
				department, contract, role, numberSS, salary);
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
