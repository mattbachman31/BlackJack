package cardGames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cardGames.Card.Face;
import cardGames.Card.Suit;

public class DealerPanel extends JPanel{
	private ImageIcon image1;
	public ImageIcon image2;
	private ImageIcon image3;
	private ImageIcon image4;
	private ImageIcon image5;
	public JLabel imageLabel1;
	public JLabel imageLabel2;
	private JLabel imageLabel3;
	private JLabel imageLabel4;
	private JLabel imageLabel5;
	public JLabel points;
	public Hand dealHand;
	public int count = 0;
	private ImageIcon pointsLab;

	
	public DealerPanel(Hand dealHand){
		this.dealHand = dealHand;
		Dimension size = getPreferredSize();
		size.width = 1000;
		size.height = 360;
		setPreferredSize(size);
		this.setBackground(new Color(50,100,50));
		setBorder(BorderFactory.createTitledBorder("Dealer"));
		
		image1 = dealHand.hand.get(0).pic;
		image2 = dealHand.hand.get(1).pic;
		imageLabel1 = new JLabel(image1);
		imageLabel2 = new JLabel(image2);
		points = new JLabel("N/A");
		pointsLab = new ImageIcon("pointsLabel.jpg");

		
		image3 = new ImageIcon("back.jpg");
		image4 = new ImageIcon("back.jpg");
		image5 = new ImageIcon("back.jpg");
		imageLabel3 = new JLabel(image3);
		imageLabel4 = new JLabel(image4);
		imageLabel5 = new JLabel(image5);
		imageLabel5 = new JLabel(image5);
		JLabel pointsLabel = new JLabel(pointsLab);

		setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.anchor = GridBagConstraints.NORTH;

		c.weightx = 1;
		c.weighty = .01;
		
		c.gridx = 1;
		c.gridy = 0;
		add(pointsLabel,c);
		
		c.gridx = 1;
		c.gridy = 1;
		add(points,c);
		
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;

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
		int updatedPoints = dealHand.getPoints();
		String pointString = Integer.toString(updatedPoints);
		return pointString;
	}
	
	public void play(){
		points.setText(updatePoints());
		dealHand.hand.get(1).flipCard();
		ImageIcon boop = dealHand.hand.get(1).pic;
		imageLabel2.setIcon(boop);
		while(dealHand.getPoints() < 17){
			dealHand.addCard();
			int index = dealHand.hand.size()-1;
			image3 = dealHand.hand.get(index).pic;
			points.setText(updatePoints());
			int size = dealHand.hand.size();
			ImageIcon boom = dealHand.hand.get(size-1).pic;
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
			
		}			
		points.setText(updatePoints());
		if (Integer.parseInt(updatePoints()) > 21){
			points.setText("Dealer busted with: " + updatePoints());
		}
	}
	public void dealRest(){
		image3 = new ImageIcon("back.jpg");
		image4 = new ImageIcon("back.jpg");
		image5 = new ImageIcon("back.jpg");
		imageLabel3.setIcon(image3);
		imageLabel4.setIcon(image4);
		imageLabel5.setIcon(image5);
		points.setText("0");
		count = 0;
	}
}