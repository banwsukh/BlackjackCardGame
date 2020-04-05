package application;

import java.util.ArrayList;
import java.util.List;

public class Dealer extends CardPlayer {

	private Deck deck = new Deck();

	public Dealer(String id) {
		super(id);
		deck.shuffle();
	}

	public void play() {
		System.out.println(getPlayerID() + " is playing");
	}

	public Card deal() {
		return deck.deal();

	}

	//in the first deal, 2 cards given to each player, including the dealer
	public void firstDeal(ArrayList<Player> players) {
		for (int i = 0; i < 2; i++) {
			for (Player p : players) {
				((CardPlayer)p).receiveCard(deck.deal());
				
			}
			getHand().receiveCard(deck.deal());
		}
	}
	public void showOneCard() {
		if (getHand().getSize() > 0) {

			System.out.println(showCards().get(0));
			
		} else {
			System.out.println("Dealer has no cards");
		}
	}
}
