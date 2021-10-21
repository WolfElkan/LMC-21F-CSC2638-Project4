class Pile {
	Card topCard;
	Card endCard;
	public Pile() {
		topCard = null;
		endCard = null;
	}
	public void addCard_top(Card card) {
		if (topCard == null) {
			topCard = card;
			endCard = card;
		} else {
			topCard.prev = card
			card.next = topCard;
			topCard = card;
		}
	}
	public void addCard_end(Card card) {
		if (endCard == null) {
			addCard_top(card); // DRY
		} else {
			endCard.next = card
			card.prev = endCard;
			endCard = card;
		}
	}
	public Card remCard_top() {

	}
	public Card remCard_end() {
		
	}
	public Card seeCard_top() {

	}
	public Card seeCard_end() {
		
	}
	public static void main(String[] args) {
		FiveOfHearts = new Card(5,)
	}
}