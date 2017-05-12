import java.util.*;

@SuppressWarnings("unused")
public class MSquareTest {

	public static void main(String[] args) {
		MagicSQUARE mSquare = new MagicSQUARE(); //Instantiate object
		System.out.println("Please enter an array of integers of");
		System.out.println("n^2 elements and each one is separated by");
		System.out.println("a white space. Example: 8 1 6 3 5 7 4 9 2\n");
		System.out.print("Your entry: ");
		mSquare.readString();
		boolean iValid = mSquare.isValid();
		
		System.out.println("The square list is " + iValid);
	}

}
