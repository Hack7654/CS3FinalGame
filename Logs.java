//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class creates the log object which moves inside the water. 
//It sets the log image and makes sure that the speed of the logs move at the appropriate speed for level difficulty.


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Logs {
	private int x,y,w,h,speed;
	private Rectangle log;
	private BufferedImage image;
	
	Logs(int x,int y,int w,int h,int speed){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
		this.speed=speed;
		try {
			image= ImageIO.read(getClass().getResourceAsStream("log.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		log=new Rectangle(x,y,w,h);
	}
	
	public void render(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		//g2d.fill(log);
		g2d.drawImage(image, log.x, log.y,w,h, null);
		move();
		if(isOut()){
			if(log.x>=Display.WIDTH/2)
				log.x=-170;
			else if(log.x<Display.WIDTH/2)
				log.x=Display.WIDTH;
		}
	}
	public boolean isOut(){
		return log.getMinX()>=Display.WIDTH||log.getMaxX()<=0;
	}
	public void move(){
      if (Display.state == Display.STATE.GAME || Display.state == Display.STATE.GAME3  || Display.state == Display.STATE.GAME5 || Display.state == Display.STATE.GAME7) 
		   log.x=log.x+speed;
      if (Display.state == Display.STATE.GAME2 || Display.state == Display.STATE.GAME4   || Display.state == Display.STATE.GAME6 || Display.state == Display.STATE.GAME8)
      {
         if (speed > 0)
            log.x=log.x+speed+1;
         if (speed < 0)
            log.x=log.x+speed-1;
      }

	}
	public Rectangle getLog() {
		return log;
	}
	public void setLog(Rectangle log) {
		this.log = log;
	}
	public int getSpeed() {
		return speed;
	}

}