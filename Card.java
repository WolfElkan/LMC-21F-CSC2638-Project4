enum Suit {
	HEARTS,
	DIAMONDS,
	SPADES,
	CLUBS,
}

class Card {
	private Suit suit;
	private int value;
	private static String[] values = {
		"Joker",
		"Ace",
		"Two",
		"Three",
		"Four",
		"Five",
		"Six",
		"Seven",
		"Eight",
		"Nine",
		"Ten",
		"Jack",
		"Queen",
		"King",
	};
	Card nextCard;
	Card prevCard;
	Card (int _value, Suit _suit){
		suit = _suit;
		value = _value;
	}
	public int suitRank() {
		switch (suit) {
			case SPADES   : return 4;
			case DIAMONDS : return 3;
			case HEARTS   : return 2;
			case CLUBS    : return 1;	
		}
		return 0;
	}
	public int color() {
		switch (suit) {
			case HEARTS: 
			case DIAMONDS:
				return 1;
			case SPADES:
			case CLUBS:
				return 0;	
		}
		return -1;	
	}
	public String Color() {
		switch (color()) {
			case 1: return "Red";
			case 0: return "Black";
		}
		return "White";
	}
	public char[] Suit() {
		int codepoint = 63;
		switch (suit) {
			case SPADES   : codepoint = 0x2660;
			case CLUBS    : codepoint = 0x2663;
			case HEARTS   : codepoint = 0x2665;
			case DIAMONDS : codepoint = 0x2666;
		}
		return Character.toChars(codepoint);
	}
	public String suitName() {
		switch (suit) {
			case SPADES   : return "Spades";
			case DIAMONDS : return "Diamonds";
			case HEARTS   : return "Hearts";
			case CLUBS    : return "Clubs";
		}
		return "Nothing";
	}
	public int unicode() {
		if (value == 0) {
			return 0x1f0cf; // Black Joker is the only one that renders
		}
		int codepoint = 0x30;
		switch (suit) {
			case SPADES   : codepoint = 0x1f0a0;
			case HEARTS   : codepoint = 0x1f0b0;
			case DIAMONDS : codepoint = 0x1f0c0;
			case CLUBS    : codepoint = 0x1f0d0;
		}
		codepoint += value;	
		if (value >= 12) {
			codepoint += 1;
		}
		return codepoint;
	}
	public char[] Unicode() {
		return Character.toChars(unicode());
	}
	public String toString() {
		if (value == 0) {
			return Color() + " " + values[value];
		} else {
			return values[value] + " of " + suitName();
		}
	}
	// public String toShortString() {
	// 	if (value == 0) {
	// 		return Color() + " " + values[value];
	// 	} else {
	// 		return String.valueOf(value) + String.valueOf(Suit());
	// 	}
	// }
	public static void main(String[] args) {
		Card card = new Card(10, Suit.CLUBS);
		System.out.println(card.toShortString());
		// System.out.println(Character.toChars(0x2660));
	}
}