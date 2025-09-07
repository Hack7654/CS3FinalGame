//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class brings the objects together and holds all of the logic that creates the game that we intend to make. 
//The data structures used are Arrays to store the car objects for each level and enum states to switch between levels.
//The class creats separate objects for each level to ensure that when the next level is loaded, there is no overlap of hitboxes.
//The class also creates initialization coordinates for each object in each level, and renders each level separately at the appropriate time.
//The class has methods to check if the player is intersecting a car or inside a log, and acts accordingly for the position in each level using enum states.
//The class has methods which properly reset the player to the initial position on the level they are currently in if they lose a life, as well as display an informational graphic for a set amount of time.


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
import java.awt.Rectangle;
import java.util.ArrayList;


public class Display extends JPanel implements Runnable{
	public static int GRID=50;
	public static int ERRORY=10;
	public static int ERRORX=16;
	public static int WIDTH=600+ERRORX;
	public static int HEIGHT=925-ERRORY;
	public enum STATE{
		MENU,
		GAME,
      GAME2,
      GAME3,
      GAME4,
      GAME5,
      GAME6,
      GAME7,
      GAME8,
      GAME9,
      GAME10,
      VICTORY,
		HELP
	};
	public static STATE state=STATE.MENU;
	
	private Menu menu;
	private BufferedImage death, map1, map2, map3, map4, map5, victory;
   private STATE lastState = STATE.MENU;
   private BufferedImage fullHeart, deadHeart;
	private Dog dog;
   private Graphics g;
   private boolean firstDeath = false;
   
   //Level 1 Objects Declaration
	private ArrayList<Cars> L1cars1;
	private ArrayList<Cars> L1cars2;
   private ArrayList<Cars> L1cars3;
   private ArrayList<Cars> L1cars4;
   private ArrayList<Logs> L1logs1;
   private ArrayList<Logs> L1logs2;
   private ArrayList<Logs> L1logs3;
   private ArrayList<Logs> L1logs4;
   private ArrayList<Logs> L1logs5;
   private ArrayList<Logs> L1logs6;
   private ArrayList<Logs> L1logs7;
   private Crocodile L1crocs1[], L1crocs2[], L1crocs3[];
   //Level 2 Objects Declaration
	private ArrayList<Cars> L2cars1;
	private ArrayList<Cars> L2cars2;
   private ArrayList<Cars> L2cars3;
   private ArrayList<Cars> L2cars4;
   private ArrayList<Logs> L2logs1;
   private ArrayList<Logs> L2logs2;
   private ArrayList<Logs> L2logs3;
   private ArrayList<Logs> L2logs4;
   private ArrayList<Logs> L2logs5;
   private ArrayList<Logs> L2logs6;
   private ArrayList<Logs> L2logs7;
   private Crocodile L2crocs1[], L2crocs2[], L2crocs3[];
   
   //Level 3 Objects Declaration
   private ArrayList<Cars> L3cars1;
	private ArrayList<Cars> L3cars2;
   private ArrayList<Logs> L3logs1;
   private ArrayList<Logs> L3logs2;
   private ArrayList<Logs> L3logs3;
   
   //Level 4 Objects Declaration
   private ArrayList<Cars> L4cars1;
	private ArrayList<Cars> L4cars2;
   private ArrayList<Logs> L4logs1;
   private ArrayList<Logs> L4logs2;
   private ArrayList<Logs> L4logs3;
   private Crocodile L4crocs1[];
   
   //Level 5 Objects Declaration
   private ArrayList<Cars> L5cars1;
   private ArrayList<Cars> L5cars2;
   private ArrayList<Cars> L5cars3;
   private ArrayList<Cars> L5cars4;
   private ArrayList<Logs> L5logs1;
   private ArrayList<Logs> L5logs2;
   private ArrayList<Logs> L5logs3;
   
   //Level 6 Objects Declaration
   private ArrayList<Cars> L6cars1;
   private ArrayList<Cars> L6cars2;
   private ArrayList<Cars> L6cars3;
   private ArrayList<Cars> L6cars4;
   private ArrayList<Logs> L6logs1;
   private ArrayList<Logs> L6logs2;
   private ArrayList<Logs> L6logs3;
   private Crocodile L6crocs1[], L6crocs2[];
   
   //Level 7 Objects Declaration
   private ArrayList<Logs> L7logs1;
   private ArrayList<Logs> L7logs2;
   private ArrayList<Logs> L7logs3;
   private ArrayList<Logs> L7logs4;
   private ArrayList<Logs> L7logs5;
   private ArrayList<Logs> L7logs6;
   private ArrayList<Logs> L7logs7;
   private ArrayList<Logs> L7logs8;
   private ArrayList<Logs> L7logs9;
   private ArrayList<Logs> L7logs10;
   private ArrayList<Logs> L7logs11;
   private ArrayList<Logs> L7logs12;
   private ArrayList<Logs> L7logs13;
   private ArrayList<Logs> L7logs14;
   private ArrayList<Logs> L7logs15;
      
   //Level 8 Objects Declaration
   private ArrayList<Logs> L8logs1;
   private ArrayList<Logs> L8logs2;
   private ArrayList<Logs> L8logs3;
   private ArrayList<Logs> L8logs4;
   private ArrayList<Logs> L8logs5;
   private ArrayList<Logs> L8logs6;
   private ArrayList<Logs> L8logs7;
   private ArrayList<Logs> L8logs8;
   private ArrayList<Logs> L8logs9;
   private ArrayList<Logs> L8logs10;
   private ArrayList<Logs> L8logs11;
   private ArrayList<Logs> L8logs12;
   private ArrayList<Logs> L8logs13;
   private ArrayList<Logs> L8logs14;
   private ArrayList<Logs> L8logs15;
   private Crocodile L8crocs1[], L8crocs2[], L8crocs3[], L8crocs4[], L8crocs5[], L8crocs6[], L8crocs7[], L8crocs8[], L8crocs9[], L8crocs10[], L8crocs11[];  
   //Level 9 Objects Declaration
   private ArrayList<Cars> L9cars1;
   private ArrayList<Cars> L9cars2;
   private ArrayList<Cars> L9cars3;
   private ArrayList<Cars> L9cars4;
   private ArrayList<Cars> L9cars5;
   private ArrayList<Cars> L9cars6;
   private ArrayList<Cars> L9cars7;
   private ArrayList<Cars> L9cars8;
   private ArrayList<Cars> L9cars9;
   private ArrayList<Cars> L9cars10;
   private ArrayList<Cars> L9cars11;
   private ArrayList<Cars> L9cars12;
   private ArrayList<Cars> L9cars13;
   private ArrayList<Cars> L9cars14;
   
   //Level 10 Objects Declaration
   private ArrayList<Cars> L10cars1;
   private ArrayList<Cars> L10cars2;
   private ArrayList<Cars> L10cars3;
   private ArrayList<Cars> L10cars4;
   private ArrayList<Cars> L10cars5;
   private ArrayList<Cars> L10cars6;
   private ArrayList<Cars> L10cars7;
   private ArrayList<Cars> L10cars8;
   private ArrayList<Cars> L10cars9;
   private ArrayList<Cars> L10cars10;
   private ArrayList<Cars> L10cars11;
   private ArrayList<Cars> L10cars12;
   private ArrayList<Cars> L10cars13;
   private ArrayList<Cars> L10cars14;

