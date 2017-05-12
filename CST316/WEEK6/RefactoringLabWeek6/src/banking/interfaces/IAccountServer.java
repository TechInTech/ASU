package banking.interfaces;

import java.util.List;

//ACTIVITY 2-1 SMELL WITHIN A CLASS <Inconsistent Names>
public interface IAccountServer {

	/** Create a new account object in the server.  Type is either
		"Checking" or "Savings".  Throws IllegalArgumentException otherwise.
	*/
	public void		newAccount(String type, String name, float balance);

	/** Replace the already existing account.  Throws IllegalStateException
		if Account does not exist (this is a stretch, BTW).
	*/
	public void		update(AAccount aAccount);

	/** Returns Account object or null if not found. */
	public AAccount	getAccount(String name);

	/** Returns a list of all Accounts inside the server */
	public List<AAccount>		getAllAccounts();

	/** Returns a list of Accounts whose balance is less than 0 */
	public List<AAccount>		getOverdrawnAccounts();

	/** Saves the state of the server and terminates the program */
	public void		shutdown();
}
