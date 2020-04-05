/**
 *
 * @author vicba
 */
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vicba
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		BlackjackCardGame bjg = new BlackjackCardGame("Black Jack");
		bjg.play(); // each player will choose to hit/stand
	}

	

}
