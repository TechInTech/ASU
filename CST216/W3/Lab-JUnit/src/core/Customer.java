package core;

/**
 * 
 * @author Hieu Pham	HQPHAM
 * Class name:	Customer
 * Fields:	name	String
 * 			city	String
 * 			state	String
 * 			zip		String
 * 			age		String
 * 
 * Parameterized Constructor with name and address values and set the attributes
 * Accessors to set and get these attributes
 * 
 * Method displayAddress() that returns a string that has complete formatted address
 * with street address, city, state, and zip code (free form.)
 * 
 * Method displayAddressLabel() that returns a string that has the customer's name 
 * along with the complete formatted address (free form.)
 * 
 * Create a TestCase class titled CustomerTest to test the displayAddress() and 
 * displayAddressLabel() methods. Add this test case to LabTestSuite and run the tests.
 * 
 * Make sure all tests are successful.
 *
 */
public class Customer {

	String name;
	String streetAddress;
	String city;
	String state;
	String zip;
	int age;  
	
	/**
	 * Parameterized Constructor
	 * @param nme	String
	 * @param sA	String
	 * @param ct	String
	 * @param ste	String
	 * @param zc	String
	 * @param aj	int
	 */
	public Customer(String nme,String sA,String ct,String ste,String zc,int aj) {
		this.name = nme;
		this.streetAddress = sA;
		this.city=ct;
		this.state=ste;
		this.zip=zc;
		this.age=aj;
	}

	/**
	 * 
	 * @return	this.name	String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name	String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return	this.streetAddress	String
	 */
	public String getStreetAddress() {
		return this.streetAddress;
	}

	/**
	 * 
	 * @param streetAddress	String
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	/**
	 * 
	 * @return	this.city	String
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * 
	 * @param city	String
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return	this.state	String
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * 
	 * @param state		String
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return	this.zip	String
	 */
	public String getZip() {
		return this.zip;
	}

	/**
	 * 
	 * @param zip	String
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * 
	 * @return	this.age	int
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * 
	 * @param age	int
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Display the address without customer's name
	 * Calls System.out.println() method
	 */
	public void displayAddress() {
		System.out.println(this.streetAddress + ",\n" + this.city + ", " + this.state + ", " + this.zip);
	}

	/**
	 * Display the address with customer's name
	 * Calls System.out.println() method
	 */
	public void displayAddressLabel() {
		System.out.println(this.name + ", " + this.age + ",\n" + this.streetAddress + ",\n" + this.city + ", " 
				+ this.state + ", " + this.zip);
	}

}//Close the class
