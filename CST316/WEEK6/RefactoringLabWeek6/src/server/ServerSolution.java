package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import banking.interfaces.AAccount;
import banking.interfaces.IAccountServer;
import primitive.core.Checking;
import primitive.core.Savings;



class ServerSolution implements IAccountServer {

	static String fileName = "accounts.ser";

	List<AAccount> accountList = new ArrayList<AAccount>();

	public ServerSolution() {
		File file = new File(fileName);
		ObjectInputStream in = null;
		try {
			if (file.exists()) {
				System.out.println("Reading from file " + fileName + "...");
				in = new ObjectInputStream(new FileInputStream(file));

				Integer sizeI = (Integer) in.readObject();
				int size = sizeI.intValue();
				for (int i=0; i < size; i++) {
					AAccount acc = (AAccount) in.readObject();
					accountList.add(acc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException iexc) {
					iexc.printStackTrace();
				}
			}
		}
	}
	public void newAccount(String type, String name, float balance) {
		AAccount acc;
		if ("Checking".equals(type)) {
			acc = new Checking(name, balance);

		} else if ("Savings".equals(type)) {
			acc = new Savings(name, balance);

		} else {
			throw new IllegalArgumentException("Bad account type:" + type);
		}
		accountList.add(acc);
	}

	public void update(AAccount aAccount) {
		int index = findIndex(aAccount.getName());
		if (index < 0) {
			throw new IllegalStateException("Account not found:" + aAccount);
		}

		accountList.remove(index);
		accountList.add(aAccount);
	}

	public AAccount getAccount(String name) {
		int index = findIndex(name);
		if (index < 0) {
			return null;
		} //ACTIVITY 2-1 SMELL WITHIN A CLASS <Inconsistent Names>

		return accountList.get(index);
	}

	public List<AAccount> getAllAccounts() {
		return accountList;
	}

	public List<AAccount> getOverdrawnAccounts() {
		List<AAccount> result = new ArrayList<AAccount>();

		for (int i=0; i < accountList.size(); i++) {
			AAccount acc = accountList.get(i);
			if (acc.getBalance() < 0) {
				result.add(acc);
			}
		}

		return result;
	}

	public void shutdown() {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(fileName));

			out.writeObject(Integer.valueOf(accountList.size()));
			for (int i=0; i < accountList.size(); i++) {
				out.writeObject(accountList.get(i));
			}
		} catch (Exception e) {
			System.out.println("Could not write file:" + fileName);
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException oexc) {
					oexc.printStackTrace();
				}
			}
		}
	}

	protected int findIndex(String name) {

		for (int i=0; i < accountList.size(); i++) {
			final AAccount acc = accountList.get(i); 
			//ACTIVITY 2-1 SMELL WITHIN A CLASS <local variable must be made final>
			if (name.equals(acc.getName())) {
				return i;
			}
		}
		return -1;
	}
}
