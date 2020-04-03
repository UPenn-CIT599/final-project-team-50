import java.util.ArrayList;

public class FloorPlan {
	
	//size = 3n+1 (n >= 10)
	private int size;
	private boolean[][] walls;
	private ArrayList<People> people;
	private ArrayList<Exit> exits;
	
	
	public void floorPlan(int k) {
		this.size = k;
		this.exits = new ArrayList<Exit>();
		this.walls = new boolean [size][size];
		
		//core
		//r = 1/3 * size
		for(int c = 1/3 * size; c <= 2/3 * size; c++ ) {
			walls[1/3 * size][c] = true;
		}
		
		//r = 2/3 * size
		for(int c = 1/3 * size; c <= 2/3 * size; c++ ) {
			walls[2/3 * size][c] = true;
		}
		
		//c = 1/3 * size
		for(int r = 1/3 * size; r <= 2/3 * size; r++ ) {
			if(r == 1/2 * size) {
				continue;
			}
			walls[r][1/3 * size] = true;
		}
		
		//c = 2/3 * size
		for(int r = 1/3 * size; r <= 2/3 * size; r++) {
			if(r == 1/2 * size) {
				continue;
			}
			walls[r][2/3 * size] = true;
		}
		
		//perimeter
		for(int c=0; c < size; c++) {
			for(int r=0; r < size; r++) {
				if ((r==0)||(r==size-1)||(c==0)||(c==size-1)) {
					walls[r][c] = true;
				}
				else {
					walls[r][c] = false;
				}
			}
		}
		
	}
	
	public int getSize() {
		return size;
	}

	public boolean[][] getWalls() {
		return walls;
	}

	public ArrayList<People> getPeople() {
		return people;
	}

	public ArrayList<Exit> getExits() {
		return exits;
	}

	
	public boolean valid(int r, int c) {
		return (r>=0)&&(r<size)&&(c>=0)&&(c<size);
	}

	public void setPeople(ArrayList<People> people) {
		this.people = people;
	}

	public void setExits(ArrayList<Exit> exits) {
		this.exits = exits;
	}
	
	public void addExit(Exit exit){
		exits.add(exit);
	}
	
	public void addPeople(People ppl) {
		people.add(ppl);
	}

}
