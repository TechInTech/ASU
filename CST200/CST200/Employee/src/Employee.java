public class Employee
{
	public static void main(String[] args)
	{
		final int MAXIMUM = 1;
		double raises[] = {0.75, 1.15, 0.85, 1.12, 2.05};
		
		
		employees MyEmployees = new employees(000,"02/27/2012", raises);
		
		System.out.println(MyEmployees);
	}
	
	
	public static class employees 
	{ 
		private int EmployeeID; 
		private String StartDate;
		private double PerfRaise[] = new double[5];

		public employees(int EID, String DOH, double Raise[])
		{
			int iterator = 0;
			
			EmployeeID = EID;
			StartDate = DOH;

			for(double aNumber : Raise)
			{
				PerfRaise[iterator] = aNumber;
				iterator++;
			}
			
		}//Close constructor
		
		public String toString()
		{
			return(EmployeeID + "\n"
					+ StartDate + "\n"
					+ PerfRaise[0] + "\n"
					+ PerfRaise[1] + "\n"
					+ PerfRaise[2] + "\n"
					+ PerfRaise[3] + "\n"
					+ PerfRaise[4] + "\n");
			
		}//Close the string
	}//Close class employees	
	
}

