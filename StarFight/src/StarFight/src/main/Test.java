package main;

import java.awt.Color;
import java.awt.Graphics; 

import javax.swing.JFrame;
import javax.swing.JPanel;

import types.Laser;
import types.Ship;

public class Test extends JPanel{

	public static void main(String[] args) {
		JFrame F = new JFrame("Test Field");
		F.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		F.setSize(1600, 900);
		F.add(new Test());
		F.setVisible(true);
	}
	
	Laser Laser;
	Ship Ship;
	
	public Test()
	{
		Ship = new Ship("Purple",5.0,300,500,90);
		Laser = Ship.shoot();
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1600, 900);
		
		Ship.drawMovingShip(g, this);
		Laser.drawMovingLaser(g, this);
		repaint();
		
	}

}
