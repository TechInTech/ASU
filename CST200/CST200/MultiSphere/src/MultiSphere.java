//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Create a driver class called MultiSphere, 
//whose main method instantiates and updates 
//several Sphere objects.
//
//**********************************************************



import java.text.DecimalFormat;

public class MultiSphere
{
	public static void main(String[] args)
	{
		Sphere sphere1 = new Sphere(2.5), sphere2 = new Sphere(4.7);
		Sphere sphere3 = new Sphere(7.93), sphere4 = new Sphere(11.56);
		
		DecimalFormat fmt = new DecimalFormat("0.###");
		
		sphere1.setArea(1.19);
		sphere2.setArea(4.16);
		sphere3.setArea(2.29);
		sphere4.setArea(3.77);
		
		System.out.println();
		System.out.println("Area of sphere #1 " + fmt.format(sphere1.getArea()));
		System.out.println("Area of sphere #2 " + fmt.format(sphere2.getArea()));
		System.out.println("Area of sphere #3 " + fmt.format(sphere3.getArea()));
		System.out.println("Area of sphere #4 " + fmt.format(sphere4.getArea()));
		System.out.println();
		
		sphere1.setVolume(1.19);
		sphere2.setVolume(4.16);
		sphere3.setVolume(2.29);
		sphere4.setVolume(3.77);
		
		System.out.println("Volume of sphere #1 " + fmt.format(sphere1.getVolume()));
		System.out.println("Volume of sphere #2 " + fmt.format(sphere2.getVolume()));
		System.out.println("Volume of sphere #3 " + fmt.format(sphere3.getVolume()));
		System.out.println("Volume of sphere #4 " + fmt.format(sphere4.getVolume()));
		
		System.out.println();
		System.out.println();
		
		sphere1.Spherify();
		sphere2.Spherify();
		sphere3.Spherify();
		sphere4.Spherify();
		
		System.out.println("Sphere1: " + sphere1);
		System.out.println("Sphere2: " + sphere2);
		System.out.println("Sphere3: " + sphere3);
		System.out.println("Sphere4: " + sphere4);		
		
	}
}
