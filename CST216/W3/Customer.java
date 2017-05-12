public class Customer {

	String name;
	String streetAddress;
	String city;
	String state;
	String zip;
	int age;  

	public Customer(String n,String s,String c,String st,String z,int a) {
		name = n;
		streetAddress = s;
		city=c;
		state=st;
		zip=z;
		age=a;
	}

  

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void displayAddress() {
		System.out.println(streetAddress+",\n"+state+",\n"+city+",\n"+zip);
	}

	public void displayAddressLabel() {
		System.out.println(name+",\n"+streetAddress+",\n"+state+",\n"+city+",\n"+zip);
	}

}//Close the class