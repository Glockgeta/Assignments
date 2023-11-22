
public class AceCard extends Card {
	
	@override
	public Card(int number, int cardsuit) {
		cardNumber = Numbers
	}
	
	public AceCard() {
		isAce = true;
		pointValue = 11;
		cardNumber = "Ace";
	}
	
	public void softAce() {
		pointValue = 1;
	}
	
}