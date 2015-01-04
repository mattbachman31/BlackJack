package cardGames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cardGames.Card.Face;

public class PlayerPanel extends JPanel{
	private ImageIcon image1;
	private ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	private ImageIcon pointsLab;
	private int count = 0;
	private DealerPanel dealerPanel;
	private Hand myHand;
	private int x = 0;
	private int w = 0;
	private int l = 0;
	private JLabel result;
	private String msg = "";


	public PlayerPanel(final Hand myHand, final DealerPanel dealerPanel) {
		this.dealerPanel = dealerPanel;
		this.myHand = myHand;
		Dimension size = getPreferredSize();
		size.width = 1000;
		size.height = 400;
		setPreferredSize(size);
		this.setBackground(new Color(50,100,50));
		setBorder(BorderFactory.createTitledBorder("Player"));

		JButton restart  = new JButton("Restart");
		JButton hit = new JButton("Hit me!");
		JButton stay = new JButton("Stay");
		final JLabel points = new JLabel("None");

		image1 = myHand.hand.get(0).pic;
		image2 = myHand.hand.get(1).pic;
		image3 = new ImageIcon("back.jpg");
		image4 = new ImageIcon("back.jpg");
		image5 = new ImageIcon("back.jpg");
		pointsLab = new ImageIcon("pointsLabel.jpg");
		final JLabel imageLabel1 = new JLabel(image1);
		final JLabel imageLabel2 = new JLabel(image2);
		final JLabel imageLabel3 = new JLabel(image3);
		final JLabel imageLabel4 = new JLabel(image4);
		final JLabel imageLabel5 = new JLabel(image5);
		JLabel pointsLabel = new JLabel(pointsLab);
		points.setText(updatePoints());
		result = new JLabel("0 W/ 0 L");

		hit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==0){
					myHand.addCard();
					int index = myHand.hand.size()-1;
					image3 = myHand.hand.get(index).pic;
					points.setText(updatePoints());
					int size = myHand.hand.size();
					ImageIcon boom = myHand.hand.get(size-1).pic;
					if(count == 0){
						imageLabel3.setIcon(boom);
					}
					else if(count == 1){
						imageLabel4.setIcon(boom);
					}
					else if(count == 2){
						imageLabel5.setIcon(boom);
					}
					count++;
					if (Integer.parseInt(updatePoints()) > 21){
						x = 1;
						msg = "You busted with: " + updatePoints() + " and lost.";
						points.setText(msg);
						l += 1;
						result.setText(Integer.toString(w) + " W / " + Integer.toString(l) + " L");
						dealerPanel.dealHand.hand.get(1).flipCard();
						dealerPanel.image2 = dealerPanel.dealHand.hand.get(1).pic;
						dealerPanel.imageLabel2.setIcon(dealerPanel.image2);
						dealerPanel.points.setText(dealerPanel.updatePoints());
					}
				}  }
		});

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x ==1){
					x = 0;
					while(myHand.hand.size() != 0){
						Card cardRem = myHand.hand.get(0);
						myHand.hand.remove(cardRem);
						myHand.deck.putBack(cardRem);
					}
					while(dealerPanel.dealHand.hand.size() != 0){
						Card cardRem = dealerPanel.dealHand.hand.get(0);
						dealerPanel.dealHand.hand.remove(cardRem);
						dealerPanel.dealHand.deck.putBack(cardRem);
					}
					image3 = new ImageIcon("back.jpg");
					image4 = new ImageIcon("back.jpg");
					image5 = new ImageIcon("back.jpg");
					imageLabel3.setIcon(image3);
					imageLabel4.setIcon(image4);
					imageLabel5.setIcon(image5);
					points.setText("0");
					count = 0;
					dealerPanel.dealRest();
					myHand.startHand();
					image1 = myHand.hand.get(0).pic;
					image2 = myHand.hand.get(1).pic;
					imageLabel1.setIcon(image1);
					imageLabel2.setIcon(image2);
					points.setText(updatePoints());
					dealerPanel.dealHand.startHand();
					image1 = dealerPanel.dealHand.hand.get(0).pic;
					image2 = dealerPanel.dealHand.hand.get(1).pic;
					dealerPanel.imageLabel1.setIcon(image1);
					dealerPanel.imageLabel2.setIcon(image2);
					dealerPanel.points.setText("N/A");
					dealerPanel.count = 0;
				}
			}
		}
				);


		stay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(x==0){
					x = 1;
					dealerPanel.play();

					if(Integer.parseInt(dealerPanel.updatePoints()) == myHand.getPoints()){
						msg = "Dealer won by push.";
						l += 1;
					}else if(myHand.getPoints() > Integer.parseInt(dealerPanel.updatePoints())){
						msg = "You win!";
						w += 1;
					}else if(Integer.parseInt(dealerPanel.updatePoints()) > myHand.getPoints() && Integer.parseInt(dealerPanel.updatePoints()) <22){
						msg = "Dealer wins.";
						l += 1;
					}else if(myHand.hand.size() == 5 && myHand.getPoints() <22 && dealerPanel.dealHand.hand.size() == 5 && Integer.parseInt(dealerPanel.updatePoints()) <22){
						msg = "Dealer won by push.";
						l += 1;
					}else if(myHand.hand.size() == 5 && myHand.getPoints() <22){
						msg = "You won by reaching 5 cards with under 21 points!";
						w += 1;
					}else if(dealerPanel.dealHand.hand.size() == 5 && Integer.parseInt(dealerPanel.updatePoints()) <22){
						msg = "Dealer won by reaching 5 cards with under 21 points.";
						l += 1;
					}else if(Integer.parseInt(dealerPanel.updatePoints()) > 21){
						msg = "Dealer busted and you win!";
						w += 1;
					}
					points.setText(msg);
					result.setText(Integer.toString(w) + " W / " + Integer.toString(l) + " L");
				}
			}});


		setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 1;
		c.weighty = 4;
		c.anchor = GridBagConstraints.SOUTH;

		c.gridx = 0;
		c.gridy = 0;
		add(hit,c);

		c.gridx = 5;
		c.gridy = 0;
		add(result,c);

		c.anchor = GridBagConstraints.NORTH;

		c.gridx = 0;
		c.gridy = 1;

		add(stay,c);

		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 1;
		c.gridy = 0;

		add(pointsLabel,c);
		c.anchor = GridBagConstraints.SOUTH;
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.SOUTH;

		add(restart,c);
		c.anchor = GridBagConstraints.NORTH;

		c.gridx = 1;
		c.gridy = 1;
		add(points,c);

		c.weightx = 1;
		c.weighty = 4;

		c.gridx = 0;
		c.gridy = 2;
		add(imageLabel1,c);

		c.gridx = 1;
		c.gridy = 2;
		add(imageLabel2,c);

		c.gridx = 2;
		c.gridy = 2;
		add(imageLabel3,c);

		c.gridx = 3;
		c.gridy = 2;
		add(imageLabel4,c);

		c.gridx = 4;
		c.gridy = 2;
		add(imageLabel5,c);

	}

	public String updatePoints(){
		int updatedPoints = myHand.getPoints();
		String pointString = Integer.toString(updatedPoints);
		return pointString;
	}
}