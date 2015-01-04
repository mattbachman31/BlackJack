package cardGames;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import cardGames.Card.Face;
import cardGames.Card.Suit;

public class Deck {
	public ArrayList<Card> deck1 = new ArrayList<Card>();
	
	public Deck(){
		Suit theSuit;
		for(int i=1; i<14; i++){
			theSuit = Suit.hearts;
			Card newCard = new Card(i,theSuit,Face.UP,new ImageIcon(Integer.toString(i) + "_of_" + theSuit.toString() + ".jpg"));
			deck1.add(newCard);
		}
		for(int i=1; i<14; i++){
			theSuit = Suit.diamonds;
			Card newCard = new Card(i,theSuit,Face.UP,new ImageIcon(Integer.toString(i) + "_of_" + theSuit.toString() + ".jpg"));
			deck1.add(newCard);
			}
		for(int i=1; i<14; i++){
			theSuit = Suit.clubs;
			Card newCard = new Card(i,theSuit,Face.UP,new ImageIcon(Integer.toString(i) + "_of_" + theSuit.toString() + ".jpg"));
			deck1.add(newCard);
			}
		for(int i=1; i<14; i++){
			theSuit = Suit.spades;
			Card newCard = new Card(i,theSuit,Face.UP,new ImageIcon(Integer.toString(i) + "_of_" + theSuit.toString() + ".jpg"));
			deck1.add(newCard);
			}
	}
	
	public int getDeckSize(){
		return deck1.size();
	}
	
	public Card drawCard(int index){
		Card retCard = deck1.get(index);
		deck1.remove(index);
		return retCard;
	}
	public void putBack(Card c){
		deck1.add(c);
	}
}
