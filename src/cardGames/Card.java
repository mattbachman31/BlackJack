package cardGames;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Card {
	private int value;
	public enum Suit{hearts,diamonds,spades,clubs};
	private Suit suit;
	public enum Face{DOWN,UP};
	private Face face;
	public String[] values = {"placehold lol","A","2","3","4","5","6","7","8","9","T","J","Q","K"};
	private int points = 0;
	public ImageIcon pic;
	
	public Card(int value, Suit suit, Face face, ImageIcon icon){
		this.value = value;
		this.suit = suit;
		this.face = face;
		this.pic = icon;
	}

	public int getValue() {
		return value;
	}

	public void display(){
		//String returner;
		if(face == Face.DOWN){
			System.out.println(" __________");
			System.out.println("|         |");
			System.out.println("|   /\\\\   |");
			System.out.println("|  /__\\\\  |");
			System.out.println("| /    \\\\ |");
			System.out.println("|_________|");
		} else {
			System.out.println(" __________");
			System.out.println("|        " + values[this.getValue()] + "|");
			System.out.println("|         |");
			if(suit == Suit.hearts){
				System.out.println("|  "+suit.toString() + " |");
			}else if(suit == Suit.diamonds){
				System.out.println("| "+suit.toString() + "|");

			}else if(suit == Suit.clubs){
				System.out.println("|  "+suit.toString() + "  |");

			}else if(suit == Suit.spades){
				System.out.println("|  "+suit.toString() + " |");

			}
			System.out.println("|         |");
			System.out.println("|"+ values[this.getValue()] + "________|");
		}

	}

	public void flipCard(){
		if(face == Face.DOWN){
			face = Face.UP;
			pic = new ImageIcon(Integer.toString(value) + "_of_" + suit.toString() + ".jpg"); 
			System.out.println(Integer.toString(value) + "_of_" + suit.toString() + ".jpg");
		}else if (face == Face.UP){
			face = Face.DOWN;
			pic = new ImageIcon("backgood.jpg");
		}
	}
	public int getPoints(){
		if(value == 1){
			points = 11;
		}
		else if(value == 11 || value == 12 || value == 13){
			points = 10;
		} 
		else {
			points = this.getValue();
		}
		return points;
	}

	public void setFace(Face face) {
		this.face = face;
	}

	public Face getFace() {
		return face;
	}
}