/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Products;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class Game extends Products{
    protected String gametype, requirements;
    protected int minimalAge, maxplayers;
       
    public Game() {

	}
    

	public Game(float lenght, float weigth, float width, float high,
			float indexRating, String manufacturer, String model,
			String series, String content, String reviews, Date releaseDate,
			String Name, String Description, String Category,
			String InternalComments, float Price, int Code, String gametype,
			String requirements, int minimalAge, int maxplayers) {
		super(lenght, weigth, width, high, indexRating, manufacturer, model,
				series, content, reviews, releaseDate, Name, Description,
				Category, InternalComments, Price, Code);
		this.gametype = gametype;
		this.requirements = requirements;
		this.minimalAge = minimalAge;
		this.maxplayers = maxplayers;
	}



	public String getGametype() {
        return gametype;
    }

    public void setGametype(String gametype) {
        this.gametype = gametype;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
    }

    public int getMaxplayers() {
        return maxplayers;
    }

    public void setMaxplayers(int maxplayers) {
        this.maxplayers = maxplayers;
    }
}
