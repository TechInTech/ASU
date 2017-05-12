//using is similar to #include (C, C++)
//or import (java, python)

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace HelloWorld
{
    class Program
    {
        static void Main(string[] args)         //This is almost the same as java, except java uses
        {                                       //public static void main(String[] args) - look at M and s
            Console.WriteLine("Hello World");   //(java System.out.println("");)
            Console.Read();                     //Wait for a key press (java Scanner Inp equiv.)
        }
        //Data types have some additional types such as: decimal, byte,
        // to declare a decimal -> decimal = 2351.65m;
        // to declare a float -> 60.5f;
        // double is the same as java and C++
        // byte is an unsigned integer from 0 to 255
        // bool is boollean type of true or false.
    }
}//Close the namespace
