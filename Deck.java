class Deck {//extends Pile {
	public static void main(String[] args) {
		System.out.print(new Card(0,Suit.Hearts()).Unicode());
		System.out.print(new Card(0,Suit.Spades()).Unicode());
		for (int v=1; v <= 13; v++) {
			System.out.print(new Card(v,Suit.Spades()).Unicode());
		}
		for (int v=1; v <= 13; v++) {
			System.out.print(new Card(v,Suit.Diamonds()).Unicode());
		}
		for (int v=13; v >= 1; v--) {
			System.out.print(new Card(v,Suit.Clubs()).Unicode());
		}
		for (int v=13; v >= 1; v--) {
			System.out.print(new Card(v,Suit.Hearts()).Unicode());
		}
		System.out.println("");
	}
}