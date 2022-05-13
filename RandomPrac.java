import java.util.Scanner;
import java.util.Arrays;

class RandomPrac{
	public static void main(String args[]) {
      Scanner s = new Scanner(System.in);
      System.out.println("Enter the length of the array:");
      String word = s.nextLine();
      
      String newWord;
      
      for(int i = word.length(); i > 0; i++) {
    	  for(int j = 0; i < word.length(); i--) {
        	  newWord.charAt(j) = word.charAt(i);
    	  }
      }
   
      System.out.println(newWord);
   }
}