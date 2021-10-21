// class Suit {
// 	int quality;
// 	private static String[] full_names = {"Clubs", "Hearts", "Diamonds", "Spades"};
// 	Suit (int q){
// 		quality = q;
// 	}
// 	public String toString() {
// 		return full_names[quality];
// 	}
// 	public int color() {
// 		return (quality & 1) ^ (quality >> 1);
// 	}
// 	public String Color() {
// 		if (color() == 1) {
// 			return "Red";
// 		} else {
// 			return "Black";
// 		}
// 	}
// }


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
	public int unicode() {
		if (value == 0) {
			return 0x1f0cf - (suit.color() * 0x10);
		}
		int codepoint = suit.unicode();
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
			return suit.Color() + " " + values[value];
		} else {
			return values[value] + " of " + suit;
		}
	}
	public static void main(String[] args) {
		Card card = new Card(3, Suit.Clubs());
		System.out.println(card.Unicode());
	}
}