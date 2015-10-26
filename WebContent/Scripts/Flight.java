/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Rodrigo
 */
public class Flight {
    
    private int flightID;
    private int airplaneID;
    private String boardingFlight;
    private String landingFlight;
    private String timeFlight;
    private BigDecimal priceFlight;
    private int qtySeatsAvailable;

    
    
    public Flight(){
        
    }

    public Flight(int airplaneID, String boardingFlight, String landingFlight, String timeFlight, BigDecimal priceFlight) {
        this.airplaneID = airplaneID;
        this.boardingFlight = boardingFlight;
        this.landingFlight = landingFlight;
        this.timeFlight = timeFlight;
        this.priceFlight = priceFlight;
    }
    
    
    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getBoardingFlight() {
        return boardingFlight;
    }

    public void setBoardingFlight(String boardingFlight) {
        this.boardingFlight = boardingFlight;
    }

    public String getLandingFlight() {
        return landingFlight;
    }

    public void setLandingFlight(String landingFlight) {
        this.landingFlight = landingFlight;
    }

    public String getTimeFlight() {
        return timeFlight;
    }

    public void setTimeFlight(String timeFlight) {
        this.timeFlight = timeFlight;
    }

    public BigDecimal getPriceFlight() {
        return priceFlight;
    }

    public void setPriceFlight(BigDecimal priceFlight) {
        this.priceFlight = priceFlight;
    }
   
    public int getQtySeatsAvailable() {
        return qtySeatsAvailable;
    }

    public void setQtySeatsAvailable(int qtySeatsAvailable) {
        this.qtySeatsAvailable = qtySeatsAvailable;
    }
}
