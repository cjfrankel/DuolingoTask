/* Duolingo PM Programming Task
 * Anagram Checker
 * Claire Frankel, cfrankel18@gmail.com
 * 10/3/16
 */

import java.util.HashMap;
import java.util.Scanner;

public class DuolingoTask {

	//User enters two words (only letters, no special characters), program checks
	// to see if anagrams of each other
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter first word: ");
	    String worda = input.next().toLowerCase().trim();
	    while(!valid(worda)) {
	    	System.out.println("Please enter valid word (only letters): ");
		    worda = input.next().toLowerCase().trim();
	    }
	    
	    System.out.println("Please enter second word: ");
	    String wordb = input.next().toLowerCase().trim();
	    while(!valid(wordb)) {
	    	System.out.println("Please enter valid word (only letters): ");
		    wordb = input.next().toLowerCase().trim();
	    }
		
	    boolean result = checkAnagram(worda, wordb);
	    
	    if(result)
	    	System.out.println("Yes, those two words are anagrams!");
	    else
	    	System.out.println("No, those two words are not anagrams :( ");
	    
	    tryAgain();
	    
	}
	
	//Checks if two given words are anagrams using map as character counter
	public static boolean checkAnagram(String a, String b) {
		if (a.length() != b.length())
			return false;
		
		HashMap<Character, Integer> histogram = new HashMap<Character, Integer>();
		
		for(int i=0; i<a.length(); i++) {
			Character c = a.charAt(i);
			if (histogram.containsKey(c)) 
				histogram.put(c, histogram.get(c)+1);
			else
				histogram.put(c, 1);
		}
		
		for(int i =0; i<b.length();i++) {
			Character c = b.charAt(i);
			if (histogram.containsKey(c) && histogram.get(c)>0) 
				histogram.put(c, histogram.get(c)-1);
			else
				return false;
		}
		
		return true;
	}
	
	//Helper method to check that input only contains letters
	public static boolean valid(String x) {
		if (!(x.chars().allMatch(Character::isLetter)))
			return false;
		else
			return true;
	}
	
	//Check to see if user wants to use the program again
	public static void tryAgain() {
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to try two new words? (y/n):");
	    String ans = input.next().toLowerCase();
	    if (ans.equals("y"))
	    	DuolingoTask.main(null);
	    else if (ans.equals("n"))
	    	System.out.println("Goodbye! Thank you for using our Anagram Checker!");
	    else {
	    	System.out.println("Please try again, only enter 'y' for yes or 'n' for no");
	    	tryAgain();	
	    }
	}

}
