package core;

import java.util.*;

public class BankAccount

{

    //instance variables

    String accountNumber;

    String accountHolder;

    double balance;

    int accountType;

    //default constructor

    public BankAccount()

    {

         balance=0;

         accountType=0;

         accountNumber="none";

         accountHolder="Unknown";

    }

    //parameterised constructor

    public BankAccount(String accNum,String accHold,double bal,int accType)

    {

         balance=bal;

         accountType=accType;

         accountNumber=accNum;

         accountHolder=accHold;

    }

    //getters and setters

    public String getAccountNumber()

    {

         return accountNumber;

    }

    public void setAccountNumber(String accountNumber)

    {

         this.accountNumber = accountNumber;

    }

    public String getAccountHolder()

    {

         return accountHolder;

    }

    public void setAccountHolder(String accountHolder)

    {

         this.accountHolder = accountHolder;

    }

    public double getBalance()

    {

         return balance;

    }

    public void setBalance(double balance)

    {

         this.balance = balance;

    }

    public int getAccountType()

    {

         return accountType;

    }

    public void setAccountType(int accountType)

    {

         this.accountType = accountType;

    }

   //calculateTotalBalance method

    //computes the final balance after adding

    //interest

    double calculateTotalBalance ()

    {

         double totalBalance;

         totalBalance = balance + (balance * getInterestRate()/100);

         return totalBalance;

    }

    //getInterestRate method

    //depending on the account type

    //returns the interest value

    double getInterestRate()

    {  

         double x;

         if(getAccountType()==1)

             x=0.50;

         else if(getAccountType()==2)

             x= 4.50;

         else if(getAccountType()==3)

             x=1.00;

         else if(getAccountType()==4)

             x= 15;

         else

             x= 0;

         return x;

    }     

    //type method that returns the

    //string value depending on

    //the type of account

    String type()

    {

         if(getAccountType()==1)

             return "Savings";

         else if(getAccountType()==2)

             return "Award Savers";

         else if(getAccountType()==3)

             return "Checking";

         else if(getAccountType()==4)

             return "Credit Card";

         else

             return "None";

    }

   //main method

    public static void main(String args[])

    {

         //Scanner class to read input values

         //from the console

         Scanner input=new Scanner(System.in);

         //Create an object to the BankAccount Class

         BankAccount bank=new BankAccount();

         //prompt the user to enter the respective

         //details

         System.out.println("Enter the name of the Account Holder: ");

         bank.setAccountHolder(input.nextLine());

         System.out.println("Enter the account Number: ");

         bank.setAccountNumber(input.next());

         System.out.println("Enter the account Type: ");

         System.out.println("1 - Savings");    

         System.out.println("2 - Award Savers");

         System.out.println("3 - Checking");

         System.out.println("4 - Credit Card");

         bank.setAccountType(input.nextInt());

         System.out.println("Enter the balance: ");

         bank.setBalance(input.nextDouble());

        

         //print the final result to the user

         System.out.println("Your Account details are: ");

         System.out.println("Name: "+bank.getAccountHolder());

         System.out.println("Account Number: "+bank.getAccountNumber());       

         System.out.println("Account Type: "+bank.type());

         System.out.println("Balance Amount: "+bank.getBalance());

         System.out.println("Total balance: "+bank.calculateTotalBalance());

    }

}

-------------------------------------------------------------------------------------------------------------------------------

Sample Output:

Enter the name of the Account Holder:

Alexander John Leo

Enter the account Number:

345BFG67

Enter the account Type:

1 - Savings

2 - Award Savers

3 - Checking

4 - Credit Card

3

Enter the balance:

300000.00

Your Account details are:

Name: Alexander John Leo

Account Number: 345BFG67

Account Type: Checking

Balance Amount: 300000.0

Total balance: 303000.0

Comment
More Answers
Manchikanti Gopinath
Manchikanti Gopinath answered this 3 hours later Was this answer helpful?
0
0
497 answers

public class BankAccount
{
   private String accountNumber;
   private String accountHolder;
   private double balance;
   private int accountType;
  
   public BankAccount() {
       this.accountNumber = "none";
       this.accountHolder = "unknown";
       this.balance = 0;
       this.accountType = 0;
   }

   public BankAccount(String accountNumber, String accountHolder,
           double balance, int accountType) {
       this.accountNumber = accountNumber;
       this.accountHolder = accountHolder;
       this.balance = balance;
       if(accountType < 1 || accountType > 4)
       {
           this.accountType = 0;
       }
       this.accountType = accountType;
   }

   public String getAccountNumber() {
       return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
       this.accountNumber = accountNumber;
   }

   public String getAccountHolder() {
       return accountHolder;
   }

   public void setAccountHolder(String accountHolder) {
       this.accountHolder = accountHolder;
   }

   public double getBalance() {
       return balance;
   }

   public void setBalance(double balance) {
       this.balance = balance;
   }

   public int getAccountType() {
       return accountType;
   }

   public void setAccountType(int accountType) {
       if(accountType < 1 || accountType > 4)
       {
           this.accountType = 0;
       }
       this.accountType = accountType;
   }
  
   public double methodCalculateBalance()
   {
       double interestRate = 0, totalBalance = 0;
       switch(this.accountType)
       {
           case 1 : interestRate = 0.5; break;
           case 2 : interestRate = 4.5; break;
           case 3 : interestRate = 1.0; break;
           case 4 : interestRate = 15; break;
           default : interestRate = 0;
       }
       totalBalance = balance + (balance * interestRate / 100);
       return totalBalance;
   }
}