   // private Timer timer;
	private int deaths=8;
	private int score=0;
   private boolean lostLife=false;
   private boolean isResetting = false;
   private long deathTime = 0;

	Display(){
		dog= new Dog(360,HEIGHT-40,50,50);
		menu= new Menu();
      
      //Level 1 Objects Initialization
		L1cars1 = new ArrayList<>();
		L1cars2 = new ArrayList<>();
      L1cars3 = new ArrayList<>();
      L1cars4 = new ArrayList<>();
		L1logs1 = new ArrayList<>();
		L1logs2 = new ArrayList<>();
		L1logs3 = new ArrayList<>();
      L1logs4 = new ArrayList<>();
      L1logs5 = new ArrayList<>();
      L1logs6 = new ArrayList<>();
      L1logs7 = new ArrayList<>();
      
      //Level 2 Objects Initialization
		L2cars1 = new ArrayList<>();
		L2cars2 = new ArrayList<>();
      L2cars3 = new ArrayList<>();
      L2cars4 = new ArrayList<>();
		L2logs1 = new ArrayList<>();
		L2logs2 = new ArrayList<>();
		L2logs3 = new ArrayList<>();
      L2logs4 = new ArrayList<>();
      L2logs5 = new ArrayList<>();
      L2logs6 = new ArrayList<>();
      L2logs7 = new ArrayList<>();
      
      //Level 3 Objects Initialization
      L3cars1 = new ArrayList<>();
		L3cars2 = new ArrayList<>();
		L3logs1 = new ArrayList<>();
		L3logs2 = new ArrayList<>();
		L3logs3 = new ArrayList<>();
      
      //Level 4 Objects Initialization
      L4cars1 = new ArrayList<>();
		L4cars2 = new ArrayList<>();
		L4logs1 = new ArrayList<>();
		L4logs2 = new ArrayList<>();
		L4logs3 = new ArrayList<>();
      
      //Level 5 Objects Initialization
      L5cars1 = new ArrayList<>();
		L5cars2 = new ArrayList<>();
      L5cars3 = new ArrayList<>();
		L5cars4 = new ArrayList<>();
		L5logs1 = new ArrayList<>();
		L5logs2 = new ArrayList<>();
		L5logs3 = new ArrayList<>();
      
      //Level 6 Objects Initialization
      L6cars1 = new ArrayList<>();
		L6cars2 = new ArrayList<>();
      L6cars3 = new ArrayList<>();
		L6cars4 = new ArrayList<>();
		L6logs1 = new ArrayList<>();
		L6logs2 = new ArrayList<>();
		L6logs3 = new ArrayList<>();
      
      //Level 7 Objects Initialization
      L7logs1 = new ArrayList<>();
		L7logs2 = new ArrayList<>();
		L7logs3 = new ArrayList<>();
      L7logs4 = new ArrayList<>();
		L7logs5 = new ArrayList<>();
		L7logs6 = new ArrayList<>();
      L7logs7 = new ArrayList<>();
		L7logs8 = new ArrayList<>();
		L7logs9 = new ArrayList<>();
      L7logs10 = new ArrayList<>();
		L7logs11 = new ArrayList<>();
		L7logs12 = new ArrayList<>();
      L7logs13 = new ArrayList<>();
		L7logs14 = new ArrayList<>();
		L7logs15 = new ArrayList<>();
      
      //Level 8 Objects Initialization
      L8logs1 = new ArrayList<>();
		L8logs2 = new ArrayList<>();
		L8logs3 = new ArrayList<>();
      L8logs4 = new ArrayList<>();
		L8logs5 = new ArrayList<>();
		L8logs6 = new ArrayList<>();
      L8logs7 = new ArrayList<>();
		L8logs8 = new ArrayList<>();
		L8logs9 = new ArrayList<>();
      L8logs10 = new ArrayList<>();
		L8logs11 = new ArrayList<>();
		L8logs12 = new ArrayList<>();
      L8logs13 = new ArrayList<>();
		L8logs14 = new ArrayList<>();
		L8logs15 = new ArrayList<>();
      
      //Level 9 Objects Initialization
      L9cars1 = new ArrayList<>();
		L9cars2 = new ArrayList<>();
      L9cars3 = new ArrayList<>();
		L9cars4 = new ArrayList<>();
		L9cars5 = new ArrayList<>();
		L9cars6 = new ArrayList<>();
      L9cars7 = new ArrayList<>();
		L9cars8 = new ArrayList<>();
		L9cars9 = new ArrayList<>();
		L9cars10 = new ArrayList<>();
      L9cars11 = new ArrayList<>();
		L9cars12 = new ArrayList<>();
		L9cars13 = new ArrayList<>();
		L9cars14 = new ArrayList<>();
      
      //Level 10 Objects Initialization
      L10cars1 = new ArrayList<>();
		L10cars2 = new ArrayList<>();
      L10cars3 = new ArrayList<>();
		L10cars4 = new ArrayList<>();
		L10cars5 = new ArrayList<>();
		L10cars6 = new ArrayList<>();
      L10cars7 = new ArrayList<>();
		L10cars8 = new ArrayList<>();
		L10cars9 = new ArrayList<>();
		L10cars10 = new ArrayList<>();
      L10cars11 = new ArrayList<>();
		L10cars12 = new ArrayList<>();
		L10cars13 = new ArrayList<>();
		L10cars14 = new ArrayList<>();


      
      
      //timer = new Timer();
		
		loadMap();
		initializeGame();
      if (score == 1)
         initializeGame2();
		start();
		
		this.addKeyListener(menu);
		this.addMouseListener(menu);
		this.addMouseMotionListener(menu);
		this.addKeyListener(dog);
		setFocusable(true);
	}
   public void allocateLevel1Arrays() 
   {
      L1cars1 = new ArrayList<>();
		L1cars2 = new ArrayList<>();
      L1cars3 = new ArrayList<>();
      L1cars4 = new ArrayList<>();
		L1logs1 = new ArrayList<>();
		L1logs2 = new ArrayList<>();
		L1logs3 = new ArrayList<>();
      L1logs4 = new ArrayList<>();
      L1logs5 = new ArrayList<>();
      L1logs6 = new ArrayList<>();
      L1logs7 = new ArrayList<>();
   } 
   public void allocateLevel2Arrays() 
   {
      L2cars1 = new ArrayList<>();
		L2cars2 = new ArrayList<>();
      L2cars3 = new ArrayList<>();
      L2cars4 = new ArrayList<>();
		L2logs1 = new ArrayList<>();
		L2logs2 = new ArrayList<>();
		L2logs3 = new ArrayList<>();
      L2logs4 = new ArrayList<>();
      L2logs5 = new ArrayList<>();
      L2logs6 = new ArrayList<>();
      L2logs7 = new ArrayList<>();
   }
   public void allocateLevel3Arrays() 
   {
      L3cars1 = new ArrayList<>();
		L3cars2 = new ArrayList<>();
		L3logs1 = new ArrayList<>();
		L3logs2 = new ArrayList<>();
		L3logs3 = new ArrayList<>();
   }
   public void allocateLevel4Arrays() 
   {
      L4cars1 = new ArrayList<>();
		L4cars2 = new ArrayList<>();
		L4logs1 = new ArrayList<>();
		L4logs2 = new ArrayList<>();
		L4logs3 = new ArrayList<>();
   }
   public void allocateLevel5Arrays() 
   {
      L5cars1 = new ArrayList<>();
		L5cars2 = new ArrayList<>();
      L5cars3 = new ArrayList<>();
		L5cars4 = new ArrayList<>();
		L5logs1 = new ArrayList<>();
		L5logs2 = new ArrayList<>();
		L5logs3 = new ArrayList<>();
   }
   public void allocateLevel6Arrays() 
   {
      L6cars1 = new ArrayList<>();
		L6cars2 = new ArrayList<>();
      L6cars3 = new ArrayList<>();
		L6cars4 = new ArrayList<>();
		L6logs1 = new ArrayList<>();
		L6logs2 = new ArrayList<>();
		L6logs3 = new ArrayList<>();
   }
   public void allocateLevel7Arrays() 
   {
      L7logs1 = new ArrayList<>();
		L7logs2 = new ArrayList<>();
		L7logs3 = new ArrayList<>();
      L7logs4 = new ArrayList<>();
		L7logs5 = new ArrayList<>();
		L7logs6 = new ArrayList<>();
      L7logs7 = new ArrayList<>();
		L7logs8 = new ArrayList<>();
		L7logs9 = new ArrayList<>();
      L7logs10 = new ArrayList<>();
		L7logs11 = new ArrayList<>();
		L7logs12 = new ArrayList<>();
      L7logs13 = new ArrayList<>();
		L7logs14 = new ArrayList<>();
		L7logs15 = new ArrayList<>();
   }
   public void allocateLevel8Arrays() 
   {
      L8logs1 = new ArrayList<>();
		L8logs2 = new ArrayList<>();
		L8logs3 = new ArrayList<>();
      L8logs4 = new ArrayList<>();
		L8logs5 = new ArrayList<>();
		L8logs6 = new ArrayList<>();
      L8logs7 = new ArrayList<>();
		L8logs8 = new ArrayList<>();
		L8logs9 = new ArrayList<>();
      L8logs10 = new ArrayList<>();
		L8logs11 = new ArrayList<>();
		L8logs12 = new ArrayList<>();
      L8logs13 = new ArrayList<>();
		L8logs14 = new ArrayList<>();
		L8logs15 = new ArrayList<>();
   }
   public void allocateLevel9Arrays() 
   {
      L9cars1 = new ArrayList<>();
		L9cars2 = new ArrayList<>();
      L9cars3 = new ArrayList<>();
		L9cars4 = new ArrayList<>();
		L9cars5 = new ArrayList<>();
		L9cars6 = new ArrayList<>();
      L9cars7 = new ArrayList<>();
		L9cars8 = new ArrayList<>();
		L9cars9 = new ArrayList<>();
		L9cars10 = new ArrayList<>();
      L9cars11 = new ArrayList<>();
		L9cars12 = new ArrayList<>();
		L9cars13 = new ArrayList<>();
		L9cars14 = new ArrayList<>();
   }
   public void allocateLevel10Arrays() 
   {
      L10cars1 = new ArrayList<>();
		L10cars2 = new ArrayList<>();
      L10cars3 = new ArrayList<>();
		L10cars4 = new ArrayList<>();
		L10cars5 = new ArrayList<>();
		L10cars6 = new ArrayList<>();
      L10cars7 = new ArrayList<>();
		L10cars8 = new ArrayList<>();
		L10cars9 = new ArrayList<>();
		L10cars10 = new ArrayList<>();
      L10cars11 = new ArrayList<>();
		L10cars12 = new ArrayList<>();
		L10cars13 = new ArrayList<>();
		L10cars14 = new ArrayList<>();
   } 

