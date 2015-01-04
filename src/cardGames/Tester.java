package cardGames;
import javax.swing.JFrame;

import cardGames.Card.Face;
import cardGames.Card.Suit;

public class Tester {
	
	public static void main(String[] args){
		Hand testHand = new Hand();
		testHand.startHand();
		for(Card card1 : testHand.hand){
			card1.display();
		}
		System.out.println(testHand.getPoints());
		Dealer testDeal = new Dealer();
		testDeal.startHand();
		for(Card card1 : testDeal.hand){
			card1.display();
		}
		System.out.println(testDeal.getPoints());
		GUI gui = new GUI("BlackJack",testHand,testDeal);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(1000,800);
		gui.setVisible(true);
	}
}