//********************************************************************
//  ProductCodes.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a try-catch block.
//********************************************************************

import java.io.*;

class ArrayStack
{
   int top;
   int curr_size;
   int max_size;
   int arr[]=new int arr[];
  
   ArrayStack(int t,int max)
   {
       top=t;
       curr_size=t;
       max_size=max;
       arr = new int[max];      
   }
      
   boolean isEmpty()
   {
       if(top==-1)
           return true;
       else
           return false;      
   }
      
   int size()
   {
       return curr_size;
   }
  
   int peak()
   {
       return max_size;
   }
      
   String toString()
   {
       String s="";
       for(i=top;i<=size;i++)
       {
           int val=this.arr[i];
           s=s+val;
       }
       return s;
   }
      
   public static void main(String args[])throws IOException
   {
       ArrayStack ob=new ArrayStack(-1,10);
       boolean empty = ob.isEmpty();
       if(empty==true)
           System.out.println("Stack Is Empty");
       else
           System.out.println("Stack Is Not Empty");
          
       int current=ob.size();
       System.out.println("Current Size=" + current);
      
       int max=ob.peak();
       System.out.println("Peak Size=" + max);
      
       String s=ob.toString();
       System.out.println("Final String Data=" + s);
          
   }
}