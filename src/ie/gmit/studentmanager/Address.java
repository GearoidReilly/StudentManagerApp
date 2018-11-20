package ie.gmit.studentmanager;

import java.io.Serializable;

public class Address implements Serializable{
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

	/**
	 * Gets the house number of this address
	 * @return houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}

	/**
	 * Sets a house number to this address
	 * @param houseNumber New houseNumber
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	/**
	 * Gets the address street
	 * @return street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * Sets a street to this address
	 * @param street New street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * Gets the County on this address
	 * @return county
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * Sets a county to this address
	 * @param county New county
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * Gets the eir code of this address
	 * @return eirCode
	 */
	public String getEirCode() {
		return eirCode;
	}

	/**
	 * Sets an eircode to this address
	 * @param eirCode New eirCode
	 */
	public void setEirCode(String eirCode) {
		this.eirCode = eirCode;
	}
}
