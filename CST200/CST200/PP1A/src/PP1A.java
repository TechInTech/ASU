import java.util.*;

class Reverse
{
   public static void main(String args[])
   {
       Scanner s = new Scanner(System.in);
       Stack wordStack = new Stack();
       Stack sentStack = new Stack();
      
       String sentence = "";
       String newSent = "";
      
       System.out.println("Enter the word: ");
       sentence = s.next();
      
       String[] words = sentence.split(" ");
       for(String word : words)
       {
           for(int i=0;i<word.length();i++)
           {
               wordStack.push(word.charAt(i));
           }
           wordStack.push(" ");
           while(!wordStack.empty())
           {
               sentStack.push(wordStack.pop());
               newSent += sentStack.pop();
           }
       }
       System.out.println("\nYour new Sentence is: "+newSent + "\n");
   }
}
  