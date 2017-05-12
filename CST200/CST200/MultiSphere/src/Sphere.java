//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Design and implement a class called Sphere that contains
//instance data that represents the sphere’s diameter. 
//Define the Sphere constructor to accept and initialize 
//the diameter, and include getter and setter methods for 
//the diameter. Include methods that calculate and return 
//the volume and surface area of the sphere 
//(see programming project 3.5 for the formulas). 
//Include a toString method that returns a oneline 
//description of the sphere. 
//
//**********************************************************

import java.text.DecimalFormat;

public class Sphere
{
	private double radius;
	private double area;
	private double volume;
	
	public Sphere(double rad)
	{
		radius = rad;
	}
	
	public void setArea(double rad)
	{
		radius = rad; //Always update current values
		area = (4.0 * Math.PI * Math.pow(radius, 2.0));
	}
	
	public double getArea()
	{
		return(area);
	}
	
	public void setVolume(double rad)
	{
		radius = rad; //Always update current values
		volume = ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0));
	}
	
	public double getVolume()
	{
		return(volume);
	}
	
	public void Spherify()
	{
		area = (4.0 * Math.PI * Math.pow(radius, 2.0));
		volume = ((4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0));
	}
	
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.###");
		
		return("Radius = " + fmt.format(radius) + ", "
				+ "Area = " + fmt.format(area) + ", "
				+ "Volume = " + fmt.format(volume) + "\n");
	}

}