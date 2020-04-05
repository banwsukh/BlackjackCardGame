package application;

import java.util.ArrayList;
import java.util.List;

public class CardPlayer extends Player {

	private Hand hand = new Hand();

	public CardPlayer(String id) {
		super(id);

	}

	public Hand getHand() {
		return hand;
	}

	public boolean has21() {
		return hand.getTotal() == 21;
	}

	public boolean isBust() {
		return hand.getTotal() > 21;
	}

	public int getTotal() {
		return hand.getTotal();
	}

	public void play() {
		System.out.println(getPlayerID() + " is playing");
	}

	public void receiveCard(Card c) {
		this.hand.receiveCard(c);
	}

	public List<? extends Card> showCards() {
		return hand.showCards();
	}
}
