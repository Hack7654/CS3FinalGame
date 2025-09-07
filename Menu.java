//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class creates the menu screen which is shown as soon as the program is run. 
//It places the logo and buttons in the correct places, and creates function for the play, help, and quit buttons.


import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Menu extends JPanel implements MouseMotionListener, MouseListener, KeyListener {
    private Rectangle playButton, helpButton, quitButton, helpBackButton, paperscButton, instructButton, arrowB, escB, arrowmB, titleB;
    private BufferedImage playButtonImg, helpButtonImg, quitButtonImg, helpBackButtonImg, paperscImg, instructImg, arrowImg, escImg, arrowmImg, titleImg, map;

    public Menu() {
        playButton = new Rectangle(285, 375, 119, 55);
        helpButton = new Rectangle(290, 500, 110, 55);
        instructButton = new Rectangle(135, 570, 440, 225);
        arrowB = new Rectangle(370, 230, 220, 160);
        paperscButton = new Rectangle(50, 50, 600, 800);
        quitButton = new Rectangle(290, 625, 110, 55);
        helpBackButton = new Rectangle(570, 70, 55, 55);
        escB = new Rectangle(105, 285, 219, 105);
        arrowmB = new Rectangle(365, 415, 219, 105);
        titleB = new Rectangle(25, 35, 620, 330);
        
        loadImages();
        addMouseListener(this); // Adds mouse listener to capture mouse clicks
        addMouseMotionListener(this); // Adds mouse motion listener if needed
        addKeyListener(this); // Adds key listener to capture key events
        setFocusable(true); // Makes the panel focusable so it can receive key events
    }

    private void loadImages() {
        try {
            map = ImageIO.read(getClass().getResourceAsStream("menu.png"));
            playButtonImg = ImageIO.read(getClass().getResourceAsStream("play.png"));
            helpButtonImg = ImageIO.read(getClass().getResourceAsStream("help.png"));
            instructImg = ImageIO.read(getClass().getResourceAsStream("instruct.png"));
            quitButtonImg = ImageIO.read(getClass().getResourceAsStream("quit.png"));
            arrowImg = ImageIO.read(getClass().getResourceAsStream("arrow.png"));
            paperscImg = ImageIO.read(getClass().getResourceAsStream("papersc.png"));
            helpBackButtonImg = ImageIO.read(getClass().getResourceAsStream("back.png"));
            escImg = ImageIO.read(getClass().getResourceAsStream("esc.png"));
            titleImg = ImageIO.read(getClass().getResourceAsStream("title.png"));
            arrowmImg = ImageIO.read(getClass().getResourceAsStream("arrowm.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(map, 0, 0, null);

        if (Display.state == Display.STATE.MENU) {
            g2d.drawImage(playButtonImg, playButton.x, playButton.y, playButton.width, playButton.height, null);
            g2d.drawImage(helpButtonImg, helpButton.x, helpButton.y, helpButton.width, helpButton.height, null);
            g2d.drawImage(quitButtonImg, quitButton.x, quitButton.y, quitButton.width, quitButton.height, null);
            g2d.drawImage(titleImg, titleB.x, titleB.y, titleB.width, titleB.height, null);
        }
        if (Display.state == Display.STATE.HELP) {
            g2d.drawImage(paperscImg, paperscButton.x, paperscButton.y, paperscButton.width, paperscButton.height, null);
            g2d.drawImage(instructImg, instructButton.x, instructButton.y, instructButton.width, instructButton.height, null);
            g2d.drawImage(arrowImg, arrowB.x, arrowB.y, arrowB.width, arrowB.height, null);
            g2d.drawImage(escImg, escB.x, escB.y, escB.width, escB.height, null);
            g2d.drawImage(arrowmImg, arrowmB.x, arrowmB.y, arrowmB.width, arrowmB.height, null);
            g2d.drawImage(helpBackButtonImg, helpBackButton.x, helpBackButton.y, helpBackButton.width, helpBackButton.height, null);
        }
    }

    private boolean isInsideRect(Rectangle button, int x, int y) {
        return button.contains(x, y);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mouseX = e.getX();
        int mouseY = e.getY();
        if (isInsideRect(playButton, mouseX, mouseY) && Display.state == Display.STATE.MENU) {
            Display.state = Display.STATE.GAME;
        } else if (isInsideRect(helpButton, mouseX, mouseY) && Display.state == Display.STATE.MENU) {
            Display.state = Display.STATE.HELP;
        } else if (isInsideRect(quitButton, mouseX, mouseY) && Display.state == Display.STATE.MENU) {
            System.exit(1);
        } else if (Display.state == Display.STATE.HELP && isInsideRect(helpBackButton, mouseX, mouseY)) {
            Display.state = Display.STATE.MENU;
        }
    }

    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseDragged(MouseEvent e) {}
    @Override public void mouseMoved(MouseEvent e) {}
    @Override public void keyPressed(KeyEvent e) { 
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(1); 
    }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
