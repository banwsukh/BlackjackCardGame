package application;

import java.util.ArrayList;

public class Hand extends GroupOfCards {

	private ArrayList<Card> cards = new ArrayList<Card>();
	private int total = 0;
	private int aces = 0; // number of aces in hand

	public Hand() {
		super(0); //initially no cards in hand
	}

	public ArrayList<Card> showCards() {
		return cards;
	}
	//the hit method is the equivalent of receiving a card

	public void receiveCard(Card c) {
		cards.add(c);
		if ( ((BlackJackCard) c).getCardFace() == Face.CardFace.ACE ) aces++;
		setSize(getSize() + 1);
		total += ((BlackJackCard) c).getValue();
		if (total > 21 && aces > 0) { // total may change based on aces value
			for (int i = 0; i < aces; i++) {
				total -= 10; // decrease total if ace value of 11 causes bust
				if (total <= 21)  return; // no need to switch more ace values
			}
		}
	}

	public int getTotal() {
		return total;
	}

	public void clearHand() {
		cards.clear();
		this.setSize(0);
		total = 0;
	}

}
