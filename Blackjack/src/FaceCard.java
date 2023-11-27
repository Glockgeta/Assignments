import java.util.Random;

public class FaceCard extends Card  {
    private static Random random = new Random();

    public static String generateFaceCard() {
        String[] faceCardValues = new String[] {"Jack", "Queen", "King"};
        return faceCardValues[random.nextInt(3)];
    }


    public FaceCard() {
        pointValue = 10;
        cardNumber = generateFaceCard();
        suit = Suits[random.nextInt(4)];
    }


}