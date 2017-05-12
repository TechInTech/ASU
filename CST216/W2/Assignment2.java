import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment2 extends JFrame implements ActionListener {
	private JLabel lblBinary = new JLabel("Binary String");
	private JLabel lblDecimal = new JLabel("Decimal String");

	private JTextField jtfBinary = new JTextField(20);
	private JTextField jtfDecimal = new JTextField(20);

	private JButton jbtnConvert = new JButton("Convert To Decimal");

	private JPanel panel = new JPanel();

	public Assignment2() {
  		setTitle("Lab4: Convert Binary to Decimal");
  		setLayout(new BorderLayout());
  		setSize(620, 120);
  
  		panel.setLayout(new GridLayout(2, 2, 5, 5));
  
  		panel.add(lblBinary);
  		panel.add(jtfBinary);
  		panel.add(lblDecimal);
  		panel.add(jtfDecimal);
  
  		add(panel, BorderLayout.CENTER);
  		add(jbtnConvert, BorderLayout.SOUTH);
  
  		jbtnConvert.addActionListener(this);
  
  		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		setVisible(true);  
	}

	public void actionPerformed(ActionEvent ae) {
		String binary = jtfBinary.getText();
  
		try
		{
			int number = parseBinary(binary);

		   	jtfDecimal.setText(number + "");
		}
		catch(NumberFormatException nfe)
		{
		   	jtfDecimal.setText("Invalid Format for a Binary String - Illegal character: " + nfe.getMessage());
		}
	}

	public int parseBinary(String binary) {
		  if(binary.length() == 0)
		  {
		   	return 0;
		  }  
		  if(binary.charAt(0) == '0')
		  {    
		   	return (int) ((Math.pow(2, binary.length() - 1) * 0) + parseBinary(binary.substring(1)));
		  }
		  else if(binary.charAt(0) == '1')
		  {
		   	return (int) ((Math.pow(2, binary.length() - 1) * 1) + parseBinary(binary.substring(1)));
		  }
		  else
		  {
		   	throw new NumberFormatException("" + binary.charAt(0));
		  }
	}

	public static void main(String[] args)
	{
	  	new Assignment2();
	}
}