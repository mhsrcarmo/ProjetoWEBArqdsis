package model;


public class Airplane{
	
	private int airplaneID,airCompanyID,qtySeats;
	private String modelAirplane;

	public Airplane() {
		
	}	
	
	public Airplane(int airplaneID, int airCompanyID, int qtySeats,
			String modelAirplane) {
		super();
		this.airplaneID = airplaneID;
		this.airCompanyID = airCompanyID;
		this.qtySeats = qtySeats;
		this.modelAirplane = modelAirplane;
	}



	public int getAirplaneID() {
		return airplaneID;
	}

	public int getAirCompanyID() {
		return airCompanyID;
	}

	public int getQtySeats() {
		return qtySeats;
	}

	public String getModelAirplane() {
		return modelAirplane;
	}

	public void setAirplaneID(int airplaneID) {
		this.airplaneID = airplaneID;
	}

	public void setAirCompanyID(int airCompanyID) {
		this.airCompanyID = airCompanyID;
	}

	public void setQtySeats(int qtySeats) {
		this.qtySeats = qtySeats;
	}

	public void setModelAirplane(String modelAirplane) {
		this.modelAirplane = modelAirplane;
	}



	@Override
	public String toString() {
		return "Flight [airplaneID=" + airplaneID + ", airCompanyID="
				+ airCompanyID + ", qtySeats=" + qtySeats + ", modelAirplane="
				+ modelAirplane + "]";
	}

	



}
