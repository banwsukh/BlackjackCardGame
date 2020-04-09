/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
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
public class DealerTest {
	
	public DealerTest() {
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
	 * Test of deal method, of class Dealer.
	 */
	@Test
	public void testDeal() {
		//after completion, size of the deck should be one less
		System.out.println("deal");
		Dealer instance = new Dealer("testDealer");
		int expResult = instance.getDeck().getSize() - 1; //deck is one card less in size
		
		Card result = instance.deal();
		assertEquals("Removing 1 card from dealer's deck", expResult, instance.getDeck().getSize());
	}

	/**
	 * Test of firstDeal method, of class Dealer.
	 */
	@Test
	public void testFirstDeal() {
		System.out.println("firstDeal");
		ArrayList<Player> players = new ArrayList<Player>() {
			{
				add(new CardPlayer("TestPlayer1"));
				add(new CardPlayer("TestPlayer2"));
			}
			
		};
		Dealer instance = new Dealer("TestDealer");
		instance.firstDeal(players);
		int expResult = 4; //Total cards dealt among the two players
		int totalCards = 0;
		for(Player p : players) {
			totalCards += p.showCards().size(); //num of cards for each player
		}
		assertEquals("Dealing two cards to each player", expResult, totalCards);
	}
	
}
