class Play {
	private Hand hand;
	private Pile prehand = new Pile();
	public String name;
	Play(String _name) {
		name = _name;
	}
	public void draw(Card card) {
		prehand.addCard_end(card);
		if (prehand.numCards() == 5) {
			pickup();
		}
	}
	private void pickup() {
		Card card1 = prehand.remCard_top();
		Card card2 = prehand.remCard_top();
		Card card3 = prehand.remCard_top();
		Card card4 = prehand.remCard_top();
		Card card5 = prehand.remCard_top();
		hand = new Hand(card1, card2, card3, card4, card5);
	}
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		int nPlayers = 4;
		Play[] players = new Play[nPlayers];
		for (int p = 0; p < nPlayers; p++) {
			players[p] = new Play("Player".concat(" ").concat(String.valueOf(p+1)));
		}
		for (int i=0; i<nPlayers*5; i++) {
			players[i%nPlayers].draw(deck.remCard_top());
		}
		for (int p = 0; p < nPlayers; p++) {
			System.out.print(players[p].name);
			System.out.print(": ");
			System.out.println(players[p].hand);
		}
		// System.out.println(deck);
		Play winner = players[0];
		for (int p = 1; p < nPlayers; p++) {
			if (players[p].hand.compareTo(winner.hand) == 1) {
				winner = players[p];
			}
		}
		System.out.print(winner.name);
		System.out.println(" wins!");
	}
}