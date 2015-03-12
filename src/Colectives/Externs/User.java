/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Colectives.Externs;

/**
 *
 * @author devweb
 */
public class User {
    
    protected String nick, email, password, hits[];  //hits=logros
    protected int credits, gamescode[], levelgame[];
    //gamescode y levelgame son provisionales
    //la forma de representarlos son con objetos de una clase
    //auxiliar y especifica, donde aparece ranking, 

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getHits() {
        return hits;
    }

    public void setHits(String[] hits) {
        this.hits = hits;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int[] getGamescode() {
        return gamescode;
    }

    public void setGamescode(int[] gamescode) {
        this.gamescode = gamescode;
    }

    public int[] getLevelgame() {
        return levelgame;
    }

    public void setLevelgame(int[] levelgame) {
        this.levelgame = levelgame;
    }
    
}
