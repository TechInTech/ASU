package server;

import banking.interfaces.IAccountServer;

public class AccountServerFactory {  //CST316 TASK 3 ADDSINGLETON
	
	//protected static AccountServerFactory singleton = null; //CST316 TASK 3 ADDSINGLETON
	private static AccountServerFactory singleton = new AccountServerFactory();
	
	AccountServerFactory() { //CST316 TASK 3 ADDSINGLETON
		;
	}

	public static AccountServerFactory getInstance() {//CST316 TASK 3 ADDSINGLETON
	
		return singleton;
	}
	
	public IAccountServer getAccountServer() {
		return new ServerSolution();
	}
}