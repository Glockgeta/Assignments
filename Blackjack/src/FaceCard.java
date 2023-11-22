
public class FaceCard extends Card {
	
	String[] faceCardValues = new String[] {"Jack", "Queen", "King"};
	
	
	public FaceCard() {
		pointValue = 10;
		cardNumber = faceCardValues[random.nextInt(2)];
		suit = Suits[random.nextInt(3) + 1];
	}
	

}