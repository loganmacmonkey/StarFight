package main;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import types.Ship;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.*;

//controls all of setup
public class Main {
	
	static int TA=0;
	
	//The Window (The JFrame)
	static JFrame f;
	
	//The Panel everything gets drawn to.
	static JPanel p = new JPanel();
	
	//The way things are going to be added
	//to the Main Panel which makes it so you
	//can have several different panels switch
	//out on top of it.
	static CardLayout CL = new CardLayout();
	
	//Runs on Start-Up.
	public static void main(String[] args)
	{new Main();}
	
	//Setup & Launching the Panel which finds how many turns
	//you'd like to decide at a time
	public Main()
	{
		//stores the Height & Width of the Screen.
		int SWidth = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int SHeight = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		
		//Creates the Screen Dimensions
		Dimension FSize = new Dimension(SWidth, 480);
		
		//Frame setup
		f = new JFrame("StarFight!");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(FSize);
		f.setResizable(true);
		f.setLocation(0,(int)(SHeight / 2.0 - (SWidth / 8.0)));
		
		//Adds Main Panel to the Frame
		f.add(p);
		
		//Sets the Layout to a CardLayout created up top.
		p.setLayout(CL);
		p.setFocusable(true);
		
		//Launches Panel which asks for how many turns you'd like
		//to decide at a time and puts it on the JPanel.
		new AheadInput();
		
		//Shows it on the Frame
		CL.show(p, "1");
		
		//Opens the Window (Frame).
		f.setVisible(true);
	}
	
	//After getting how many turns you'd like to decide
	//at a time, ask which ships P1 & P2 would like to use.
	public static void proceed1(int turns)
	{
		TA = turns;
		new ShipSelect();
		CL.show(p, "2a");
	}
	
	//After getting which ships P1 & P2 would 
	//like to use, start the game.
	public static void proceed2(Ship P1, Ship P2)
	{
		new Game(TA,P1,P2);
		CL.show(p, "3");
	}
	
	public static JPanel getJPanel()
	{return p;}
	
	public static CardLayout getCardLayout()
	{return CL;}
	
}
