package server;

import banking.interfaces.AAccount;

import java.util.Observable;
import java.util.Observer;

//CST316 TASK 3 ADDOBSERVER
@SuppressWarnings("unused")
class ObservedAccount extends Observable {
	private AAccount accn;
	
	public ObservedAccount(AAccount accnt) {
		accn = accnt;
	}
	
	public void setAccountParams(AAccount accnts) {
		
		if(!accn.getName().equals(accnts.getName())) {
			accn = accnts;
			setChanged();			
			notifyObservers(accn);
		}
	}
}

class MyObserver1 implements Observer
{
	  @SuppressWarnings("unused")
	public void update(Observable o, Object arg)
	{
	    AAccount acc = (AAccount) arg;
	    System.out.println("Account " + acc.getName() + " has been added, there are now XXX accounts on the server");
	}
}

class MyObserver2 implements Observer 
{
	  @SuppressWarnings("unused")
	public void update(Observable o, Object arg) 
	{
		  AAccount acc = (AAccount) arg;
		  System.out.println("Account " + acc.getName() + " has been added, there are now XXX accounts on the server");
	}
}