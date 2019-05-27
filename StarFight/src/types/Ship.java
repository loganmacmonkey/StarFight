package types;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

//holds everything about a Ships functionality
//& the ability to create them.
public class Ship {
	
	//Stores the color of the Ship (Black & White by default).
	private String color = "B&W";
	
	//Stores whether the Ship is moving to the right or not moving to the right.
	private Boolean MovingRight;
	
	//Stores a Number which is equal to the color of the Ship (0 = Black & White).
	private int colorNum = 0;
	
	//Stores the amount of time the ship has been burning for.
	private int BurnedAmount = 0;
	
	//Stores the image for the Ship.
	private BufferedImage ship;
	
	//Stores the X & Y values of the Ship on the screen.
	private double x = 0;
	private double y = 0;
	
	//Stores the rotation of the Ship (0 = up, 90 = right, 180 = down & 270 = left).
	private double rotation = 0.00;
	
	//Stores the amount to scale up each pixel of the image by
	//(if scale = 20, each individual image pixel of the Ship
	//on the screen will take up 20*20 or 400 pixels).
	private double scale = 20.0;
	
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
	public Color getJavaColor()
	{
		if (colorNum == 0){
			return Color.BLACK;
		}else if (colorNum == 1){
			return Color.RED;
		}else if (colorNum == 2) {
			return Color.GREEN;
		}else if (colorNum == 3) {
			return Color.BLUE;
		}else if (colorNum == 4) {
			return new Color(148,0,211);
		}else if (colorNum == 5) {
			return Color.ORANGE;
		}else if (colorNum == 6) {
			return Color.YELLOW;
		}else if (colorNum == 7) {
			return Color.CYAN;
		}else {
			return Color.BLACK;
		}
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
		return (int)x;
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
		return (int)y;
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
		return (int)rotation;
	}
	public double getRotation() {
		return rotation;
	}
	//sets the rotation to a number between 0 to 359 that
	//is equal to the input (Integer Input).
	public void setRotation(int rotation) {
		if(rotation < 0)
		{
			rotation = rotation % 360;
			this.rotation = rotation + 360.00;
		}
		else
		{
		this.rotation = rotation % 360;
		}
	}
	//sets the rotation to a number between 0 to 359 that
	//is equal to the input (Double Input).
	public void setRotation(double rotation) {
		if(rotation < 0)
		{
			rotation = rotation % 360.00;
			this.rotation = rotation + 360.00;
		}
		else
		{
		this.rotation = rotation % 360.00;
		}
	}
	public double getScale()
	{
		return this.scale;
	}
	public void setScale(double scale)
	{
		this.scale = scale;
	}
	public Boolean getMovingRight() {
		return MovingRight;
	}
	public void setMovingRight(Boolean movingRight) {
		MovingRight = movingRight;
	}
	public int getBurnedAmount()
	{
		return BurnedAmount;
	}
	public void setBurnedAmount(int BurnedAmount)
	{
		this.BurnedAmount = BurnedAmount;
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
	
	public Ship clone()
	{
		Ship a = new Ship(this.getColorNum(), this.getScale(), this.getXInt(), this.getYInt(), this.getRotationInt());
		a.setMovingRight(this.getMovingRight());
		return a;
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
		
		AffineTransform atS = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		atS.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		atS.scale(scale, scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),atS,F);
		
		if(getBurnedAmount() > 0)
		{
			AffineTransform atF = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
			atF.rotate(getBurnedAmount(), Width / 2, Height / 2);
			atF.scale(scale, scale);
			
			try {
					if(getBurnedAmount()%40 <= 13)
					{
						g2d.drawImage(ImageIO.read(new File("Fire1.png")),atF,F);
					}
					else if (getBurnedAmount()%40 <= 26)
					{
						g2d.drawImage(ImageIO.read(new File("Fire2.png")),atF,F);
					}
					else if (getBurnedAmount()%40 <= 39)
					{
						g2d.drawImage(ImageIO.read(new File("Fire3.png")),atF,F);
					}
				} catch (IOException e) {}
		}
	}
	
	//Draws the Ship any size of JComponent of your choosing.
	public void drawShip(double Scale,Graphics g, JComponent F)
	{
		double Width = Scale * getShip().getWidth();
		double Height = Scale * getShip().getHeight();
		
		AffineTransform atS = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		atS.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		atS.scale(Scale, Scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getShip(),atS,F);
		
		if(getBurnedAmount() > 0)
		{
			AffineTransform atF = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
			atF.rotate(getBurnedAmount(), Width / 2, Height / 2);
			atF.scale(Scale, Scale);
			
			try {
					if(getBurnedAmount()%40 <= 13)
					{
						g2d.drawImage(ImageIO.read(new File("Fire1.png")),atF,F);
					}
					else if (getBurnedAmount()%40 <= 26)
					{
						g2d.drawImage(ImageIO.read(new File("Fire2.png")),atF,F);
					}
					else if (getBurnedAmount()%40 <= 39)
					{
						g2d.drawImage(ImageIO.read(new File("Fire3.png")),atF,F);
					}
				} catch (IOException e) {System.out.println("oof");}
		}
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
	
	public boolean ContainsPoint(int x, int y)
	{
		int diffx = Math.abs(this.getXInt() - x);
		int diffy = Math.abs(this.getYInt() - y);
		return(diffx <= 12*this.getScale() && diffy <= 12*this.getScale());
	}

}
