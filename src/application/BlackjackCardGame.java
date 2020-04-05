package application;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye, 2018
 */
public class BlackjackCardGame extends Game {

	private final Dealer dealer = new Dealer("Dealer");
	
	public BlackjackCardGame(String givenName) {
		super(givenName);
	}

	/**
	 * Play the game. This might be one method or many method calls
	 * depending on your game.
	 */
	public void play() {

		settingOfGame();
		dealer.firstDeal(getPlayers()); // each player gets two cards including dealer
		System.out.println("Here are every players' cards: ");
		for (Player p : getPlayers()) {
			IO.printPlayerCards(p);
		}
		System.out.println("Dealer's first card:");
		dealer.showOneCard();

		for (Player p : getPlayers()) {

			askHitOrStand(p);
		}
		dealerTurn();
		declareWinner();
	}

	/**
	 * When the game is over, use this method to declare and display a
	 * winning player.
	 */
	public void declareWinner() {
		System.out.println();
		for (Player p : getPlayers()) {
			if (((CardPlayer) p).isBust()) {
				System.out.printf("%s lost!\n\n", p.getPlayerID());
			} else if (dealer.isBust()) {
				System.out.printf("%s Won!\n\n", p.getPlayerID());
			} else if (((CardPlayer) p).getTotal() > dealer.getTotal()) {
				System.out.printf("%s Won!\n\n", p.getPlayerID());
			} else if (((CardPlayer) p).getTotal() == dealer.getTotal()) {
				System.out.printf("%s Drew!\n\n", p.getPlayerID());
			} else {

				System.out.printf("%s lost!\n\n", p.getPlayerID());
			}
		}
	}

	private void dealerTurn() {
		System.out.println("Dealer's turn");
		while (true) {
			dealer.receiveCard(dealer.deal());
			IO.printPlayerCards(dealer);

			if (dealer.isBust()) {

				System.out.println("Dealer busts!");
				return;
			} else if (dealer.has21()) {
				System.out.println("Dealer gets 21!");
				return;
			} else if (dealer.getTotal() >= 17) {
				System.out.println("Dealers final score is " + dealer.getTotal());
				return;
			}
		}

	}

	private void settingOfGame() {

		System.out.println("Welcome to Black Jack!");

		ArrayList<Player> result = new ArrayList();

		int numOfPlayers = IO.getInt("How mnay players?");

		for (int i = 0; i < numOfPlayers; i++) {
			String ID = IO.getString(String.format("Enter the player's name"));
			//TODO: make sure player's name is not duplicate
			result.add(new CardPlayer(ID));
			result.get(i).play();
		}

		setPlayers(result);

	}

	public void askHitOrStand(Player p) {

		while (true) {

			boolean result = IO.getBoolean(String.format("\nDo you want to hit, %s?", p.getPlayerID()));
			if (result == false) {
				System.out.println(p.getPlayerID() + " decides to stand.");
				IO.printPlayerCards(p);
				System.out.println("Final score is " + ((CardPlayer) p).getTotal());
				return;
			}
			((CardPlayer) p).receiveCard(dealer.deal());
			IO.printPlayerCards(p);
			if (((CardPlayer) p).isBust()) {
				System.out.println("Busted!");
				return;
			} else if (((CardPlayer) p).has21()) {
				System.out.println("You got 21!");
				return;
			}
		}

	}

}//end class
