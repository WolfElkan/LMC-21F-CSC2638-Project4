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
	Card next;
	Card prev;
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
	public int compareTo(Card other) {
		int myValue = this.value;
		int yourValue = other.value;
		if (myValue == 1) {
			myValue = 14;
		}
		if (yourValue == 1) {
			yourValue = 14;
		}
		if (myValue > yourValue) {
			// System.out.print(this.toShortString());
			// System.out.print(" > ");
			// System.out.println(other.toShortString());
			return 1;
		} else if (yourValue > myValue) {
			// System.out.print(this.toShortString());
			// System.out.print(" < ");
			// System.out.println(other.toShortString());
			return -1;
		} 
		int mySuit = this.suitRank();
		int yourSuit = other.suitRank();
		if (mySuit > yourSuit) {
			// System.out.print(this.toShortString());
			// System.out.print(" > ");
			// System.out.println(other.toShortString());
			return 1;
		} else if (yourSuit > mySuit) {
			// System.out.print(this.toShortString());
			// System.out.print(" < ");
			// System.out.println(other.toShortString());
			return -1;
		} else {
			// System.out.print(this.toShortString());
			// System.out.print(" = ");
			// System.out.println(other.toShortString());
			return 0;
		}
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
			case SPADES   : codepoint = 0x2660; break;
			case CLUBS    : codepoint = 0x2663; break;
			case HEARTS   : codepoint = 0x2665; break;
			case DIAMONDS : codepoint = 0x2666; break;
		}
		return Character.toChars(codepoint);
	}
	public String Value() {
		switch (value) {
			case  1: return "A";
			case 11: return "J";
			case 12: return "Q";
			case 13: return "K";
		}
		return String.valueOf(value);
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
	private int unicode() {
		if (value == 0) {
			return 0x1f0cf; // Black Joker is the only one that renders
		}
		int codepoint = 0x30;
		switch (suit) {
			case SPADES   : codepoint = 0x1f0a0; break;
			case HEARTS   : codepoint = 0x1f0b0; break;
			case DIAMONDS : codepoint = 0x1f0c0; break;
			case CLUBS    : codepoint = 0x1f0d0; break;
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
	public String toShortString() {
		if (value == 0) {
			if (color() == 1) {
				return "RJ";
			} else {
				return "BJ";
			}
		} else {
			return Value() + String.valueOf(Suit());
		}
	}
	public static void main(String[] args) {
		Card card = new Card(10, Suit.CLUBS);
		System.out.println(card.Suit());
		// System.out.println(Character.toChars(0x2660));
	}
}