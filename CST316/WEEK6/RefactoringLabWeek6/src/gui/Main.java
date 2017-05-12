package gui;

import javax.swing.JFrame;

//ACTIVITY 2-1 SMELL WITHIN A CLASS <Comments>

final class Main {
	private Main() {
	}

	//ACTIVITY 2-1 SMELL WITHIN A CLASS <Comments>
	
	public static void main(final String[] args) throws Exception {

		if (args.length != 1) {
			System.out.println("Usage: java FormMain <property file>");
			System.exit(1);
		}

		String propertyFile = args[0];
		JFrame frame = new MainFrame(propertyFile);
		frame.setVisible(true);

	}
}
