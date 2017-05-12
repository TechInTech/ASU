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
		area = (4.0 * Math.PI * Math.pow(rad, 2.0));
	}
	
	public double getArea()
	{
		return(area);
	}
	
	public void setVolume(double rad)
	{
		volume = ((4.0 / 3.0) * Math.PI * Math.pow(rad, 3.0));
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