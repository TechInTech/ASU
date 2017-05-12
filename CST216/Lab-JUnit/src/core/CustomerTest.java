package core;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



public class CustomerTest {
	
	private Customer cATester;
	private String Name = "Jesse James";
	private String sAddress = "19103 Airport Way S";
	private String City = "Everett";
	private String State = "WA";
	private String zipCode = "98205";
	private int Age = 64;
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		
		cATester = new Customer(Name,sAddress,City,State,zipCode,Age);
	}

	@After
	public void tearDown() throws Exception {		
		cATester = null;
	}

	@Test
	public final void testDisplayAddress() {
		String actValue = (cATester.streetAddress + ",\n" + cATester.city + ", " + cATester.state + ", " + cATester.zip);
		String expValue = (sAddress + ",\n" + City + ", " + State + ", " + zipCode);
		assertEquals(expValue, actValue);
	}

	@Test
	public final void testDisplayAddressLabel() {
		String actValue = (cATester.name + ", " + cATester.age + ",\n" + cATester.streetAddress + ",\n" + cATester.city + ", " 
				+ cATester.state + ", " + cATester.zip);
		String expValue = (Name + ", " + Age + ",\n" + sAddress + ",\n" + City + ", " + State + ", " + zipCode);
		assertEquals(expValue, actValue);
	}

}
