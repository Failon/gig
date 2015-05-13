/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Products;


/**
 *
 * @author devweb
 */
public class VideoGames extends Game {
     protected String plataforms, edition;
     protected boolean online;
     protected int PEGI;

    public VideoGames(String plataforms, String edition, boolean online, int PEGI) {
        this.plataforms = plataforms;
        this.edition = edition;
        this.online = online;
        this.PEGI = PEGI;
    }

    public VideoGames() {
    }

	public String getPlataforms() {
		return plataforms;
	}

	public void setPlataforms(String plataforms) {
		this.plataforms = plataforms;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public int getPEGI() {
		return PEGI;
	}

	public void setPEGI(int pEGI) {
		PEGI = pEGI;
	}

    
}
