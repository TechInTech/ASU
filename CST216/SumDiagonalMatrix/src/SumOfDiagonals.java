
/**
* Title               : Diagonals(SumOfDiagonals.java)
* Program Description : Write a Java
* program that  Input a square matrix of order 4*4
* and Find the sum of both diagonal Even elements.
* Author              : robustprogramming.com
* Interface           : Console
* IDE                 : NetBeans 8.0.1
* Operating System    : Windows 8.1
*/
 
 
import java.util.Scanner;
 
public class SumOfDiagonals {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        //Declare three 2 Dimensional Arrays
        int[][] matrix = new int[4][4];
        int sum = 0;
 
        // Input Matrix
        System.out.println("Enter matrix order 4*4");
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.println("Enter elements of " + i + " row");
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j] = getInt(sc, "");
            }
        }
 
        // Compute Sum of main diagonal even elements
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if ((i == j) && (matrix[i][j] % 2 == 0))
                {
                    sum+= matrix[i][j];
                }
            }
        }
 
        // Compute Sum of anti-diagonal even elements
        for (int i = 0, j = matrix[i].length -1; i < matrix.length; i++, j--)
        {
            {
                if (matrix[i][j] % 2 == 0)
                    sum+= matrix[i][j];
            }
        }        System.out.println("Sum of Diagonal Elements is " + sum);
    }
 
    public static int getInt(Scanner sc, String prompt) {
        int integer = 0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                integer = sc.nextInt();
                isValid = true;
            } else {
                System.err.println("Error! Invalid number. Try again.");
            }
            sc.nextLine();
        }
        return integer;
    }
}