import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 5;
	boolean isActive = true;
	
	Rectangle collisionBox;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
	}

	void update() {
        collisionBox.setBounds(x, y, width, height);
	}

	void up() {
		for (int i = 0; i < 3; i++) {
			y -= speed;
		}
	}

	void down() {
		for (int i = 0; i < 3; i++) {
		y += speed;
		}
	}

	void left() {
		for (int i = 0; i < 3; i++) {
		x -= speed;
		}
	}

	void right() {
		for (int i = 0; i < 3; i++) {
		x += speed;
		}
	}
}
