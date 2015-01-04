package cardGames;

import java.util.ArrayList;
import java.util.Random;

public class Hand {
	private Boolean over = false; 
	private int points = 0; 
	ArrayList<Card> hand = new ArrayList<Card>();
	Deck deck = new Deck();
	int lowAceCount = 0;

	public void startHand(){
		addCard();
		addCard();
	}

	public void addCard(){
		Random rand = new Random();
		int cardNumber = rand.nextInt(deck.getDeckSize());
		Card card = deck.drawCard(cardNumber);
		hand.add(card);
		points = totalPoints();
	}
	
	public int totalPoints(){
		int total = 0;
		for(Card card: hand){
			total += card.getPoints();	
		}
		for(Card card: hand){
			if(total>21 && card.getPoints() == 11){
				total -= 10;
			}
		}
		return total;
	}
		

	public int getPoints() {
		return points;
	}
}