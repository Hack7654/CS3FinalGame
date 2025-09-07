//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class creates the Dog object, which is the player that moves throughout the game. 
//It displays the appropriate image depending on the direction the player is moving, and moves the player the appropriate number of pixels.


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Dog extends JPanel implements KeyListener{
	private int x,y,w,h;
	private Rectangle dog;
	private BufferedImage image;
	private String sprite;
	

	Dog(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		dog=new Rectangle(x,y,w-6,h);
		changeSprite("B.png");
		
	}
	public void render(Graphics g){
		Graphics2D g2d=(Graphics2D)g;
		//g2d.fill(dog);
		g2d.drawImage(image,dog.x,dog.y,null);
	}
	public void mover(int speed){
		dog.x=dog.x+speed;
	}
	public void stopMove(){
		mover(0);
	}
	public int roundTo(int number){
		return number - (number%50);
	}
	
	public void changeSprite(String sprite){
		this.sprite=sprite;
		try {
			image= ImageIO.read(getClass().getResourceAsStream(sprite));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public boolean state()
   {
		return Display.state!=Display.STATE.MENU && Display.state!=Display.STATE.HELP;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(state()){
			int key=e.getKeyCode();
			if (key==KeyEvent.VK_RIGHT) {
				if(dog.getMaxX()+1*Display.GRID<Display.WIDTH){
					dog.x=dog.x+1*Display.GRID;
					dog.setLocation(dog.x, dog.y);			
				}
				else{
					changeSprite("R.png");
				}
            changeSprite("R.png");
			}
			else if(key==KeyEvent.VK_LEFT) {
				if(dog.getMaxX()-1*Display.GRID>0){
					dog.x=dog.x-1*Display.GRID;
					dog.setLocation(dog.x, dog.y);
				}
				else{
					changeSprite("L.png");
				}
            changeSprite("L.png");
			}
			else if(key==KeyEvent.VK_UP) {
				if(dog.getMaxY()-1*Display.GRID>0)
					dog.y=dog.y-1*Display.GRID;
				if(dog.x%50==0)
					dog.setLocation(dog.x, dog.y);
				else{
					dog.setLocation(roundTo(dog.x), dog.y);
				}
				changeSprite("B.png");

			}
			else if(key==KeyEvent.VK_DOWN) 
         {
            if(dog.y + Display.GRID < Display.HEIGHT - 10) // Adjusted condition
               dog.y = dog.y + Display.GRID;
            if(dog.x % 50 == 0)
               dog.setLocation(dog.x, dog.y);
            else
            {
               dog.setLocation(roundTo(dog.x), dog.y);
            }
            changeSprite("F.png");
         }
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public Rectangle getDog() {
		return dog;
	}
	public void setDog(Rectangle dog) {
		this.dog = dog;
	}
	
}