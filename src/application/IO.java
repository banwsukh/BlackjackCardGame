/*
 *A class to handle the input and output of the program
*/
package application;

/**
 *
 * @author vicba
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IO {
	
	private static Scanner scan = new Scanner(System.in);
	
	public static int getInt(String msg) {
		
		int result;
		
		System.out.println(msg);
		
		result = scan.nextInt();
		
		scan.nextLine();
		
		return result;
		
	}
	
	public static String getString(String msg) {
		
		String result = "";
		
		System.out.println(msg);
		
		result = scan.nextLine();
		
		return result;
		
	}
	
	public static void printPlayerCards(Player p) {
		List<Card> cards = (ArrayList) p.showCards();
		System.out.println("Player " + p.getPlayerID() + " has the following cards:");
		for (Card c : cards) {
			System.out.print(c.toString() + " ");
		}
	System.out.println();
	}
	
	public static boolean getBoolean(String msg) {
		
		boolean result;
		
		System.out.println(msg);
		
		while(true) {
		
			System.out.println("Type yes or no");
			
			String answer = scan.next();
			
			if(answer.equalsIgnoreCase("yes")) {
				
				result = true;
				break;
				
			}else if(answer.equalsIgnoreCase("no")) {
				
				result = false;
				break;
				
			}
		}
		
		return result;
		
	}
	
	public static void close() {
		scan.close();
	}
	
}
