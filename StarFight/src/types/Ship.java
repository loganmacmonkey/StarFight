package types;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Ship {
	
	private String color = "B&W";
	private int colorNum = 0;
	private BufferedImage ship;
	private double x = 0;
	private double y = 0;
	private double rotation = 0.00;
	private double scale = 20.0;
	private int player = 0;
	
	//Creates Ship
	public Ship(String color, int x, int y)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
	}
	//Creates Ship
	public Ship(int colorNum, int x, int y)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
		this.x = x;
		this.y = y;
	}
	//Creates Ship
	public Ship(String color, int x, int y, int rotation)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Ship
	public Ship(int colorNum, int x, int y,int rotation)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Ship
	public Ship(String color,double scale, int x, int y, int rotation)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
		} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Ship
	public Ship(int colorNum,double scale, int x, int y,int rotation)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Ship
	public Ship(int colorNum, int x, int y, int rotation, int player)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.player = player;
	}
	//Creates Ship
	public Ship(String color, int x, int y, int rotation, int player)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.player = player;
	}
	//Creates Ship
	public Ship(int colorNum,double scale, int x, int y, int rotation, int player)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.player = player;
	}
	//Creates Ship
	public Ship(String color,double scale, int x, int y, int rotation, int player)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
		} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		this.player = player;
	}
	public String getColor() {
		return color;
	}
	
	//Finds the Color Name of a Color Number. (ex: 1 -> Red)
	public String getColor(int colorNum) {
		if (colorNum == 0){
			return "B&W";
		}else if (colorNum == 1){
			return "Red";
		}else if (colorNum == 2) {
			return "Green";
		}else if (colorNum == 3) {
			return "Blue";
		}else if (colorNum == 4) {
			return "Purple";
		}else if (colorNum == 5) {
			return "Orange";
		}else if (colorNum == 6) {
			return "Yellow";
		}else if (colorNum == 7) {
			return "Cyan";
		}else {
			return "B&W";
		}
	}
	
	//Changes the color through the color name
	public void setColor(String color) {
		this.color = color;
		this.colorNum = getColorNum(color);
		setShip();
	}
	public int getXInt() {
		return (int)Math.floor(this.x);
	}
	public double getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public int getYInt() {
		return (int)Math.floor(this.y);
	}
	public double getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public int getRotationInt() {
		return (int) rotation;
	}
	public double getRotation() {
		return rotation;
	}
	public void setRotation(int rotation) {
		this.rotation = rotation % 360;
	}
	public void setRotation(double rotation) {
		this.rotation = rotation % 360.00;
	}
	public double getScale()
	{
		return this.scale;
	}
	public void setScale(double scale)
	{
		this.scale = scale;
	}
	public int getPlayer() {
		return player;
	}
	public void setPlayer(int player) {
		this.player = player;
	}
	public String getCoordinates()
	{
		return "(" + this.x + "," + this.y + ")";
	}
	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public int getColorNum() {
		return colorNum;
	}
	
	//Finds the Color Number of a Color Name. (ex: Red -> 1)
	public int getColorNum(String color) {
		if (color.equalsIgnoreCase("B&W") || color.equalsIgnoreCase("Black & White") || color.equalsIgnoreCase("Black and White")){
			return 0;
		}else if (color.equalsIgnoreCase("red")){
			return 1;
		}else if (color.equalsIgnoreCase("green")) {
			return 2;
		}else if (color.equalsIgnoreCase("blue")) {
			return 3;
		}else if (color.equalsIgnoreCase("purple")) {
			return 4;
		}else if (color.equalsIgnoreCase("orange")) {
			return 5;
		}else if (color.equalsIgnoreCase("yellow")) {
			return 6;
		}else if (color.equalsIgnoreCase("cyan")) {
			return 7;
		}else {
			return 0;
		}
	}
	
	//Changes the color through the color number
	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
		this.color = getColor(colorNum);
		setShip();
	}
	public BufferedImage getShip() {
		return ship;
	}
	
	//finds the image of the Ship
	//with the same color number as inputed.
	public BufferedImage getShip(int colorNum) {
		try {
			return ImageIO.read(new File(getColor(colorNum)+" Ship.png"));
			} catch (IOException e) {}
		return ship;
	}
	
	//finds the image of the Ship
	//with the same color name as inputed.
	public BufferedImage getShip(String color) {
		try {
			return ImageIO.read(new File(color+" Ship.png"));
			} catch (IOException e) {}
		return ship;
	}
	
	//finds & sets the image to the Laser
	//as the image named the same color
	public void setShip() {
		try {
			this.ship = ImageIO.read(new File(getColor()+" Ship.png"));
			} catch (IOException e) {}
	}
	
	//moves the ship a pixel forward in the
	//direction it's rotated in (facing).
	public void forward()
	{
		setX(getX() + Math.sin(Math.PI*getRotation()/180));
		setY(getY() - Math.cos(Math.PI*getRotation()/180));
	}
	
	//moves the ship a number of pixels forward
	//in the direction it's rotated in (facing).
	public void forward(double distance)
	{
		setX(getX() + Math.sin(Math.PI*getRotation()/180)*distance);
		setY(getY() - Math.cos(Math.PI*getRotation()/180)*distance);
	}
	
	//creates a Laser object which is in front
	//of the ship & of the same color &
	//rotation as the ship.
	public Laser shoot()
	{
		return new Laser(getColor(),getScale(),(int)(getX() + Math.sin(Math.PI*getRotation()/180)*11.5*getScale()),(int)(getY() - Math.cos(Math.PI*getRotation()/180)*11.5*getScale()),getRotationInt());
	}
	
	//Draws the Ship to the JComponent of your choosing.
	public void drawShip(Graphics g, JComponent F)
	{
		double Width = scale * getShip().getWidth();
		double Height = scale * getShip().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(scale, scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),at,F);
	}
	
	//Draws the Ship any size of JComponent of your choosing.
	public void drawShip(double Scale,Graphics g, JComponent F)
	{
		double Width = Scale * getShip().getWidth();
		double Height = Scale * getShip().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(Scale, Scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),at,F);
	}
	
	//Draws the Laser to the JComponent of your choosing
	//& automatically moves it forward for you before hand.
	public void drawMovingShip(Graphics g, JComponent F)
	{
		forward(scale/100.0);
		
		double Width = scale * getShip().getWidth();
		double Height = scale * getShip().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(scale, scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),at,F);
	}
	
	//Draws the Laser any size of JComponent of your choosing
	//& automatically moves it forward for you before hand.
	public void drawMovingShip(double Scale,Graphics g, JComponent F)
	{
		forward(Scale/100.0);
		
		double Width = Scale * getShip().getWidth();
		double Height = Scale * getShip().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(Scale, Scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),at,F);
	}

}
