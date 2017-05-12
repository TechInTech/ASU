package core;

import java.util.Scanner;

public class Main {

	//main method
    @SuppressWarnings("resource")
	public static void main(String args[]) {

         //read input values from the console
         Scanner input=new Scanner(System.in);

         //Instantiate an object of BankAccount Class
         BankAccount bA = new BankAccount();

         //Getting user's inputs

         System.out.println("Enter account holder's name: ");
         bA.setAccountHolder(input.nextLine());

         System.out.println("Enter account number: ");
         bA.setAccountNumber(input.next());
         System.out.println("Enter account type: ");
         System.out.println("1 - Savings");
         System.out.println("2 - Award Savers");
         System.out.println("3 - Checking");
         System.out.println("4 - Credit Card");
         bA.setAccountType(input.nextInt());
         System.out.println("Enter the balance: ");
         bA.setBalance(input.nextDouble());        

         //Print out results

         System.out.println("Your Account details are: ");
         System.out.println("Name: " + bA.getAccountHolder());
         System.out.println("Account Number: " + bA.getAccountNumber());
         System.out.println("Account Type: " + bA.type());
         System.out.println("Balance Amount: " + bA.getBalance());
         System.out.println("Total balance: " + bA.calculateTotalBalance());
         
         Customer cN = new Customer(bA.getAccountHolder(),"1674 Hollenbeck Avenue, Apt. #45","Sunnyvale","CA","94087",48);
         System.out.println();
         cN.displayAddress();
         System.out.println();
         cN.displayAddressLabel();
    }

}
