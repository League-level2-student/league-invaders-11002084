 import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.Timer;

public class LeagueInvaders {

	static Font font;
	static Font secondFont;
	JFrame frame;
	GamePanel gamePanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	Timer timer;

	LeagueInvaders(JFrame frame, GamePanel gamePanel) {
		this.frame = frame;
		this.gamePanel = gamePanel;
	}

	void setup() {
		frame.add(gamePanel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(gamePanel);
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders(new JFrame(), new GamePanel(font, secondFont));
		leagueInvaders.setup();
	}
}
