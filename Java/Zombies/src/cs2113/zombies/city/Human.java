package cs2113.zombies.city;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Human {

	public static final int CHANCE = 10;
	public static final Color COLOR = Color.WHITE;

	private static int count = 0;

	private Random rand;
	private int id;
	private int x;
	private int y;
	private Direction dir;
	private List<Direction> dirs;

	// ==========================================================
	// Constructors
	// ==========================================================

	public Human() {
		count++;
		this.id = count;
		this.rand = new Random();
		this.x = 0;
		this.y = 0;
		this.dir = Direction.NIL;
		dirs = new LinkedList<>();
	}

	public Human(int id, int x, int y, Direction d, List<Direction> dirs) {
		this.id = id;
		this.rand = new Random();
		this.x = x;
		this.y = y;
		this.dir = d;
		this.dirs = dirs;
	}

	//Soo's human move method
	private void move(City city) {
		
		if (dir == Direction.NORTH) {y--;} 
		else if (dir == Direction.SOUTH) {y++;} 
		else if (dir == Direction.EAST) {x++;} 
		else if (dir == Direction.WEST) {x--;}
		
		if (x < 0 || x >= city.getWidth() || y < 0 || y >= city.getHeight() || Human.COLOR == city.getColor(x, y) || Building.BUILDING_COLOR == city.getColor(x, y)) {
			
			//move back
			if (dir == Direction.NORTH) {y++;} 
			else if (dir == Direction.SOUTH) {y--;} 
			else if (dir == Direction.EAST) {x--;} 
			else if (dir == Direction.WEST) {x++;}
			
			//turn around
			if (dir == Direction.NORTH) {dir = Direction.SOUTH;}
			else if (dir == Direction.SOUTH) {dir = Direction.NORTH;}
			else if (dir == Direction.EAST) {dir = Direction.WEST;}
			else if(dir == Direction.WEST) {dir = Direction.EAST;}		
		}
		
	}
	
	// ==========================================================
	// Accessors
	// ==========================================================

	public int getID() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Direction getDir() {
		return dir;
	}

	// ==========================================================
	// Initialize
	// ==========================================================

	/**
	 * Places this person in a random position within the city by coloring the
	 * appropriate dot. Avoids placing the person if something is already there.
	 * 
	 * @param city
	 */
	public void initialize(City city) {
		// TODO Implement this method
		if(this.dir == Direction.NIL) {
			while( city.getColor(x, y) == Human.COLOR || city.getColor(x, y) == Building.BUILDING_COLOR ) {	
				x = rand.nextInt(city.getWidth());
				y = rand.nextInt(city.getHeight());
			}
		}
		
		city.setColor(x, y, Human.COLOR);
	}

	// ==========================================================
	// update
	// ==========================================================

	public void update(City city) {
		// TODO Implement this method
		city.setColor( x, y, City.CITY_COLOR );
		
		if(dirs.isEmpty()) {
			rand.nextInt(100);
			if (rand.nextInt(100) < CHANCE) {
				rand.nextInt(4);
				switch (rand.nextInt(4)) {
					case 0:
						dir = Direction.NORTH;
						break;
					case 1:
						dir = Direction.SOUTH;
						break;
					case 2:
						dir = Direction.EAST;
						break;
					case 3:
						dir = Direction.WEST;
						break;	
				}
			} else {
				
				move(city);	
				
			}
		} else {
			
			if(dirs.get(0) == Direction.NIL) {
				
				move(city);
				
			} else {
				
				dir = dirs.get(0);
				dirs.remove(0);
				
			}
			
			
		}
		
		city.setColor( x, y, Human.COLOR );
		
	}
	
	// ==========================================================
	// toString
	// ==========================================================

	public String toString() {
		return "(" + x + ", " + y + ", " + dir + ")";
	}
}
