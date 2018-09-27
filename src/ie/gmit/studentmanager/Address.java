package ie.gmit.studentmanager;

public class Address {
	//Instance variables
	private int houseNumber;	//House number
	private String street;		//Street name
	private String county;		//County name
	private String eirCode;		//Address eircode
	
	public Address(int houseNumber, String street, String county, String eirCode) {
		this.houseNumber = houseNumber;
		this.street = street;
		this.county = county;
		this.eirCode = eirCode;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEirCode() {
		return eirCode;
	}

	public void setEirCode(String eirCode) {
		this.eirCode = eirCode;
	}
}
