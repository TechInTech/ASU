package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import core.BankAccountTest;
import core.CustomerTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	BankAccountTest.class,
	CustomerTest.class})
public class LabTestSuite {

}

//Test Runner class?