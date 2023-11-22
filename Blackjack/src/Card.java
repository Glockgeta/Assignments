import java.util.Random;

public class Card {
	String[] Suits = new String[] {"Hearts", "Spades", "Diamonds", "Clubs"};
	String[] Numbers = new String[] {"Two", "Three", "Four", "Five", "Six", 
									"Seven", "Eight", "Nine", "Ten"};
	
	Random random = new Random();
	
	protected int pointValue;
	protected String cardNumber;
	protected String suit;
	protected boolean isAce = false;
		

	public int getPointValue() {
		return pointValue; //Idea- make superclass skeleton so getPointValue can draw numbers, faces, and ace. 
	}
	
	public void setPointValue(int value) {
		pointValue = value;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	
	public Card() { //for infinite decks
		pointValue = random.nextInt(8) + 2;
		cardNumber = Numbers[pointValue - 2];
		suit = Suits[random.nextInt(3) + 1];
	}

	
	public Card(int number, int cardSuit) { //for random deck generation from numbers
		cardNumber = Numbers[number - 2];
		suit = Suits[cardSuit];
		pointValue = number;
	}
	
	
	public void print() {
		System.out.println("Current card: " + cardNumber + " of " + suit);
	}
	
	public String getCard() {
		return cardNumber + " of " + suit;
	}
	
}