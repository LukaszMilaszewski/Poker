package zad3;

import java.util.ArrayList;

public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	void addCard(Card card) {
		cards.add(card);
	}
	
	int getCardValue(int i) {
		return getCard(i).getValue();
	}
	
	int getCardColor(int i) {
		return getCard(i).getColor();
	}
	
	int getNumberOfCards() {
		return cards.size();
	}
    
	Card getCard(int i) {
	    return cards.get(i);
	}
	
	ArrayList<Card> getCards() {
		return cards;
	}
	
	void printPlayerCards() {
		for (int i = 0; i < cards.size(); i++)
			System.out.print(getCard(i).getValue() + "" +getCard(i).getColor() + " ");
		System.out.println("");
	}
}
