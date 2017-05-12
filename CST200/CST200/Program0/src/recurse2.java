public class recurse2
{
   public static void main (String[] args)
   {
      recurse(3);
      System.out.print("---");
      recurse(2);  
   }
 
   public static void recurse(int x)
   {
      if (x<=1) {
         System.out.print("***");
      } else if ((x % 2) == 0) {
            System.out.print("+++");
            recurse(x-2);
      }
      else {
            System.out.print(x);
            recurse(x-1);
      }
   }
}