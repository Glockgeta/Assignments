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
		return pointValue; 
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
		suit = Suits[random.nextInt(4)];
	}

	
	public Card(int number, int cardSuit) {
	    if (number >= 2 && number <= 10) {
	        cardNumber = Numbers[number - 2];
	        pointValue = number;
	    } 
	    else if (number >= 11 && number <= 13) {
	        FaceCard faceCard = new FaceCard();
	        cardNumber = faceCard.getCardNumber();
	        pointValue = faceCard.getPointValue();
	    }
	    else if (number == 14) {
	        AceCard aceCard = new AceCard();
	        cardNumber = aceCard.getCardNumber();
	        pointValue = aceCard.getPointValue();
	    } else {
	        
	        cardNumber = "Invalid";
	        pointValue = 0;
	    }

	    suit = Suits[cardSuit];
	}


	
	
	public void print() {
		System.out.println("Current card: " + cardNumber + " of " + suit);
	}
	
	public String getCard() {
		return cardNumber + " of " + suit;
	}


	
}