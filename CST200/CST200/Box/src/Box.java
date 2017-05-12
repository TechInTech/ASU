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

public class Box
{
	private double height;
	private double width;
	private double depth;
	private double area;
	private double volume;
	private boolean full;
	
	public Box(double h, double w, double d)
	{
		full = false;
		height = h;
		width = w;
		depth = d;
	}
	
	public void setArea(double w, double d)
	{
		width = w; //Always update current values
		depth = d; //Always update current values
		area = (width * depth);
	}
	
	public double getArea()
	{
		return(area);
	}
	
	public void setVolume(double h, double w, double d)
	{
		height = h; //Always update current values
		width = w;  //Always update current values
		depth = d;  //Always update current values
		volume = (width * depth * height);
	}
	
	public double getVolume()
	{
		return(volume);
	}
	
	public void setFilledState(boolean f)
	{
		full = f;
	}
	
	public boolean getFilledState()
	{
		return((full & true));
	}
	
	public void Boxify()
	{
		area = (width * depth);
		volume = (width * depth * height);
		full = (full & true);
	}
	
	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("0.###");
		
		return("Height = " + fmt.format(height) + ", "
				+ "Width = " + fmt.format(width) + ", "
				+ "Depth = " + fmt.format(depth) + ", "
				+ "Area = " + fmt.format(area) + ","
				+ "Volume = " + fmt.format(volume) + ", "
				+ "Space = " + (full & true) != null  ? "Full" : "Empty");
	}

}