class Pile {
	Card topCard;
	Card endCard;
	protected int nCards;
	public Pile() {
		topCard = null;
		endCard = null;
		nCards = 0;
	}
	public int numCards() {
		return nCards;
	}
	private Card remove(Card card) {
		nCards--;
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
	private void addCard_empty(Card newCard) {
		if (nCards != 0 || topCard != null || endCard != null) {
			throw new IllegalStateException("Pile is not empty");
		} else {
			topCard = newCard;
			endCard = newCard;
			nCards = 1;
		}
	}
	private void addCard_before(Card indexCard, Card newCard) {
		if (nCards == 0) {
			addCard_empty(newCard);
		} else {
			nCards++;
			newCard.next = indexCard;
			if (indexCard.prev != null) {
				newCard.prev = indexCard.prev;
				indexCard.prev.next = newCard;
			} else {
				topCard = newCard;
			}
			indexCard.prev = newCard;
		}
	}
	private void addCard_behind(Card indexCard, Card newCard) {
		if (nCards == 0) {
			addCard_empty(newCard);
		} else {
			nCards++;
			newCard.prev = indexCard;
			if (indexCard.next != null) {
				newCard.next = indexCard.next;
				indexCard.next.prev = newCard;
			} else {
				endCard = newCard;
			}
			indexCard.next = newCard;
		}
	}
	public Card getCard_at(int index) {
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
	public void addCard_top(Card card) {
		addCard_before(topCard, card);
	}
	public void addCard_end(Card card) {
		addCard_behind(endCard, card);
	}
	public void addCard_at(Card newCard, int index) {
		if (index == 0) {
			addCard_top(newCard);
		} else if (index == -1) {
			addCard_end(newCard);
		} else {
			addCard_before(getCard_at(index), newCard);
		}
	}
	public void addCard_sort(Card newCard) {
		if (nCards == 0) {
			addCard_empty(newCard);
		} else {
			Card card = topCard;
			if (newCard.compareTo(card) == 1) {
				addCard_top(newCard);
			} else {
				while (card.next != null && newCard.compareTo(card.next) == -1) {
					card = card.next;
				}
				addCard_behind(card, newCard);
			}
		}
	}	
	public Card remCard_top() {
		return remove(topCard);
	}
	public Card remCard_end() {
		return remove(endCard);
	}
	public Card getCard_top() {
		return topCard;
	}
	public Card getCard_end() {
		return endCard;
	}
	public Card remCard_at(int index) {
		return remove(getCard_at(index));
	}
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
		pile.addCard_sort(new Card(1,Suit.HEARTS));
		pile.addCard_sort(new Card(1,Suit.SPADES));
		pile.addCard_sort(new Card(2,Suit.HEARTS));
		pile.addCard_sort(new Card(7,Suit.HEARTS));
		pile.addCard_sort(new Card(3,Suit.HEARTS));
		pile.addCard_sort(new Card(4,Suit.HEARTS));
		pile.addCard_sort(new Card(5,Suit.HEARTS));
		pile.addCard_sort(new Card(6,Suit.HEARTS));
		pile.addCard_sort(new Card(8,Suit.HEARTS));
		pile.addCard_sort(new Card(9,Suit.HEARTS));
		// System.out.println(pile.remCard_at(-4));
		System.out.println(pile);
	}
}