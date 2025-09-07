//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class creates the Crocodile object which will show up in the water at random times as replacement for the logs. 
//It includes methods that make sure that the crocodiles only appear on the harder versions of each map.

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

public class Crocodile {
    private int x, y, w, h, speed;
    private Rectangle croc;
    private BufferedImage image;

    Crocodile(int x, int y, int w, int h, int speed) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
        setCrocType();
        croc = new Rectangle(x, y, w, h);
    }
    public void setCrocType()
    {
		Random rand= new Random();
		int temp= rand.nextInt(2);
		if(speed>0){
			if(temp==1)
				changeSprite("croc.png");
			else 
				changeSprite("croc.png");
		}
		else{
			if(temp==1)
				changeSprite("crocL.png");
			else 
				changeSprite("crocL.png");
		}
	}
	
	public void changeSprite(String sprite){
		try {
			image= ImageIO.read(getClass().getResourceAsStream(sprite));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, croc.x, croc.y, w, h, null);
        move();
        if (isOut()) {
            if (croc.x >= Display.WIDTH / 2)
                croc.x = -170;
            else
                croc.x = Display.WIDTH;
        }
    }

    public boolean isOut() {
        return croc.getMinX() >= Display.WIDTH || croc.getMaxX() <= 0;
    }

    public void move() {
        if (Display.state == Display.STATE.GAME || Display.state == Display.STATE.GAME3  || Display.state == Display.STATE.GAME5 || Display.state == Display.STATE.GAME7) 
		   croc.x=croc.x+speed;
        if (Display.state == Display.STATE.GAME2 || Display.state == Display.STATE.GAME4   || Display.state == Display.STATE.GAME6 || Display.state == Display.STATE.GAME8)
        {
         if (speed > 0)
            croc.x=croc.x+speed+1;
         if (speed < 0)
            croc.x=croc.x+speed-1;
        }
    }
    public Rectangle getCroc() {
        return croc;
    }

    public int getSpeed() {
        return speed;
    }
}
