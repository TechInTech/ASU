/*
 *Simple collection with built-in array
 *@Hieu Pham
 */

public class StudentCollect
{
	 public static void main(String[] args)
	 {
		 	// create the student list
	        Student[] ser222 = new Student[10]; 
	       
	        ser222[0] = new Student("Hieu Pham","121-32-5476","President",30);
	        ser222[1] = new Student("Anurag Gupta","272-61-9076","Vice President",38);
	        ser222[2] = new Student("Duoc Lingur","193-85-5938","Secretary",24);
	        ser222[3] = new Student("Pat Orangatan","731-46-7361","Treasury",39);
	        ser222[4] = new Student("Owen Chimph","813-20-7016","Security",27);
	        ser222[5] = new Student("Laura Primativa","453-71-9499","Group 1 Advisor",34);
	        ser222[6] = new Student("Vicky Apian","335-88-3819","Group 2 Advisor",26);
	        ser222[7] = new Student("Larry Babunez","646-17-1174","Crowd Control",33);
	        ser222[8] = new Student("George Apeh","775-18-5838","Crowd Control",42);
	        ser222[9] = new Student("Elizabeth Kangruez","992-49-7949","Auditor",32);
	        
	        // Print the list using for-each....
	        for(Student thestudent : ser222)
	        {
	            System.out.print(thestudent.getName() + ", ");
	            System.out.print(thestudent.getSSN() + ", ");
	            System.out.println(thestudent.getDuty());
	        }
	 }

}
