class Deck {//extends Pile {
	public static void main(String[] args) {
		System.out.print(new Card(0,Suit.HEARTS).Unicode());
		System.out.print(new Card(0,Suit.SPADES).Unicode());
		for (int v=1; v <= 13; v++) {
			System.out.print(new Card(v,Suit.SPADES).Unicode());
		}
		for (int v=1; v <= 13; v++) {
			System.out.print(new Card(v,Suit.DIAMONDS).Unicode());
		}
		for (int v=13; v >= 1; v--) {
			System.out.print(new Card(v,Suit.CLUBS).Unicode());
		}
		for (int v=13; v >= 1; v--) {
			System.out.print(new Card(v,Suit.HEARTS).Unicode());
		}
		System.out.println("");
	}
}