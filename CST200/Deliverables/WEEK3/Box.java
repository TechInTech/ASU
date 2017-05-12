//****************************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Design and implement a class called Box that contains 
//instance data that represents the height, width, and 
//depth of the box. Also include a boolean variable called
//full as instance data that represents if the box is full
//or not. Define the Box constructor to accept and initialize
//the height, width, and depth of the box. Each newly created 
//Box is empty (the constructor should initialize full to false).
//Include getter and setter methods for all instance data. 
//Include a toString method that returns a one-line 
//description of the box. 
//
//****************************************************************

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
		this.Boxify();
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
	
	public String getFilledState()
	{
		return((full & true) ? "Full" : "Empty");
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
		
		return("Height = " + fmt.format(this.height) + ", "
				+ "Width = " + fmt.format(this.width) + ", "
				+ "Depth = " + fmt.format(this.depth) + ", "
				+ "Area = " + fmt.format(this.area) + ","
				+ "Volume = " + fmt.format(this.volume) + ", "
				+ this.getFilledState());
	}

}