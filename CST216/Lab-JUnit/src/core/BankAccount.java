package core;

import java.util.*;


/**
 * 
 * @author Hieu Pham	HQPHAM
 * 
 * Create a new eclipse project titled Lab-JUnit. Create 
 * BankAccount class under package core. It should have 
 * the following attributes and methods:
 * accountNumber,	String
 * accountHolder,	String
 * balance,			double
 * accountType,		int
 * 1 = Savings, 2 = Award Savers, 3 = Checking, 4 = Credit Card, Default = 0
 * 
 * Two constructors: Default constructor sets balance to 0.00, accountType to 0,
 * accountNumber to "none", accountHolder to "Unknown". Other constructor accepts
 * user-entered values for all attributes.
 * 
 * Getters and Setters (use Eclipse to automatically generate them.)
 * 
 * Method calculateTotalBalance() returns the balance of the account after the 
 * interest has been applied. Formula for calculating the balance is:
 * totalBalance = balance + (balance * interestRate/100.00).
 * 
 * The interest rates, depend on the values of accountType.
 * Savings: 			0.5%
 * Award Savers:		4.5%
 * Checking:			2.0%
 * Credit Card:			15.0%
 * Other:				0.0%
 * 
 * Method getInterestRate() returns the interest rate depending on the type of account.
 * 
 */
@SuppressWarnings("unused")
public class BankAccount {

    /**
     * Instance variables.
     * category	Instance variables
     * param	accountNumber	String
     * param	accountHolder	String
     * param	balance			double
     * param	accountType		int
     */
	String accountNumber;
    String accountHolder;
    double balance;
    int accountType;

    /**
     * category	Default constructor
     * param	None
     */
    public BankAccount() {
         balance=0;
         accountType=0;
         accountNumber="none";
         accountHolder="Unknown";
    }

    /**
     * category	Parameterized constructor
     * @param 	accNum	Account number
     * @param 	accHold	Account holder
     * @param 	bal		balance
     * @param 	accType	Account type
     * return	None
     */
    public BankAccount(String accNum,String accHold,double bal,int accType) {
         balance=bal;
         accountType=accType;
         accountNumber=accNum;
         accountHolder=accHold;
    }

    /**
     * category	Accessors
     * @return		accountNumber
     */
    public String getAccountNumber() {
         return accountNumber;
    }

    /**
     * category	Accessors
     * @param	accountNumber	String		
     */
    public void setAccountNumber(String accountNumber) {
         this.accountNumber = accountNumber;
    }

    /**
     * category	Accessors
     * @return	accountHolder	String		
     */
    public String getAccountHolder() {
         return accountHolder;
    }

    /**
     * category	Accessors
     * @param	accountHolder	String		
     */
    public void setAccountHolder(String accountHolder) {
         this.accountHolder = accountHolder;
    }

    /**
     * category	Accessors
     * @return	balance	double	
     */
    public double getBalance() {
         return balance;
    }

    /**
     * category	Accessors
     * @param	balance	double		
     */
    public void setBalance(double balance) {
         this.balance = balance;
    }

    /**
     * category	Accessors
     * @return	accountType	int	
     */
    public int getAccountType() {
         return accountType;
    }

    /**
     * category	Accessors
     * @param	accountType	int		
     */
    public void setAccountType(int accountType) {
         this.accountType = accountType;
    }

    /**
     * @author Hieu Pham
     * category	calculateTotalBalance()
     * param	None	There is no parameter required for this method
     * @return	totalBalance	double
     */
    double calculateTotalBalance() {
         double totalBalance;
         totalBalance = balance + (balance * getInterestRate()/100.00);

         return totalBalance;
    }

    /**
     * @author Hieu Pham
     * category	getInterestRate()
     * param	None	There is no parameter required for this method
     * @return	x	double
     */
    double getInterestRate() {
         double x;
         int aType = this.getAccountType();
         
         switch(aType) {
	         case 1:
	             x=0.50;
	         	 break;
	         case 2:
	             x=4.50;
	         	 break;
	         case 3:
	             x=1.00;
	         	 break;
	         case 4:
	             x=15.0;
	         	 break;
	         default:
	             x=0.0;
	         	 break;         
         }         
         return x;
    }     

    /**
     * @author Hieu Pham
     * Method:	type()
     * param	None	There is no parameter required for this method
     * @return	bType	String
     */
    String type() {
    	int aType = this.getAccountType();
    	String bType;
    	
    	switch(aType) {
        case 1:
        	 bType = "Savings";
        	 break;
        case 2:
        	 bType = "Award Savers";
        	 break;
        case 3:
        	 bType = "Checking";
        	 break;
        case 4:
        	 bType = "Credit Card";
        	 break;
        default:
        	 bType = "None";
        	 break;         
    	}
    	
    	return bType;
    }
   
}
