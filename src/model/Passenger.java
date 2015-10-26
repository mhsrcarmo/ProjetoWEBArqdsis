package model;

public class Passenger {
	private String CPF, treatmentClient, nameClient, lastNameClient,
			emailClient, birthDate, telephoneClient;
	private int clientId;

	public Passenger() {}

	public Passenger(String cPF, String treatmentClient, String nameClient,
			String lastNameClient, String emailClient, String birthDate,
			String telephoneClient) {
		super();
		CPF = cPF;
		this.treatmentClient = treatmentClient;
		this.nameClient = nameClient;
		this.lastNameClient = lastNameClient;
		this.emailClient = emailClient;
		this.birthDate = birthDate;
		this.telephoneClient = telephoneClient;
		this.clientId = clientId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getTreatmentClient() {
		return treatmentClient;
	}

	public void setTreatmentClient(String treatmentClient) {
		this.treatmentClient = treatmentClient;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public String getLastNameClient() {
		return lastNameClient;
	}

	public void setLastNameClient(String lastNameClient) {
		this.lastNameClient = lastNameClient;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}

	@Override
	public String toString() {
		return "Passenger [CPF=" + CPF + ", treatmentClient=" + treatmentClient
				+ ", nameClient=" + nameClient + ", lastNameClient="
				+ lastNameClient + ", emailClient=" + emailClient
				+ ", birthDate=" + birthDate + ", telephoneClient="
				+ telephoneClient + "]";
	}

}