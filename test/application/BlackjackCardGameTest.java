/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vicba
 */
public class BlackjackCardGameTest {
	
	public BlackjackCardGameTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

		/**
	 *Good Test of didIWin method, of class BlackjackCardGame.
	 */
	@Test
	public void goodTestDidIWin() {
		System.out.println("didIWin");
		Player p = new CardPlayer("Player1");
		((CardPlayer)p).getHand().setTotal(21);
		Dealer d = new Dealer("testDealer");
		BlackjackCardGame instance = new BlackjackCardGame("Blackjack");
		d.getHand().setTotal(21); //Player should now lose
		boolean expResult = false;
		boolean result = instance.didIWin(p, d);
		assertEquals(expResult, result);
	}

		/**
	 *Bad Test of didIWin method, of class BlackjackCardGame.
	 */
	@Test
	public void badTestDidIWin() {
		System.out.println("didIWin");
		Player p = new CardPlayer("Player1");
		((CardPlayer)p).getHand().setTotal(23);
		Dealer d = new Dealer("testDealer");
		BlackjackCardGame instance = new BlackjackCardGame("Blackjack");
		d.getHand().setTotal(20); //Player should now lose
		boolean expResult = true; //should cause failing test
		boolean result = instance.didIWin(p, d);
		assertEquals(expResult, result);
	}

		/**
	 *Boundary Test of didIWin method, of class BlackjackCardGame.
	 */
	@Test
	public void boundaryTestDidIWin() {
		System.out.println("didIWin");
		Player p = new CardPlayer("Player1");
		((CardPlayer)p).getHand().setTotal(0);
		Dealer d = new Dealer("testDealer");
		BlackjackCardGame instance = new BlackjackCardGame("Blackjack");
		d.getHand().setTotal(0); //Player should now lose
		boolean expResult = false;
		boolean result = instance.didIWin(p, d);
		assertEquals(expResult, result);
	}
}
