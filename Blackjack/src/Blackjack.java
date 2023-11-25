import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Blackjack {
	private int chips;
	private int betAmount;
	static int playerScore;
	static int dealerScore;
	private static final int BUST = 21; //made BUST static to allow static tester for access
	private boolean hitNext = true;
	private HashSet<Card> deck;
	
	
	public Blackjack() { //constructor for chips=1000
		chips=1000;
	}
	
	public boolean play(Scanner sc) {
	  
	    playerScore = 0;
	    dealerScore = 0;
	   
	    bet(sc);
	    initialize();

	    // check for a blackjack
	    if (playerScore == BUST) {
	        System.out.println("Congratulations. You have a blackjack!");
	        chips += betAmount * 3 / 2; // Blackjack payout
	        return true;
	    }

	    // check if the player wants to hit or stand
	    prompt(sc);

	    return true;
	}

	
	
	public void bet(Scanner sc) {
		System.out.println("How much would you like to bet? Whole numbers of chips only. You have " + chips + " Chips.");
		

		betAmount = sc.nextInt();
		while (betAmount > chips) {
			System.out.println("Error: Bet too large. Please try again.");
			betAmount = sc.nextInt();
		}
		System.out.println("You are betting " + betAmount + " chips on this hand.");
	}
	
	public void initialize() {//sets hashmap deck
	    Card dealerCard1 = new Card(); // visible card
	    dealerScore += dealerCard1.getPointValue();
	    
	    Card dealerCard2;
	    do {
	        dealerCard2 = new Card(); // invisible card
	    } while (dealerCard2.getCard().equals(dealerCard1.getCard())); // ensure the invisible card is different
	    
	    dealerScore += dealerCard2.getPointValue();

	    Card playerCard1 = new Card();
	    playerScore += playerCard1.getPointValue();
	    Card playerCard2 = new Card();
	    playerScore += playerCard2.getPointValue();
	    
	    if (playerCard1.getPointValue() + playerCard2.getPointValue() == 21) {
	        System.out.println("Congratulations. You have a blackjack!");
	    } else {
	        System.out.println("You have the " + playerCard1.getCard() + " and the " + playerCard2.getCard()
	                            + ". Your total point value is " + playerScore + ". ");
	        System.out.println("The visible dealer card is the " + dealerCard1.getCard() + ". ");
	        // removed user prompt for 'H' or 'S'
	    }
	}

	public void hitReturn(Scanner sc) {
	    Card playerCard3 = new Card(); 
	    playerScore += playerCard3.getPointValue();

	    System.out.println("You picked up the " + playerCard3.getCard() + ".");
	    System.out.println("Your total point value is now " + playerScore + ".");

	    if (isBust()) {
	        System.out.println("Bust! You went over 21. You lose!");

	       
	        chips -= betAmount;


	    } else {
	        prompt(sc); 
	    }
	}

	public void stand(Scanner sc) {
	    Card dealerCard2 = new Card();
	    dealerScore += dealerCard2.getPointValue();
	    System.out.println("Dealer's invisible card is the " + dealerCard2.getCard() + ".");

	    while (dealerScore <= 16) {
	        Card dealerCard = new Card();
	        dealerScore += dealerCard.getPointValue();
	        System.out.println("Dealer picked up the " + dealerCard.getCard() + ".");
	    }

	    System.out.println("Dealer's total point value is " + dealerScore + ".");

	    if (dealerScore > BUST) {
	        System.out.println("Dealer busts! You win!");
	        chips += betAmount;
	    } else if (playerScore > dealerScore) {
	        System.out.println("You win!");
	        chips += betAmount;
	    } else if (playerScore < dealerScore) {
	        System.out.println("Dealer wins. You lose!");
	        chips -= betAmount;
	    } else {
	        System.out.println("It's a draw!");
	    }
	}










	public void prompt(Scanner sc) { // asks the player whether they want to hit or stand
	    System.out.println("Press H to hit.");
	    System.out.println("Press S to stand.");

	    String hitStand = sc.next();

	    switch (hitStand.toUpperCase()) {
	        case "H":
	            hitReturn(sc); // pass the Scanner when calling hitReturn
	            break;
	        case "S":
	         stand(sc);
	            break;
	        default:
	            System.out.println("Invalid input. Please enter H to hit or S to stand.");
	            prompt(sc); // ask the player again if the input is invalid
	    }
	}

	
	
	
	
	public void deckFill() {
	    deck = new HashSet<>(); //initialize the HashSet

	    for (int j = 0; j < 4; j++) {
	        for (int i = 0; i < 13; i++) {
	            Card card;
	            if (i < 9) {
	                card = new Card(i, j);
	            } else if ((i > 8) && (i < 12)) {
	                card = new FaceCard();
	            } else {
	                card = new AceCard();
	            }

	            deck.add(card);
	        }
	    }

	    
	    System.out.println("Deck has been filled with cards.");
	}

	
	public boolean isBust() {
		if (playerScore > 21) {
			return true;
		} else {
			return false;
		}
	}
	public int getChips() {
        return chips;
    }
	
	
	
	
	public static void main(String[] args) {
	    Blackjack game = new Blackjack();
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Blackjack! Press the Enter key to begin.");
	    sc.nextLine();

	    while (game.play(sc)) {
	      
	        if (game.getChips() <= 0) {
	            System.out.println("You are out of chips. Game over!");
	            break;
	        }

	        System.out.println("Do you want to play another hand? (Y/N)");
	        String playAgain = sc.next();
	        if (playAgain.equalsIgnoreCase("N")) {
	            break;
	        }
	    }

	    sc.close();
	    System.out.println("Thanks for playing!");
	}


}