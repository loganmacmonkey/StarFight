package types;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

//holds everything about a Laser's functionality
//& the ability to create them.
public class Laser {
	
	//Stores the color of the Laser (Black & White by default).
	private String color = "B&W";
	
	//Stores a Number which is equal to the color of the Laser (0 = Black & White).
	private int colorNum = 0;
	
	//Stores the image for the Laser.
	private BufferedImage laser;
	
	//Stores the X & Y values of the Laser on the screen.
	private double x = 0;
	private double y = 0;
	
	//Stores the rotation of the Laser (0 = up, 90 = right, 180 = down & 270 = left).
	private double rotation = 0.00;
	
	//Stores the amount to scale up each pixel of the image by
	//(if scale = 20, each individual image pixel of the Laser
	//on the screen will take up 20*20 or 400 pixels).
	private double scale = 20.0;
	
	//Creates Laser
	public Laser(String color, int x, int y)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
	}
	//Creates Laser
	public Laser(int colorNum, int x, int y)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
			} catch (IOException e) {}
		this.x = x;
		this.y = y;
	}
	//Creates Laser
	public Laser(String color, int x, int y, int rotation)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
		} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Laser
	public Laser(int colorNum, int x, int y,int rotation)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
			} catch (IOException e) {}
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Laser
	public Laser(String color,double scale, int x, int y, int rotation)
	{
		this.color = color;
		this.colorNum = getColorNum(color);
		try {
		this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
		} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}
	//Creates Laser
	public Laser(int colorNum,double scale, int x, int y,int rotation)
	{
		this.color = getColor(colorNum);
		this.colorNum = colorNum;
		try {
			this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
			} catch (IOException e) {}
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.rotation = rotation;
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
	
	//Changes the color through the color number.
	public void setColorNum(int colorNum) {
		this.colorNum = colorNum;
		this.color = getColor(colorNum);
	}
	
	public BufferedImage getLaser() {
		return laser;
	}

	//finds & sets the image to the Laser
	//as the image named the same color
	public void setLaser() {
		try {
			this.laser = ImageIO.read(new File(getColor()+" Laser.png"));
			} catch (IOException e) {}
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
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
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
	
	//Draws the Laser to the JComponent of your choosing.
	public void drawLaser(Graphics g, JComponent F)
	{
		double Width = scale * getLaser().getWidth();
		double Height = scale * getLaser().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(scale, scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getLaser(),at,F);
	}
	//Draws the Laser any size of JComponent of your choosing.
	public void drawLaser(double Scale,Graphics g, JComponent F)
	{
		double Width = Scale * getLaser().getWidth();
		double Height = Scale * getLaser().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(Scale, Scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getLaser(),at,F);
	}
	//Draws the Laser to the JComponent of your choosing
	//& automatically moves it forward for you before hand.
	public void drawMovingLaser(Graphics g, JComponent F)
	{
		forward(scale/50.0);
		
		double Width = scale * getLaser().getWidth();
		double Height = scale * getLaser().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(scale, scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getLaser(),at,F);
	}
	//Draws the Laser any size of JComponent of your choosing
	//& automatically moves it forward for you before hand.
	public void drawMovingLaser(double Scale,Graphics g, JComponent F)
	{
		forward(Scale/50.0);
		
		double Width = Scale * getLaser().getWidth();
		double Height = Scale * getLaser().getHeight();
		
		AffineTransform at = AffineTransform.getTranslateInstance(getX()-Width/2, getY()-Height/2);
		at.rotate(Math.toRadians(getRotation()), Width / 2, Height / 2);
		at.scale(Scale, Scale);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawImage(getLaser(),at,F);
	}

}
