package cardGames;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI extends JFrame{
	
	private DealerPanel dealerPanel;
	private PlayerPanel playerPanel;
	public Hand myHand;
	public Dealer dealHand;
	
	public GUI(String title, Hand myHand, Dealer dealHand){
		super(title);
		this.myHand = myHand;
		this.dealHand = dealHand;
		setLayout(new BorderLayout());
		
		dealerPanel = new DealerPanel(dealHand);
		playerPanel = new PlayerPanel(myHand, dealerPanel);
		
		Container c = getContentPane();
		
		c.add(dealerPanel,BorderLayout.NORTH);
		c.add(playerPanel,BorderLayout.SOUTH);
	}
}