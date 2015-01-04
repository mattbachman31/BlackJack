package cardGames;

public class Dealer extends Hand{
	
	@Override
	public void startHand(){
		addCard();
		addCard();
		hand.get(1).flipCard();
	}
}
