// 56, 82, 119

class Hand extends Pile {
	// Hand must have exactly five cards
	// Enforce this somehow
	public int compareTo(Hand other) {
		int _highCard = highCard().compareTo(other.highCard());
		if (_highCard != 0) {
			return _highCard;
		}
		return 0;
	}
	public Card highCard() {
		Card card = topCard;
		Card high = topCard;
		do {
			card = card.next;
			if (card.compareTo(high) == 1) {
				high = card;
			}
		} while (card.next != null);
		return high;
	}
	public static void main(String[] args) {
		Hand hand = new Hand();
		Hand other = new Hand();
		hand.addCard_end(new Card(8,Suit.SPADES));
		hand.addCard_end(new Card(4,Suit.DIAMONDS));
		hand.addCard_end(new Card(5,Suit.DIAMONDS));
		hand.addCard_end(new Card(1,Suit.HEARTS));
		hand.addCard_end(new Card(7,Suit.DIAMONDS));
		other.addCard_end(new Card(6,Suit.DIAMONDS));
		other.addCard_end(new Card(4,Suit.SPADES));
		other.addCard_end(new Card(7,Suit.CLUBS));
		other.addCard_end(new Card(11,Suit.DIAMONDS));
		other.addCard_end(new Card(13,Suit.DIAMONDS));
		System.out.println(hand.compareTo(other));
	}
}