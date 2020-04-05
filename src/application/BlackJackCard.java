/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;

/**
 *
 * @author vicba
 */
public class BlackJackCard extends Card {

	private final Face.CardFace _cardFace;

	public BlackJackCard(Face.CardFace f) {

		_cardFace = f;
	}

	public int getValue() {
		if (_cardFace == Face.CardFace.ACE) {
		}
		switch (_cardFace) {
			case ACE:
				return 11; //this value gets auto corrected in case of a bust
			case TWO:
				return 2;
			case THREE:
				return 3;
			case FOUR:
				return 4;
			case FIVE:
				return 5;
			case SIX:
				return 6;
			case SEVEN:
				return 7;
			case EIGHT:
				return 8;
			case NINE:
				return 9;
			case TEN:
				return 10;
			case KING:
				return 10;
			case QUEEN:
				return 10;
			case JACK:
				return 10;
			default:
				return 0;
		}
	}

	public Face.CardFace getCardFace() {
		return _cardFace;
	}


	@Override
	public String toString() {
		return _cardFace.toString();
	}
}
