class Deck extends Pile {
	Deck() {
		for (int v=1; v <= 13; v++) {
			addCard_end(new Card(v,Suit.SPADES));
		}
		for (int v=1; v <= 13; v++) {
			addCard_end(new Card(v,Suit.DIAMONDS));
		}
		for (int v=13; v >= 1; v--) {
			addCard_end(new Card(v,Suit.CLUBS));
		}
		for (int v=13; v >= 1; v--) {
			addCard_end(new Card(v,Suit.HEARTS));
		}		
	}
	void shuffle() {
		Pile temp = new Pile();
		for (int n = nCards; n > 0; n--) {
			double r = Math.random() * n;
			int i = (int) r;
			temp.addCard_end(remCard_at(i));
			// System.out.print(remCard_at(i).toShortString());
			// System.out.print(" ");
		}
		while (temp.nCards > 0) {
			this.addCard_end(temp.remCard_top());
		}
	}
	public static void main(String[] args) {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.println(deck);
	}
}