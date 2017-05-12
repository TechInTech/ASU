//*********************************************************
//Author: Hieu Pham
//ID: 0953-827
//Section: 28317
//Date: 02/01/2015
//
//Create a driver class called BoxTest, whose main method
//instantiates and updates several Box objects.
//
//**********************************************************


import java.text.DecimalFormat;

public class BoxTest
{
	public static void main(String[] args)
	{
		Box box1 = new Box(3.35,2.25,1.15), box2 = new Box(4.7,3.27,4.17);
		Box box3 = new Box(7.93,5.63,8.23), box4 = new Box(11.56,10.15,12.25);
		
		System.out.println();
		System.out.println("****** Initialized the boxes ******");
		System.out.println("Box1: " + box1);
		System.out.println("Box2: " + box2);
		System.out.println("Box3: " + box3);
		System.out.println("Box4: " + box4);
		
		DecimalFormat fmt = new DecimalFormat("0.###");
		
		
		
		box1.setArea(1.19, 0.89);
		box2.setArea(2.34, 1.19);
		box3.setArea(6.59, 4.89);
		box4.setArea(11.29, 9.59);
		
		System.out.println();
		System.out.println("Area of box #1 " + fmt.format(box1.getArea()));
		System.out.println("Area of box #2 " + fmt.format(box2.getArea()));
		System.out.println("Area of box #3 " + fmt.format(box3.getArea()));
		System.out.println("Area of box #4 " + fmt.format(box4.getArea()));
		System.out.println();
		
		box1.setVolume(2.25,1.19, 0.89);
		box2.setVolume(3.15,2.34, 1.19);
		box3.setVolume(4.35,6.59, 4.89);
		box4.setVolume(6.65,11.29, 9.59);
		
		System.out.println("Volume of box #1 " + fmt.format(box1.getVolume()));
		System.out.println("Volume of box #2 " + fmt.format(box2.getVolume()));
		System.out.println("Volume of box #3 " + fmt.format(box3.getVolume()));
		System.out.println("Volume of box #4 " + fmt.format(box4.getVolume()));
		
		System.out.println();
		
		box1.setFilledState(((int)(Math.random() * 2) != 0));
		box2.setFilledState(((int)(Math.random() * 2) != 0));
		box3.setFilledState(((int)(Math.random() * 2) != 0));
		box4.setFilledState(((int)(Math.random() * 2) != 0));
		
		System.out.println("Capacity of box #1 " + box1.getFilledState());
		System.out.println("Capacity of box #2 " + box2.getFilledState());
		System.out.println("Capacity of box #3 " + box3.getFilledState());
		System.out.println("Capacity of box #4 " + box4.getFilledState());
		
		System.out.println();
		System.out.println();
		
		box1.Boxify();
		box2.Boxify();
		box3.Boxify();
		box4.Boxify();
		
		System.out.println("Box1: " + box1);
		System.out.println("Box2: " + box2);
		System.out.println("Box3: " + box3);
		System.out.println("Box4: " + box4);		
		
	}
}
