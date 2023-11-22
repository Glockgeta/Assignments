import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
	private int chips;
	private int betAmount;
	static int playerScore;
	static int dealerScore;
	private static final int BUST = 21; //made BUST static to allow static tester for access
	private boolean hitNext = true;
	private HashSet<Card> deck;
	
	
	
	
	public boolean play(Scanner sc) { //True = game won, false = game lost
		chips = 1000;
		bet(sc);
		initialize();
		prompt();
		
		
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
	
	public void initialize() { //sets up the HashMap deck
		Card dealerCard1 = new Card(); //visible card
		dealerScore += dealerCard1.getPointValue();
		Card dealerCard2 = new Card(); //invisible card
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
			System.out.println("Press H to hit."); //should only display these two if not BUST
			System.out.println("Press S to stand."); //see note above 
		}
	} 
	public void hitReturn(Scanner sc) { // pass the Scanner as a parameter
	    Card playerCard3 = new Card(); // penerate a new random card
	    playerScore += playerCard3.getPointValue();

	    System.out.println("You picked up the " + playerCard3.getCard() + ".");
	    System.out.println("Your total point value is now " + playerScore + ".");

	    if (isBust()) {
	        System.out.println("Bust! You went over 21. You lose!");
	      
	    } else {
	        prompt(sc); // pass the Scanner when calling prompt
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
	         
	            break;
	        default:
	            System.out.println("Invalid input. Please enter H to hit or S to stand.");
	            prompt(sc); // ask the player again if the input is invalid
	    }
	}

	
	
	
	
	public void deckFill() { //randomly chooses card between 1 and 13
		String tempCardName;
		
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 13; i++) {
				if (i < 9) {
					System.out.print("Number card. ");
				} else if ((i > 8) && (i < 12)) {
					System.out.print("Face card. ");
				} else {
					System.out.print("Ace.");
				}
				
				Card card = new Card(i, j);
				deck.add(card);
				
				//System.out.println("cardIndex " + (i + 1) + ", suitIndex " + (j + 1));
				
				//on i = 0-8: Card.java
				//on i = 9-11: FaceCard.java
				//on i = 12: AceCard
				//each instance has a suit, happens 4X
			}
		}
	}
	
	public boolean isBust() {
		if (playerScore > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		Blackjack game = new Blackjack();
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("Blackjack! Press the Enter key to begin.");
		
		sc.nextLine();
		
		game.play(sc);
		
		game.deckFill();
		
		
		
		String hitStand;
		
		
			
		hitStand = sc.next();
		
		while (hitStand.equals("H")) {
		    game.hitReturn(sc);

		    if (playerScore > BUST) {
		        break;
		    }

		    System.out.println("Press H to hit.");
		    System.out.println("Press S to stand.");
		    hitStand = sc.next();
		}

			
		System.out.println("BALLS"); 
		
		
	}

}