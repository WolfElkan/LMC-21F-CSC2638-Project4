// 56, 82, 119

class Hand extends Pile {
	// Cards must be sorted by compareTo
	// Enforce this somehow
	Hand(Card card1, Card card2, Card card3, Card card4, Card card5) {
		addCard_sort(card1);
		addCard_sort(card2);
		addCard_sort(card3);
		addCard_sort(card4);
		addCard_sort(card5);
	}
	public int compareTo(Hand other) {
		// int _StraightFlush = StraightFlush().compareTo(other.StraightFlush());
		// if (_StraightFlush != 0) return _StraightFlush;
		// int _FourKind = FourKind().compareTo(other.FourKind());
		// if (_FourKind != 0) return _FourKind;
		// int _FullHouse = FullHouse().compareTo(other.FullHouse());
		// if (_FullHouse != 0) return _FullHouse;
		// int _Flush = Flush().compareTo(other.Flush());
		// if (_Flush != 0) return _Flush;
		// int _Straight = Straight().compareTo(other.Straight());
		// if (_Straight != 0) return _Straight;
		// int _ThreeKind = ThreeKind().compareTo(other.ThreeKind());
		// if (_ThreeKind != 0) return _ThreeKind;
		// int _TwoPair = TwoPair().compareTo(other.TwoPair());
		// if (_TwoPair != 0) return _TwoPair;
		// int _Pair = Pair().compareTo(other.Pair());
		// if (_Pair != 0) return _Pair;
		int _HighCard = HighCard().compareTo(other.HighCard());
		if (_HighCard != 0) return _HighCard;
		return 0;
	}
	public Card Pair() {
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
	// public Card Pair() {
	// 	Card card = topCard;
	// 	Card high = topCard;
	// 	Card pair = topCard;
	// 	do {
	// 		card = card.next;
	// 		if (card.compareTo(high) == 1) {
	// 			do {
	// 				pair = pair.next;
	// 				if (pair.Value() == card.Value()) {
	// 					high = card;
	// 					break;
	// 				}
	// 			} while (pair.next != null);
	// 		}
	// 	} while (card.next != null);
	// 	return high;
	// }
	public Card HighCard() {
		return topCard;
		// Card card = topCard;
		// Card high = topCard;
		// do {
		// 	card = card.next;
		// 	if (card.compareTo(high) == 1) {
		// 		high = card;
		// 	}
		// } while (card.next != null);
		// return high;
	}
	public static void main(String[] args) {
		Hand hand = new Hand(
			 new Card(7,Suit.DIAMONDS)
			,new Card(4,Suit.DIAMONDS)
			,new Card(5,Suit.DIAMONDS)
			,new Card(2,Suit.HEARTS)
			,new Card(8,Suit.SPADES)
		);
		// Hand other = new Hand();
		System.out.println(hand);
		// other.addCard_end(new Card(6,Suit.DIAMONDS));
		// other.addCard_end(new Card(4,Suit.SPADES));
		// other.addCard_end(new Card(7,Suit.CLUBS));
		// other.addCard_end(new Card(11,Suit.DIAMONDS));
		// other.addCard_end(new Card(13,Suit.DIAMONDS));
		// System.out.println(hand.compareTo(other));
	}
}