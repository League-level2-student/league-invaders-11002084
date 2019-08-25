import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class GamePanel extends JPanel implements ActionListener, KeyListener {

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	public Font titleFont;
	public Font smallerFont;
	Timer frameDraw;
	Rocketship rocketship = new Rocketship(250, 700, 50, 50);
	ObjectManager objectManager = new ObjectManager(rocketship);

	GamePanel(Font titleFont, Font smallerFont) {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		this.titleFont = titleFont;
		smallerFont = new Font("Arial", Font.PLAIN, 16);
		this.smallerFont = smallerFont;
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	void updateMenuState() {

	}

	void updateGameState() {
		objectManager.update();
	}

	void updateEndState() {

	}
	
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}


	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 25, 150);
		g.setFont(smallerFont);
		g.drawString("Press ENTER to start", 160, 400);
		g.drawString("Press SPACE for instructions", 130, 600);
	}

	void drawGameState(Graphics g) {
		g.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
		objectManager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("GAME OVER", 100, 150);
		g.setFont(smallerFont);
		g.drawString("You failed to defend Earth", 150, 400);
		g.drawString("and everyone is now dead.", 150, 425);
		g.drawString("Good job.", 200, 600);
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		this.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (currentState == GAME) {
			if (e.getKeyCode() == KeyEvent.VK_UP && rocketship.y >= 10) {
				System.out.println("UP");
				rocketship.up();
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN && rocketship.y <= 720) {
				System.out.println("DOWN");
				rocketship.down();
			}
			if (e.getKeyCode() == KeyEvent.VK_LEFT && rocketship.x >= 10) {
				System.out.println("LEFT");
				rocketship.left();
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT && rocketship.x <= 440) {
				System.out.println("RIGHT");
				rocketship.right();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
