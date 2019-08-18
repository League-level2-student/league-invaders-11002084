
public class GameObject {
	int x;
	int y;
	int width;
	int height;
	int speed = 10;
	boolean isActive = true;

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	void update(){
		
	}
	
	void up() {
		y-=speed;
	}
	
	void down() {
		y+=speed;
	}
	
	void left() {
		x-=speed;
	}
	
	void right() {
		x+=speed;
	}
}
