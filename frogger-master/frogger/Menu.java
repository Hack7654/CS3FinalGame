package frogger;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Menu implements MouseMotionListener, MouseListener, KeyListener {
    private Rectangle playButton, helpButton, quitButton, helpBackButton, paperscButton;
    private BufferedImage playButtonImg, helpButtonImg, quitButtonImg, helpBackButtonImg, paperscImg, map;

    public Menu() {
        playButton = new Rectangle(240, 110, 119, 55);
        helpButton = new Rectangle(245, 210, 110, 55);
        paperscButton = new Rectangle(140, 40, 320, 390);
        quitButton = new Rectangle(245, 310, 110, 55);
        helpBackButton = new Rectangle(272, 290, 55, 55);
        
        loadImages();
    }

    private void loadImages() {
        try {
            map = ImageIO.read(getClass().getResourceAsStream("img/menu.png"));
            playButtonImg = ImageIO.read(getClass().getResourceAsStream("img/play.png"));
            helpButtonImg = ImageIO.read(getClass().getResourceAsStream("img/help.png"));
            quitButtonImg = ImageIO.read(getClass().getResourceAsStream("img/quit.png"));
            paperscImg = ImageIO.read(getClass().getResourceAsStream("img/papersc.png"));
            helpBackButtonImg = ImageIO.read(getClass().getResourceAsStream("img/back.png"));
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
        }
        if (Display.state == Display.STATE.HELP) {
            g2d.drawImage(paperscImg, paperscButton.x, paperscButton.y, paperscButton.width, paperscButton.height, null);
            g2d.setColor(Color.RED);
            g2d.setFont(new Font("Century Gothic", Font.BOLD, 20));
            g2d.drawString("USE ARROW KEYS TO PLAY, ESC TO QUIT", 110, helpButton.y);
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
    @Override public void keyPressed(KeyEvent e) { if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(1); }
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