   //Load in the objects for the 10 levels
	public void initializeGame(){
		for(int i=0;i<2;i++)
      {
			L1cars1.add(new Cars(0+i*290,HEIGHT-140,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L1cars2.add(new Cars(0+i*270,HEIGHT-190,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L1cars2.add(new Cars(0+i*290,HEIGHT-540,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L1cars2.add(new Cars(0+i*270,HEIGHT-590,100,50,-2));
		}

		for(int i=0;i<3;i++)
      {
			L1logs1.add(new Logs(0+i*250,HEIGHT-290,190,50,+2));
		}
		for(int i=0;i<2;i++)
      {
			L1logs2.add(new Logs(0+i*300,HEIGHT-340,190,50,-2));
		}
		for(int i=0;i<2;i++)
      {
		   L1logs3.add(new Logs(0+i*350,HEIGHT-390,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L1logs4.add(new Logs(0+i*400,HEIGHT-440,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L1logs5.add(new Logs(0+i*250,HEIGHT-690,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L1logs6.add(new Logs(0+i*300,HEIGHT-740,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L1logs7.add(new Logs(0+i*350,HEIGHT-790,190,50,+2));
		}

	}
   
   public void initializeGame2(){
		for(int i=0;i<2;i++)
      {
			L2cars1.add(new Cars(0+i*290,HEIGHT-140,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L2cars2.add(new Cars(0+i*270,HEIGHT-190,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L2cars3.add(new Cars(0+i*290,HEIGHT-540,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L2cars4.add(new Cars(0+i*270,HEIGHT-590,100,50,-2));
		}

		for(int i=0;i<2;i++)
      {
			L2logs1.add(new Logs(0+i*250,HEIGHT-290,190,50,+2));
		}
		for(int i=0;i<2;i++)
      {
			L2logs2.add(new Logs(0+i*300,HEIGHT-340,190,50,-2));
		}
		for(int i=0;i<1;i++)
      {
		   L2logs3.add(new Logs(0+i*350,HEIGHT-390,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L2logs4.add(new Logs(0+i*400,HEIGHT-440,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L2logs5.add(new Logs(0+i*250,HEIGHT-690,190,50,+3));
		}
      for(int i=0;i<1;i++)
      {
		   L2logs6.add(new Logs(0+i*300,HEIGHT-740,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L2logs7.add(new Logs(0+i*350,HEIGHT-790,190,50,+2));
		}
      L2crocs1 = new Crocodile[]
      {
         new Crocodile(500, HEIGHT - 290, 190, 50, +2)
         
      };
      L2crocs2 = new Crocodile[]
      {
         new Crocodile(350, HEIGHT - 390, 190, 50, +3)
         
      };
      L2crocs3 = new Crocodile[]
      {
         new Crocodile(350, HEIGHT - 740, 190, 50, -2)
      };
	}

   
   public void initializeGame3(){
		for(int i=0;i<2;i++)
      {
			L3cars1.add(new Cars(0+i*290,HEIGHT-140,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L3cars2.add(new Cars(0+i*270,HEIGHT-190,100,50,-2));
		}
      
      for(int i=0;i<2;i++)
      {
		   L3logs1.add(new Logs(0+i*250,HEIGHT-690,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L3logs2.add(new Logs(0+i*300,HEIGHT-740,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L3logs3.add(new Logs(0+i*350,HEIGHT-790,190,50,+2));
		}  
   }
   
   public void initializeGame4(){
		for(int i=0;i<2;i++)
      {
			L4cars1.add(new Cars(0+i*290,HEIGHT-140,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L4cars2.add(new Cars(0+i*270,HEIGHT-190,100,50,-2));
		}
      
      for(int i=0;i<2;i++)
      {
		   L4logs1.add(new Logs(0+i*250,HEIGHT-690,190,50,+3));
		}
      for(int i=0;i<1;i++)
      {
		   L4logs2.add(new Logs(0+i*300,HEIGHT-740,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L4logs3.add(new Logs(0+i*350,HEIGHT-790,190,50,+2));
		}
      L4crocs1 = new Crocodile[]
      {
         new Crocodile(500, HEIGHT - 740, 190, 50, -2)
         
      }; 
   }
   
   public void initializeGame5(){
		for(int i=0;i<2;i++)
      {
			L5cars1.add(new Cars(0+i*290,275,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L5cars2.add(new Cars(0+i*270,225,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L5cars3.add(new Cars(0+i*270,175,100,50,3));
		}
      for(int i=0;i<3;i++)
      {
			L5cars4.add(new Cars(0+i*270,125,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L5logs1.add(new Logs(0+i*250,425,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L5logs2.add(new Logs(0+i*300,475,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L5logs3.add(new Logs(0+i*350,525,190,50,+2));
		}  
   }
   
   public void initializeGame6(){
		for(int i=0;i<2;i++)
      {
			L6cars1.add(new Cars(0+i*290,275,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L6cars2.add(new Cars(0+i*270,225,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L6cars3.add(new Cars(0+i*270,175,100,50,3));
		}
      for(int i=0;i<3;i++)
      {
			L6cars4.add(new Cars(0+i*270,125,100,50,-2));
		}
      for(int i=0;i<1;i++)
      {
		   L6logs1.add(new Logs(0+i*250,425,190,50,+3));
		}
      for(int i=0;i<2;i++)
      {
		   L6logs2.add(new Logs(0+i*300,475,190,50,-2));
		}
      for(int i=0;i<1;i++)
      {
		   L6logs3.add(new Logs(0+i*350,525,190,50,+2));
		}
      L6crocs1 = new Crocodile[]
      {
         new Crocodile(500, 425, 190, 50, +3)
         
      };
      L6crocs2 = new Crocodile[]
      {
         new Crocodile(350, 525, 190, 50, +2)
         
      };  
   }

   public void initializeGame7(){
		for(int i=0;i<2;i++)
      {
		   L7logs1.add(new Logs(0+i*250,115,190,50,+2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs2.add(new Logs(0+i*300,165,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs3.add(new Logs(0+i*350,215,190,50,+2));
		}  
      for(int i=0;i<2;i++)
      {
		   L7logs4.add(new Logs(0+i*250,265,190,50,-2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs5.add(new Logs(0+i*300,315,190,50,+2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs6.add(new Logs(0+i*350,365,190,50,-2));
		}  
      for(int i=0;i<2;i++)
      {
		   L7logs7.add(new Logs(0+i*250,415,190,50,+2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs8.add(new Logs(0+i*300,465,190,50,-3));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs9.add(new Logs(0+i*350,515,190,50,+4));
		}  
      for(int i=0;i<2;i++)
      {
		   L7logs10.add(new Logs(0+i*250,565,190,50,-3));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs11.add(new Logs(0+i*300,615,190,50,+2));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs12.add(new Logs(0+i*350,665,190,50,-3));
		} 
      for(int i=0;i<2;i++)
      {
		   L7logs13.add(new Logs(0+i*250,715,190,50,+4));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs14.add(new Logs(0+i*300,765,190,50,-3));
		}
      for(int i=0;i<2;i++)
      {
		   L7logs15.add(new Logs(0+i*350,815,190,50,+2));
		}  
   }
   
   public void initializeGame8(){
		for(int i=0;i<2;i++)
      {
		   L8logs1.add(new Logs(0+i*250,115,190,50,+2));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs2.add(new Logs(0+i*300,165,190,50,-2));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs3.add(new Logs(0+i*350,215,190,50,+2));
		}  
      for(int i=0;i<2;i++)
      {
		   L8logs4.add(new Logs(0+i*250,265,190,50,-2));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs5.add(new Logs(0+i*300,315,190,50,+2));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs6.add(new Logs(0+i*350,365,190,50,-2));
		}  
      for(int i=0;i<1;i++)
      {
		   L8logs7.add(new Logs(0+i*250,415,190,50,+2));
		}
      for(int i=0;i<2;i++)
      {
		   L8logs8.add(new Logs(0+i*300,465,190,50,-3));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs9.add(new Logs(0+i*350,515,190,50,+4));
		}  
      for(int i=0;i<1;i++)
      {
		   L8logs10.add(new Logs(0+i*250,565,190,50,-3));
		}
      for(int i=0;i<2;i++)
      {
		   L8logs11.add(new Logs(0+i*300,615,190,50,+2));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs12.add(new Logs(0+i*350,665,190,50,-3));
		} 
      for(int i=0;i<1;i++)
      {
		   L8logs13.add(new Logs(0+i*250,715,190,50,+4));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs14.add(new Logs(0+i*300,765,190,50,-3));
		}
      for(int i=0;i<1;i++)
      {
		   L8logs15.add(new Logs(0+i*350,815,190,50,+2));
		}  
      L8crocs1 = new Crocodile[]
      {
         new Crocodile(500, 165, 190, 50, -2)
         
      };
      L8crocs2 = new Crocodile[]
      {
         new Crocodile(350, 215, 190, 50, +2)
         
      };
      L8crocs3 = new Crocodile[]
      {
         new Crocodile(500, 315, 190, 50, +2)
         
      };
      L8crocs4 = new Crocodile[]
      {
         new Crocodile(350, 365, 190, 50, -2)
         
      };
      L8crocs5 = new Crocodile[]
      {
         new Crocodile(500, 415, 190, 50, +2)
         
      };
      L8crocs6 = new Crocodile[]
      {
         new Crocodile(350, 515, 190, 50, +4)
         
      };  
      L8crocs7 = new Crocodile[]
      {
         new Crocodile(500, 565, 190, 50, -3)
         
      };
      L8crocs8 = new Crocodile[]
      {
         new Crocodile(350, 665, 190, 50, -3)
         
      };
      L8crocs9 = new Crocodile[]
      {
         new Crocodile(500, 715, 190, 50, +4)
         
      };
      L8crocs10 = new Crocodile[]
      {
         new Crocodile(350, 765, 190, 50, -3)
         
      };
      L8crocs11 = new Crocodile[]
      {
         new Crocodile(350, 815, 190, 50, +2)
         
      };

   }

   public void initializeGame9(){
		for(int i=0;i<2;i++)
      {
			L9cars1.add(new Cars(0+i*290,775,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L9cars2.add(new Cars(0+i*270,725,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L9cars3.add(new Cars(0+i*270,675,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L9cars4.add(new Cars(0+i*270,625,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L9cars5.add(new Cars(0+i*290,575,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L9cars6.add(new Cars(0+i*270,525,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L9cars7.add(new Cars(0+i*270,475,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L9cars8.add(new Cars(0+i*270,425,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L9cars9.add(new Cars(0+i*290,375,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L9cars10.add(new Cars(0+i*270,325,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L9cars11.add(new Cars(0+i*270,275,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L9cars12.add(new Cars(0+i*270,225,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L9cars13.add(new Cars(0+i*290,175,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L9cars14.add(new Cars(0+i*270,125,100,50,-2));
		}
   }
   
   public void initializeGame10(){
		for(int i=0;i<2;i++)
      {
			L10cars1.add(new Cars(0+i*290,775,100,50,3));
		}
		for(int i=0;i<3;i++)
      {
			L10cars2.add(new Cars(0+i*270,725,100,50,-2));
		}
      for(int i=0;i<2;i++)
      {
			L10cars3.add(new Cars(0+i*270,675,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L10cars4.add(new Cars(0+i*270,625,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L10cars5.add(new Cars(0+i*290,575,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L10cars6.add(new Cars(0+i*270,525,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L10cars7.add(new Cars(0+i*270,475,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L10cars8.add(new Cars(0+i*270,425,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L10cars9.add(new Cars(0+i*290,375,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L10cars10.add(new Cars(0+i*270,325,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L10cars11.add(new Cars(0+i*270,275,100,50,3));
		}
      for(int i=0;i<2;i++)
      {
			L10cars12.add(new Cars(0+i*270,225,100,50,-2));
		}
      for(int i=0;i<3;i++)
      {
			L10cars13.add(new Cars(0+i*290,175,100,50,3));
		}
		for(int i=0;i<2;i++)
      {
			L10cars14.add(new Cars(0+i*270,125,100,50,-2));
		}
   }



	public void didIntersectCar() 
   {
       if (state == STATE.GAME) {
           for (Cars car : L1cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L1cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L1cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L1cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       } 
       
       else if (state == STATE.GAME2) {
           for (Cars car : L2cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L2cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L2cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L2cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       } 

       
       else if (state == STATE.GAME3) {
           for (Cars car : L3cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L3cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       }
       
       else if (state == STATE.GAME4) {
           for (Cars car : L4cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L4cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       }
       
       else if (state == STATE.GAME5) {
           for (Cars car : L5cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L5cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L5cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L5cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       }
       
       else if (state == STATE.GAME6) {
           for (Cars car : L6cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L6cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L6cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L6cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }

       }
       
       else if (state == STATE.GAME9) {
           for (Cars car : L9cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars5) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars6) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars7) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars8) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars9) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars10) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars11) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars12) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars13) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L9cars14) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       }
       
       else if (state == STATE.GAME10) {
           for (Cars car : L10cars1) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars2) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars3) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars4) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars5) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars6) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars7) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars8) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars9) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars10) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars11) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars12) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars13) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
           for (Cars car : L10cars14) {
               if (dog.getDog().getBounds().intersects(car.getCar().getBounds())) {
                   died();
                   reset();
               }
           }
       }


   }
   public void didIntersectCrocodile() 
   {
      Crocodile[][] crocArray = null;
      if (state == STATE.GAME) 
      {
         crocArray = new Crocodile[][] { L1crocs1, L1crocs2 }; // extend if needed
      }
      else if (state == STATE.GAME2) 
      {
         crocArray = new Crocodile[][] { L2crocs1, L2crocs2 }; // extend if needed
      }
      else if (state == STATE.GAME4) 
      {
         crocArray = new Crocodile[][] { L4crocs1 }; // extend if needed
      }
      else if (state == STATE.GAME6) 
      {
         crocArray = new Crocodile[][] { L6crocs1, L6crocs2 }; // extend if needed
      }
      else if (state == STATE.GAME8) 
      {
         crocArray = new Crocodile[][] { L8crocs1, L8crocs2, L8crocs3, L8crocs4, L8crocs4, L8crocs5, L8crocs6, L8crocs7, L8crocs8, L8crocs9, L8crocs10, L8crocs11 }; // extend if needed
      }



      for (Crocodile[] crocGroup : crocArray) {
          for (Crocodile croc : crocGroup) {
              if (dog.getDog().intersects(croc.getCroc())) {
                  lostLife = true;
                  reset();
                  return;
              }
          }
      }
   }


   public void isInsideLog() 
   {
       ArrayList<ArrayList<Logs>> logarray = new ArrayList<>();
       if (state == STATE.GAME) 
       {
           logarray.add(L1logs1);
           logarray.add(L1logs2);
           logarray.add(L1logs3);
           logarray.add(L1logs4);
           logarray.add(L1logs5);
           logarray.add(L1logs6);
           logarray.add(L1logs7);
       } 
       else if (state == STATE.GAME2) 
       {
           logarray.add(L2logs1);
           logarray.add(L2logs2);
           logarray.add(L2logs3);
           logarray.add(L2logs4);
           logarray.add(L2logs5);
           logarray.add(L2logs6);
           logarray.add(L2logs7);
       } 
       else if (state == STATE.GAME3)
       {
           logarray.add(L3logs1);
           logarray.add(L3logs2);
           logarray.add(L3logs3);
       }
       else if (state == STATE.GAME4)
       {
           logarray.add(L4logs1);
           logarray.add(L4logs2);
           logarray.add(L4logs3);
       }
       else if (state == STATE.GAME5)
       {
           logarray.add(L5logs1);
           logarray.add(L5logs2);
           logarray.add(L5logs3);
       }
       else if (state == STATE.GAME6)
       {
           logarray.add(L6logs1);
           logarray.add(L6logs2);
           logarray.add(L6logs3);
       }
       else if (state == STATE.GAME7)
       {
           logarray.add(L7logs1);
           logarray.add(L7logs2);
           logarray.add(L7logs3);
           logarray.add(L7logs4);
           logarray.add(L7logs5);
           logarray.add(L7logs6);
           logarray.add(L7logs7);
           logarray.add(L7logs8);
           logarray.add(L7logs9);
           logarray.add(L7logs10);
           logarray.add(L7logs11);
           logarray.add(L7logs12);
           logarray.add(L7logs13);
           logarray.add(L7logs14);
           logarray.add(L7logs15);
       }
       else if (state == STATE.GAME8)
       {
           logarray.add(L7logs1);
           logarray.add(L7logs2);
           logarray.add(L7logs3);
           logarray.add(L7logs4);
           logarray.add(L7logs5);
           logarray.add(L7logs6);
           logarray.add(L7logs7);
           logarray.add(L7logs8);
           logarray.add(L7logs9);
           logarray.add(L7logs10);
           logarray.add(L7logs11);
           logarray.add(L7logs12);
           logarray.add(L7logs13);
           logarray.add(L7logs14);
           logarray.add(L7logs15);
       }
       else
       {
         return;
       }
   
       for (int i = 0; i < logarray.size(); i++) {
           ArrayList<Logs> logsRow = logarray.get(i);
           double dogY = dog.getDog().getCenterY();
           double minY, maxY;
           minY = 0.0;
           maxY = 0.0;
   
           if (state == STATE.GAME || state == STATE.GAME2) {
               // Level 1: original minY and maxY settings
               if (i < 4) {
                 minY = HEIGHT - 290 - (i * 50);
                 maxY = HEIGHT - 240 - (i * 50);
             } 
             else {
                 if (i == 4) {
                     minY = 225;
                     maxY = 275;
                 } else if (i == 5) {
                     minY = 175;
                     maxY = 225;
                 } else {
                     minY = 125;
                     maxY = 175;
                 } 
               }
           } 
           else if (state == STATE.GAME3 || state == STATE.GAME4) 
           {
              // Level 3: ONLY top river (one river!)
              if (i == 0) {
                  minY = 225;
                  maxY = 275;
              } else if (i == 1) {
                  minY = 175;
                  maxY = 225;
              } else if (i == 2) {
                  minY = 125;
                  maxY = 175;
              }
          }
          else if (state == STATE.GAME5 || state == STATE.GAME6) 
           {
              if (i == 0) {
                  minY = 425;
                  maxY = 475;
              } else if (i == 1) {
                  minY = 475;
                  maxY = 525;
              } else if (i == 2) {
                  minY = 525;
                  maxY = 575;
              }

          }
          else if (state == STATE.GAME7 || state == STATE.GAME8) 
           {
              if (i == 0) {
                  minY = 115;
                  maxY = 165;
              } 
              else if (i == 1) {
                  minY = 165;
                  maxY = 215;
              } 
              else if (i == 2) {
                  minY = 215;
                  maxY = 265;
              }
              else if (i == 3) {
                  minY = 265;
                  maxY = 315;
              } 
              else if (i == 4) {
                  minY = 315;
                  maxY = 365;
              } 
              else if (i == 5) {
                  minY = 365;
                  maxY = 415;
              }
              else if (i == 6) {
                  minY = 415;
                  maxY = 465;
              } 
              else if (i == 7) {
                  minY = 465;
                  maxY = 515;
              } 
              else if (i == 8) {
                  minY = 515;
                  maxY = 565;
              }
              else if (i == 9) {
                  minY = 565;
                  maxY = 615;
              } 
              else if (i == 10) {
                  minY = 615;
                  maxY = 665;
              } 
              else if (i == 11) {
                  minY = 665;
                  maxY = 715;
              }
              else if (i == 12) {
                  minY = 715;
                  maxY = 765;
              } 
              else if (i == 13) {
                  minY = 765;
                  maxY = 815;
              } 
              else if (i == 14) {
                  minY = 815;
                  maxY = 865;
              }
          }

             
               else { 
               // Level 2: simpler pattern (adjust to your map2 layout if needed)
               minY = HEIGHT - 690 - (i * 50);
               maxY = HEIGHT - 640 - (i * 50);
           }
   
           if (dogY < maxY && dogY > minY) {
               boolean onLog = false;
               for (Logs log : logsRow) {
                   if (dog.getDog().getMinX() > log.getLog().getMinX() &&
                       dog.getDog().getMaxX() < log.getLog().getMaxX()) {
                       onLog = true;
                       if (state == STATE.GAME || state == STATE.GAME3 || state == STATE.GAME5 || state == STATE.GAME7){
                        dog.mover(log.getSpeed());
                       }
                       else if(state == STATE.GAME2 || state == STATE.GAME4 || state == STATE.GAME6 || state == STATE.GAME8){
                        if (log.getSpeed() > 0)
                           dog.mover(log.getSpeed() + 1);
                        if (log.getSpeed() < 0)
                           dog.mover(log.getSpeed() - 1);
                       }
                       break;
                   }
               }
   
               if (!onLog) {
                   died();
                   reset();
               }
           }
       }
   }

   public void didIntersectObstacle()
   {
      //Map 2: Levels 3 & 4
      if (state == STATE.GAME3 || state == STATE.GAME4)
      {
         //Red obstacle on the bottom left
         if (dog.getDog().getCenterX() < 263 && dog.getDog().getCenterY() > 575 && dog.getDog().getCenterY() < 675)
         {
            died();
            reset();
         }
         
         //Red obstacle on the bottom right
         if (dog.getDog().getCenterX() > 345 && dog.getDog().getCenterY() > 575 && dog.getDog().getCenterY() < 675)
         {
            died();
            reset();
         }
         
         //Left water
         if (dog.getDog().getCenterX() < 395 && dog.getDog().getCenterY() > 375 && dog.getDog().getCenterY() < 475)
         {
            died();
            reset();
         }
         
         //Right water
         if (dog.getDog().getCenterX() > 530 && dog.getDog().getCenterY() > 375 && dog.getDog().getCenterY() < 475)
         {
            died();
            reset();
         }
      }
     
      //Map 3: Levels 5 & 6
      if (state == STATE.GAME5 || state == STATE.GAME6)
      {
         //Red obstacle on the bottom left
         if (dog.getDog().getCenterX() < 477 && dog.getDog().getCenterY() > 725 && dog.getDog().getCenterY() < 825)
         {
            died();
            reset();
         }
         
         //Red obstacle on the bottom right
         if (dog.getDog().getCenterX() > 569 && dog.getDog().getCenterY() > 725 && dog.getDog().getCenterY() < 825)
         {
            died();
            reset();
         }
         
      }
   }   
   public void loadMap(){
		try {
         death = ImageIO.read(getClass().getResourceAsStream("death.png"));
			map1= ImageIO.read(getClass().getResourceAsStream("Map.png"));
         map2= ImageIO.read(getClass().getResourceAsStream("Map2.png"));
         map3= ImageIO.read(getClass().getResourceAsStream("Map3.png"));
         map4= ImageIO.read(getClass().getResourceAsStream("Map4.png"));
         map5= ImageIO.read(getClass().getResourceAsStream("Map5.png"));
         victory= ImageIO.read(getClass().getResourceAsStream("victory.png"));


         fullHeart = ImageIO.read(getClass().getResourceAsStream("fullHeart.png"));
         deadHeart = ImageIO.read(getClass().getResourceAsStream("deadHeart.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void score(){
		if(dog.getDog().getCenterY()<HEIGHT-865){
			score++;
         lostLife=false;
         if (state == STATE.GAME){
            state = STATE.GAME2;
            reset();
            initializeGame2();
         }
         else if (state == STATE.GAME2){
            state = STATE.GAME3;
            reset();
            initializeGame3();
         }
         
         else if (state == STATE.GAME3){
            state = STATE.GAME4;
            reset();
            initializeGame4();
         }
         
         else if (state == STATE.GAME4){
            state = STATE.GAME5;
            reset();
            initializeGame5();
         }
         
         else if (state == STATE.GAME5){
            state = STATE.GAME6;
            reset();
            initializeGame6();
         }
         
         else if (state == STATE.GAME6){
            state = STATE.GAME7;
            reset();
            initializeGame7();
         }
         
         else if (state == STATE.GAME7){
            state = STATE.GAME8;
            reset();
            initializeGame8();
         }
         
         else if (state == STATE.GAME8){
            state = STATE.GAME9;
            reset();
            initializeGame9();
         }
         
         else if (state == STATE.GAME9){
            state = STATE.GAME10;
            reset();
            initializeGame10();
         }
         
         else if (state == STATE.GAME10){
            state = STATE.VICTORY;
            reset();
         }







		}
	}
   
   public void died()
   {
      lostLife = true;
      deathTime = System.currentTimeMillis();    
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
         firstDeath = true;
         return;
        }
        isResetting = true;
        // Delay for half a second so intersect doesn't trigger again instantly
        new Timer(500, e -> {
            isResetting = false;
        }).start();
    }

    dog.getDog().x = 360;
    dog.getDog().y = HEIGHT - 40;
    repaint();
   }
   
	public void AntiAliasing(Graphics g){
		Graphics2D g2d= (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}
   
   
   
   
 //Render Game Methods for the 10 Levels
	public void renderGame(Graphics g){
		g.drawImage(map1, 0, 0, null);
		for(Logs log: L1logs1)
			log.render(g);
		for(Logs log: L1logs2)
			log.render(g);
		for(Logs log: L1logs3)
			log.render(g);
      for(Logs log: L1logs4)
			log.render(g);
      for(Logs log: L1logs5)
			log.render(g);
      for(Logs log: L1logs6)
			log.render(g);
      for(Logs log: L1logs7)
			log.render(g);
		dog.render(g);
		for(Cars car: L1cars1)
			car.render(g);
		for(Cars car: L1cars2)
			car.render(g);
      for(Cars car: L1cars3)
			car.render(g);
      for(Cars car: L1cars4)
			car.render(g);
	}
   
   public void renderGame2(Graphics g)
   {
      L1cars1 = null;
      L1cars2 = null;
      L1cars3 = null;
      L1cars4 = null;
      L1logs1 = null;
      L1logs2 = null;
      L1logs3 = null;
      L1logs4 = null;
      L1logs5 = null;
      L1logs6 = null;
      L1logs7 = null;
		g.drawImage(map1, 0, 0, null);
 
      for(Logs log: L2logs1)
			log.render(g);
		for(Logs log: L2logs2)
			log.render(g);
		for(Logs log: L2logs3)
			log.render(g);
      for(Logs log: L2logs4)
			log.render(g);
      for(Logs log: L2logs5)
			log.render(g);
      for(Logs log: L2logs6)
			log.render(g);
      for(Logs log: L2logs7)
			log.render(g);
      for (Crocodile croc : L2crocs1) 
         croc.render(g);
      for (Crocodile croc : L2crocs2) 
         croc.render(g);
      for (Crocodile croc : L2crocs3) 
         croc.render(g);
		dog.render(g);
		for(Cars car: L2cars1)
			car.render(g);
		for(Cars car: L2cars2)
			car.render(g);
      for(Cars car: L2cars3)
			car.render(g);
      for(Cars car: L2cars4)
			car.render(g);
	}
   
   public void renderGame3(Graphics g)
   {
      L2cars1 = null;
      L2cars2 = null;
      L2cars3 = null;
      L2cars4 = null;
      L2logs1 = null;
      L2logs2 = null;
      L2logs3 = null;
      L2logs4 = null;
      L2logs5 = null;
      L2logs6 = null;
      L2logs7 = null;
      L2crocs1 = null;
      L2crocs2 = null;
      L2crocs3 = null;
		g.drawImage(map2, 0, 0, null);
 
		for(Logs log: L3logs1)
			log.render(g);
		for(Logs log: L3logs2)
			log.render(g);
		for(Logs log: L3logs3)
			log.render(g);
      dog.render(g);
   	for(Cars car: L3cars1)
			car.render(g);
		for(Cars car: L3cars2)
			car.render(g);
	}
   
   public void renderGame4(Graphics g)
   {
      L3cars1 = null;
      L3cars2 = null;
      L3logs1 = null;
      L3logs2 = null;
      L3logs3 = null;
		g.drawImage(map2, 0, 0, null);
 
		for(Logs log: L4logs1)
			log.render(g);
		for(Logs log: L4logs2)
			log.render(g);
		for(Logs log: L4logs3)
			log.render(g);
      for (Crocodile croc : L4crocs1) 
         croc.render(g);
      dog.render(g);
   	for(Cars car: L4cars1)
			car.render(g);
		for(Cars car: L4cars2)
			car.render(g);
	}
   
   public void renderGame5(Graphics g)
   {
      L4cars1 = null;
      L4cars2 = null;
      L4logs1 = null;
      L4logs2 = null;
      L4logs3 = null;
      L4crocs1 = null;
		g.drawImage(map3, 0, 0, null);
 
		for(Logs log: L5logs1)
			log.render(g);
		for(Logs log: L5logs2)
			log.render(g);
		for(Logs log: L5logs3)
			log.render(g);
      dog.render(g);
   	for(Cars car: L5cars1)
			car.render(g);
		for(Cars car: L5cars2)
			car.render(g);
      for(Cars car: L5cars3)
			car.render(g);
      for(Cars car: L5cars4)
			car.render(g);
	}
   
   public void renderGame6(Graphics g)
   {
      L5cars1 = null;
      L5cars2 = null;
      L5cars3 = null;
      L5cars4 = null;
      L5logs1 = null;
      L5logs2 = null;
      L5logs3 = null;
		g.drawImage(map3, 0, 0, null);
 
		for(Logs log: L6logs1)
			log.render(g);
		for(Logs log: L6logs2)
			log.render(g);
		for(Logs log: L6logs3)
			log.render(g);
      for (Crocodile croc : L6crocs1) 
         croc.render(g);
      for (Crocodile croc : L6crocs2) 
         croc.render(g);
      dog.render(g);
   	for(Cars car: L6cars1)
			car.render(g);
		for(Cars car: L6cars2)
			car.render(g);
      for(Cars car: L6cars3)
			car.render(g);
      for(Cars car: L6cars4)
			car.render(g);
	}
   
   public void renderGame7(Graphics g)
   {
      L6cars1 = null;
      L6cars2 = null;
      L6cars3 = null;
      L6cars4 = null;
      L6logs1 = null;
      L6logs2 = null;
      L6logs3 = null;
      L6crocs1 = null;
      L6crocs2 = null;
		g.drawImage(map4, 0, 0, null);
 
		for(Logs log: L7logs1)
			log.render(g);
		for(Logs log: L7logs2)
			log.render(g);
		for(Logs log: L7logs3)
			log.render(g);
      for(Logs log: L7logs4)
			log.render(g);
		for(Logs log: L7logs5)
			log.render(g);
		for(Logs log: L7logs6)
			log.render(g);
      for(Logs log: L7logs7)
			log.render(g);
		for(Logs log: L7logs8)
			log.render(g);
		for(Logs log: L7logs9)
			log.render(g);
      for(Logs log: L7logs10)
			log.render(g);
		for(Logs log: L7logs11)
			log.render(g);
		for(Logs log: L7logs12)
			log.render(g);
      for(Logs log: L7logs13)
			log.render(g);
		for(Logs log: L7logs14)
			log.render(g);
		for(Logs log: L7logs15)
			log.render(g);
         dog.render(g);
   }
   
   public void renderGame8(Graphics g)
   {
      L7logs1 = null;
      L7logs2 = null;
      L7logs3 = null;
      L7logs4 = null;
      L7logs5 = null;
      L7logs6 = null;
      L7logs7 = null;
      L7logs8 = null;
      L7logs9 = null;
      L7logs10 = null;
      L7logs11 = null;
      L7logs12 = null;
      L7logs13 = null;
      L7logs14 = null;
      L7logs15 = null;
		g.drawImage(map4, 0, 0, null);
 
		for(Logs log: L8logs1)
			log.render(g);
		for(Logs log: L8logs2)
			log.render(g);
		for(Logs log: L8logs3)
			log.render(g);
      for(Logs log: L8logs4)
			log.render(g);
		for(Logs log: L8logs5)
			log.render(g);
		for(Logs log: L8logs6)
			log.render(g);
      for(Logs log: L8logs7)
			log.render(g);
		for(Logs log: L8logs8)
			log.render(g);
		for(Logs log: L8logs9)
			log.render(g);
      for(Logs log: L8logs10)
			log.render(g);
		for(Logs log: L8logs11)
			log.render(g);
		for(Logs log: L8logs12)
			log.render(g);
      for(Logs log: L8logs13)
			log.render(g);
		for(Logs log: L8logs14)
			log.render(g);
		for(Logs log: L8logs15)
			log.render(g);
      for (Crocodile croc : L8crocs1) 
         croc.render(g);
      for (Crocodile croc : L8crocs2) 
         croc.render(g);
      for (Crocodile croc : L8crocs3) 
         croc.render(g);
      for (Crocodile croc : L8crocs4) 
         croc.render(g);
      for (Crocodile croc : L8crocs5) 
         croc.render(g);
      for (Crocodile croc : L8crocs6) 
         croc.render(g);
      for (Crocodile croc : L8crocs7) 
         croc.render(g);
      for (Crocodile croc : L8crocs9) 
         croc.render(g);
      for (Crocodile croc : L8crocs10) 
         croc.render(g);
      for (Crocodile croc : L8crocs11) 
         croc.render(g);
      dog.render(g);
   }
   
   public void renderGame9(Graphics g)
   {
      L8logs1 = null;
      L8logs2 = null;
      L8logs3 = null;
      L8logs4 = null;
      L8logs5 = null;
      L8logs6 = null;
      L8logs7 = null;
      L8logs8 = null;
      L8logs9 = null;
      L8logs10 = null;
      L8logs11 = null;
      L8logs12 = null;
      L8logs13 = null;
      L8logs14 = null;
      L8logs15 = null;  
      L8crocs1 = null;  
      L8crocs2 = null;  
      L8crocs3 = null;  
      L8crocs4 = null;  
      L8crocs5 = null;  
      L8crocs6 = null;  
      L8crocs7 = null;  
      L8crocs8 = null;  
      L8crocs9 = null;  
      L8crocs10 = null;  
      L8crocs11 = null;    
		g.drawImage(map5, 0, 0, null);
 
		dog.render(g);
      for(Cars car: L9cars1)
			car.render(g);
		for(Cars car: L9cars2)
			car.render(g);
      for(Cars car: L9cars3)
			car.render(g);
      for(Cars car: L9cars4)
			car.render(g);
      for(Cars car: L9cars5)
			car.render(g);
		for(Cars car: L9cars6)
			car.render(g);
      for(Cars car: L9cars7)
			car.render(g);
      for(Cars car: L9cars8)
			car.render(g);
      for(Cars car: L9cars9)
			car.render(g);
      for(Cars car: L9cars10)
			car.render(g);
      for(Cars car: L9cars11)
			car.render(g);
      for(Cars car: L9cars12)
			car.render(g);
      for(Cars car: L9cars13)
			car.render(g);
      for(Cars car: L9cars14)
			car.render(g);
   }
   
   public void renderGame10(Graphics g)
   {
      L9cars1 = null;
      L9cars2 = null;
      L9cars3 = null;
      L9cars4 = null;
      L9cars5 = null;
      L9cars6 = null;
      L9cars7 = null;
      L9cars8 = null;
      L9cars9 = null;
      L9cars10 = null;
      L9cars11 = null;
      L9cars12 = null;
      L9cars13 = null;
      L9cars14 = null; 
		g.drawImage(map5, 0, 0, null);
 
		dog.render(g);
      for(Cars car: L10cars1)
			car.render(g);
		for(Cars car: L10cars2)
			car.render(g);
      for(Cars car: L10cars3)
			car.render(g);
      for(Cars car: L10cars4)
			car.render(g);
      for(Cars car: L10cars5)
			car.render(g);
		for(Cars car: L10cars6)
			car.render(g);
      for(Cars car: L10cars7)
			car.render(g);
      for(Cars car: L10cars8)
			car.render(g);
      for(Cars car: L10cars9)
			car.render(g);
      for(Cars car: L10cars10)
			car.render(g);
      for(Cars car: L10cars11)
			car.render(g);
      for(Cars car: L10cars12)
			car.render(g);
      for(Cars car: L10cars13)
			car.render(g);
      for(Cars car: L10cars14)
			car.render(g);
   }
   
   public void renderVictory(Graphics g)
   {
      g.drawImage(victory, 0, 0, null);
 
   }




   //Only one method needed
   public void drawHearts(Graphics g) 
   {
      for (int i = 0; i < 8; i++) 
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
   
   
   //handles the different states for the different levels
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
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        isInsideLog();
      }    
      else if (state == STATE.GAME2) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame2(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        isInsideLog();
      }   
      
      else if (state == STATE.GAME3) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame3(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      }   
      
      else if (state == STATE.GAME4) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame4(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      }  
      
      else if (state == STATE.GAME5) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame5(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      }    
      
      else if (state == STATE.GAME6) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame6(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      } 
      
      else if (state == STATE.GAME7) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame7(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      } 
      
      else if (state == STATE.GAME8) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame8(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
        isInsideLog();
      }    
      
      else if (state == STATE.GAME9) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame9(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
      } 
      
       else if (state == STATE.GAME10) 
      {

        if (deaths <= 0) 
        {
            deaths = 9; // Reset lives properly when starting a new game
            firstDeath = true;
        }
        renderGame10(g);
        score();
        showInfo(g);
        drawHearts(g);
        didIntersectCar();
        didIntersectObstacle();
      } 
      
      else if (state == STATE.VICTORY) 
      {
        renderVictory(g);
      }      


      
      if (lostLife) 
      {
        g.drawImage(death, 248, 368, null);        
        long currentTime = System.currentTimeMillis();
        if (currentTime - deathTime >= 1000) // 1 second passed
        {
            lostLife = false;
        }
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
		while (true)
      {
            if (state == STATE.GAME && lastState != STATE.GAME) {
               // We just entered the game from the menu
               deaths = 8;
               if (firstDeath)
                  deaths = 9;
               score = 0;
               allocateLevel1Arrays();
               allocateLevel2Arrays();
               allocateLevel3Arrays();
               allocateLevel4Arrays();
               allocateLevel5Arrays();
               allocateLevel6Arrays();
               allocateLevel7Arrays();
               allocateLevel8Arrays();
               allocateLevel9Arrays();
               allocateLevel10Arrays();
               initializeGame(); // <-- reinitialize level 1 obstacles
            }

            // Update last state
            lastState = state;
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}

}