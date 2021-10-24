class Pile {
	Card topCard;
	Card endCard;
	int nCards;
	public Pile() {
		topCard = null;
		endCard = null;
		nCards = 0;
	}
	public void addCard_top(Card card) {
		nCards++;
		if (topCard == null) {
			topCard = card;
			endCard = card;
		} else {
			topCard.prev = card;
			card.next = topCard;
			topCard = card;
		}
	}
	public void addCard_end(Card card) {
		if (endCard == null) {
			addCard_top(card); // DRY
		} else {
			nCards++;
			endCard.next = card;
			card.prev = endCard;
			endCard = card;
		}
	}
	public Card remCard_top() {
		nCards--;
		Card card = topCard;
		if (nCards > 0) {
			topCard = topCard.next;
			topCard.prev = null;
			card.next = null;
		}
		return card;
	}
	public Card remCard_end() {
		nCards--;
		Card card = endCard;
		if (nCards > 0) {
			endCard = endCard.prev;
			endCard.next = null;
			card.prev = null;
		}
		return card;
	}
	public Card seeCard_top() {
		return topCard;
	}
	public Card seeCard_end() {
		return endCard;
	}
	public Card seeCard_at(int index) {
		if (index >= 0) {
			int count = 0;
			Card card = topCard;
			while (count < index) {
				card = card.next;
				count++;
			}
			return card;
		} else {
			int count = -1;
			Card card = endCard;
			while (count > index) {
				card = card.prev;
				count--;
			}
			return card;
		}
	}
	public Card remCard_at(int index) {
		nCards--;
		if (index >= 0) {
			int count = 0;
			Card card = topCard;
			while (count < index) {
				card = card.next;
				count++;
			}
			if (card.next == null) {
				endCard = card.prev;
			} else {
				card.next.prev = card.prev;
			}
			if (card.prev == null) {
				topCard = card.next;
			} else {
				card.prev.next = card.next;
			}
			card.next = null;
			card.prev = null;
			return card;
		} else {
			int count = -1;
			Card card = endCard;
			while (count > index) {
				card = card.prev;
				count--;
			}
			if (card.next == null) {
				endCard = card.prev;
			} else {
				card.next.prev = card.prev;
			}
			if (card.prev == null) {
				topCard = card.next;
			} else {
				card.prev.next = card.next;
			}
			card.next = null;
			card.prev = null;
			return card;
		}
	}
	// public Card remCardRandom() {	
	// }
	public String toString() {
		String result = "";
		Card card = topCard;
		while (card != null) {
			result += String.valueOf(card.Unicode());
			card = card.next;
		}
		return result;
	}
	public static void main(String[] args) {
		Pile pile = new Pile();
		pile.addCard_end(new Card(1,Suit.SPADES));
		pile.addCard_end(new Card(1,Suit.HEARTS));
		pile.addCard_end(new Card(2,Suit.HEARTS));
		pile.addCard_end(new Card(3,Suit.HEARTS));
		pile.addCard_end(new Card(4,Suit.HEARTS));
		pile.addCard_end(new Card(5,Suit.HEARTS));
		pile.addCard_end(new Card(6,Suit.HEARTS));
		pile.addCard_end(new Card(7,Suit.HEARTS));
		pile.addCard_end(new Card(8,Suit.HEARTS));
		pile.addCard_end(new Card(9,Suit.HEARTS));
		System.out.println(pile.remCard_at(-4));
		System.out.println(pile);
	}
}