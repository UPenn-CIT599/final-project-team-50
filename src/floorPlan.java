import java.util.ArrayList;

public class floorPlan {
	private int size;	// # of rows and columns in table
	private boolean[][]	walls;	// Grid indicating whether a wall is there or not
	private ArrayList<exit>	exits;	// List of available building exits
	
	public floorPlan(int rw) {
		size = rw;
		exits = new ArrayList<exit>();
		walls = new boolean[size][size];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean[][] getWalls() {
		return walls;
	}

	public void setWalls(boolean[][] walls) {
		this.walls = walls;
	}

	public ArrayList<exit> getExits() {
		return exits;
	}

	public void setExits(ArrayList<exit> exits) {
		this.exits = exits;
	}
	
	
}
