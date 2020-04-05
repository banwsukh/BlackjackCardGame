package application;

import java.util.ArrayList;
import java.util.Collections;

public class Deck extends GroupOfCards {

    private ArrayList <Card> cards = new ArrayList<Card>();

    public Deck() {
        super(0); //52 cards in a deck after populating
        populate();
    }

    private void populate() {
        for (int i = 0; i < 4; i++) { //make 4 versions of each card for a 52 card deck
            for (Face.CardFace cf : Face.CardFace.values()) {
                cards.add(new BlackJackCard(cf));
            }
        }
    	setSize(52);
    }

    //deck re-populates if there are no more cards left
    public Card deal() {
            if (cards.isEmpty()) {
                populate();
                return deal();
            }
	setSize(getSize() - 1);
        return cards.remove(0);
    }



    public void shuffle()
    {
        Collections.shuffle(cards);
    }
}
