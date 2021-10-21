class Suit {
	int quality;
	private static String[] full_names = {"Clubs", "Hearts", "Diamonds", "Spades"};
	Suit (int q){
		quality = q;
	}
	public String toString() {
		return full_names[quality];
	}
	public int color() {
		return (quality & 1) ^ (quality >> 1);
	}
	public String Color() {
		if (color() == 1) {
			return "Red";
		} else {
			return "Black";
		}
	}
	public int unicode() {
		int i = (quality >> 1) | (quality & 1) << 1;
		i = 3-i;
		i *= 0x10;
		i += 0x1f0a0;
		return i;
	}
	public static Suit Spades() {
		return new Suit(3);
	}
	public static Suit Diamonds() {
		return new Suit(2);
	}
	public static Suit Hearts() {
		return new Suit(1);
	}
	public static Suit Clubs() {
		return new Suit(0);
	}
	public static void main(String[] args) {
		for (int q=0; q<=3; q++) {
			System.out.println(new Suit(q).unicode());
		}
	}
}