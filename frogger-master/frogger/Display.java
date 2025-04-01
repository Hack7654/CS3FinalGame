package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Display extends JPanel implements Runnable{
	public static int GRID=50;
	public static int ERRORY=10;
	public static int ERRORX=16;
	public static int WIDTH=600+ERRORX;
	public static int HEIGHT=500-ERRORY;
	public enum STATE{
		MENU,
		GAME,
		HELP
	};
	public static STATE state=STATE.MENU;
	
	private Menu menu;
	private BufferedImage image;
   private BufferedImage fullHeart, deadHeart;
	private Frog frog;
   private Graphics g;
	private Cars cars1[];
	private Cars cars2[];
	private Logs logs1[];
	private Logs logs2[];
	private Logs logs3[];
   // private Timer timer;
	private int deaths=5;
	private int score=0;
   private boolean lostLife=false;

	Display(){
		frog= new Frog(250,HEIGHT-90,50,50);
		menu= new Menu();
		cars1= new Cars[2];
		cars2= new Cars[3];
		logs1= new Logs[2];
		logs2= new Logs[2];
		logs3= new Logs[2];
     //  timer = new Timer();
		
		loadMap();
		initializeGame();
		start();
		
		this.addKeyListener(menu);
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		this.addKeyListener(frog);
		setFocusable(true);
	}
	public void initializeGame(){
		for(int i=0;i<cars1.length;i++){
			cars1[i]= new Cars(0+i*290,HEIGHT-140,100,50,3);
		}
		for(int i=0;i<cars2.length;i++){
			cars2[i]= new Cars(0+i*270,HEIGHT-190,100,50,-2);
		}
		for(int i=0;i<logs1.length;i++){
			logs1[i]= new Logs(0+i*250,HEIGHT-290,170,50,+2);
		}
		for(int i=0;i<logs2.length;i++){
			logs2[i]= new Logs(0+i*300,HEIGHT-340,170,50,-2);
		}
		for(int i=0;i<logs3.length;i++){
		logs3[i]= new Logs(0+i*350,HEIGHT-390,170,50,+3);
		}
	}
	public void didIntersectCar(){
		for(Cars car:cars1){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
            lostLife=true;
				reset();
			}
		}
		for(Cars car:cars2){
			if(frog.getFrog().getBounds().intersects(car.getCar().getBounds())){
            lostLife=true;
				reset();
			}
		}
	}
	public void isInsideLog(){
		Logs logarray[][]=new Logs[][] {logs1,logs2,logs3};

		for (int i = 0; i < logarray.length; i++) {

			if(frog.getFrog().getCenterY()<HEIGHT-240-i*50&&frog.getFrog().getCenterY()>HEIGHT-290-i*50){
				if(!((frog.getFrog().getMinX()>logarray[i][0].getLog().getMinX()&&frog.getFrog().getMaxX()<logarray[i][0].getLog().getMaxX())||
						(frog.getFrog().getMinX()>logarray[i][1].getLog().getMinX()&&frog.getFrog().getMaxX()<logarray[i][1].getLog().getMaxX()))){
               lostLife=true;
					reset();
				}
				else{
					frog.mover(logarray[i][1].getSpeed());
				}
			}
		}
	}
	
	public void loadMap(){
		try {
			image= ImageIO.read(getClass().getResourceAsStream("img/map.png"));
         fullHeart = ImageIO.read(getClass().getResourceAsStream("img/fullHeart.png"));
         deadHeart = ImageIO.read(getClass().getResourceAsStream("img/deadHeart.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void score(){
		if(frog.getFrog().getCenterY()<HEIGHT-390){
			score++;
         lostLife=false;
			reset();
		}
	}
	public void showInfo(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g.setColor(Color.BLACK);
		g2d.setFont(new Font("Arial", Font.PLAIN, 18));
	}
	public void reset() 
   {
      if (lostLife)
      {
          if (deaths > 0) 
          {
              deaths--;
          }
          
          if (deaths == 0) 
          {
              state = STATE.MENU; 
              return;
          }   
      } 
    frog.getFrog().x = 250;
    frog.getFrog().y = HEIGHT - 90;
    repaint();

    // new Timer(1000, e -> {
//         frog.getFrog().x = 250;
//         frog.getFrog().y = HEIGHT - 90;
//         repaint();
//     }).start();
//     repaint();
    
}
	public void AntiAliasing(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
	public void renderGame(Graphics g){
		g.drawImage(image, 0, 0, null);
		for(Logs log: logs1)
			log.render(g);
		for(Logs log: logs2)
			log.render(g);
		for(Logs log: logs3)
			log.render(g);
		frog.render(g);
		for(Cars car: cars1)
			car.render(g);
		for(Cars car: cars2)
			car.render(g);
	}
   public void drawHearts(Graphics g) 
   {
      for (int i = 0; i < 5; i++) 
      {
        if (i < deaths)
        {
            g.drawImage(fullHeart, 10 + (i * 30), 10, 30, 30, null);
        } 
        else 
        {
            g.drawImage(deadHeart, 10 + (i * 30), 10, 30, 30, null);
        }
      }
   }

	@Override
	protected void paintComponent(Graphics g) 
   {
		super.paintComponent(g);
      AntiAliasing(g);
      if (state == STATE.MENU || state == STATE.HELP) 
      {
        menu.render(g);
      } 
      else if (state == STATE.GAME) 
      {
        if (deaths <= 0) 
        {
            deaths = 6; // Reset lives properly when starting a new game
        }
        renderGame(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        isInsideLog();
      }    
    // if (deaths > 0) 
//       {
//          g.setColor(Color.RED);
//          g.setFont(new Font("Arial", Font.PLAIN, 60));
//          g.drawString("YOU DIED " + deaths, 100, 300);
//       }

	}
   

    public void start() {   			
        Thread thread = new Thread(this);
        thread.start();
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}
