package zad3;

public class Card implements Comparable<Card> {
	private int value;
	private int color;
	 
	 Card(int value, int  color) {
		 this.value = value;
		 this.color = color;	 
	 }
	 
	 int getValue() {
		 return value;
	 }
	 
	 int getColor() {
		 return color;
	 }

	@Override
	public int compareTo(Card card) {
		return Integer.compare(value, card.value);
	}
}
