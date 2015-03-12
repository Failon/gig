/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CommercialGood.Services;

import java.util.Date;

/**
 *
 * @author devweb
 */
public class Transport extends Services{
    protected float distance;
    protected String Status;

    public Transport() {
    }

    public Transport(float distance, String Status, Date StartDate, Date EndDate, String Rate) {
        super(StartDate, EndDate, Rate);
        this.distance = distance;
        this.Status = Status;
    }

    

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
}
