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
        pointValue = random.nextInt(12) + 2;
        if (pointValue < 11) {
            cardNumber = Numbers[pointValue - 2];
        }

        if (pointValue >= 11 && pointValue <=13) {
            pointValue = 10;
            cardNumber = FaceCard.generateFaceCard();
        }
        else if (pointValue == 14) {
            pointValue = 11;
            cardNumber = "Ace";
        }

        suit = Suits[random.nextInt(4)];
    }


    public Card(int number, int cardSuit) {
        if (number >= 2 && number <= 10) {
            cardNumber = Numbers[number - 2];
            pointValue = number;
        } 
        else if (number >= 11 && number <= 13) {
            cardNumber = FaceCard.generateFaceCard();
            pointValue = 10;
        }
        else if (number == 14) {
            cardNumber = "Ace";
            pointValue = 11;
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