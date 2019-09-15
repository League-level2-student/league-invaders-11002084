import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocketship;
	ArrayList<Projectile> projectile = new ArrayList<>();
	ArrayList<Alien> alien = new ArrayList<>();
	Random random = new Random();
	int score = 0;
	
	int getScore() {
		return score;
	}

	ObjectManager(Rocketship rocketship) {
		this.rocketship = rocketship;
	}

	void addProjectile(Projectile projectile) {
		this.projectile.add(projectile);
	}

	void addAlien() {
		alien.add(new Alien(random.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}
	
	void checkInvasion() {
		for(int i=0; i<alien.size(); i++) {
			if(alien.get(i).y==800 && score>0) {
				score--;
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < alien.size(); i++) {
			if (rocketship.collisionBox.intersects(alien.get(i).collisionBox)) {
				rocketship.isActive = false;
				alien.get(i).isActive = false;
			}
			for (int j = 0; j < projectile.size(); j++) {
				if (projectile.get(j).collisionBox.intersects(alien.get(i).collisionBox)) {
					alien.get(i).isActive = false;
					projectile.get(j).isActive = false;
					score++;
				}
			}
		}
	}

	void update() {
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).update();
			if (alien.get(i).getY() > LeagueInvaders.HEIGHT) {
				alien.get(i).isActive = false;
			}
		}

		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).update();
			if (projectile.get(i).getY() > LeagueInvaders.HEIGHT) {
				projectile.get(i).isActive = false;
			}
		}

		rocketship.update();
		checkCollision();
		checkInvasion();
		purgeObjects();
	}

	void draw(Graphics g) {
		rocketship.draw(g);
		for (int i = 0; i < alien.size(); i++) {
			alien.get(i).draw(g);
		}
		for (int i = 0; i < projectile.size(); i++) {
			projectile.get(i).draw(g);
		}
	}

	void purgeObjects() {
		for (int i = 0; i < projectile.size(); i++) {
			if (projectile.get(i).isActive == false) {
				projectile.remove(i);
			}
		}
		for (int i = 0; i < alien.size(); i++) {
			if (alien.get(i).isActive == false) {
				alien.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
