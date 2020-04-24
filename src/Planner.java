
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

/**
 * @author yao16
 * Assumption: 1. the person closer to an exit will move first
 * 			   2. the move speed of each person are same
 */
public class Planner {
	private FloorPlan floor;
	private UserInput userDefine;
	private Exit exits;
	private ArrayList<Person> people;
	
	public Planner() {
		exits = new Exit();
		exits.locationGenerator(userDefine.getNumberOfExits(), userDefine.getFloorSize()); //only locate exit on the floor once
		floor = new FloorPlan(userDefine.getFloorSize(), exits);
		people = buildPeopleArray();
	}
	
	
	// getters of instance variables
	public FloorPlan getFloor() {
		return floor;
	}



	public UserInput getUserDefine() {
		return userDefine;
	}



	public Exit getExits() {
		return exits;
	}



	// method to store all the people on the floor in an ArrayList
	private ArrayList<Person> buildPeopleArray() {
		ArrayList<Person> sortedPeople = new ArrayList<>();
		ArrayList<Person> unsortedPeople = new ArrayList<>();
		boolean locatePeopleSuccess = floor.locatePeople(userDefine.getNumberOfPeople()); //only locate people on the floor once by calling locatePeople method
		while (!locatePeopleSuccess) {
			System.out.println("The number of people exceeds the maximum");
			userDefine.setNumberOfPeople();
			locatePeopleSuccess = floor.locatePeople(userDefine.getNumberOfPeople());
		}
		if(locatePeopleSuccess) {
			int s = floor.getSize();
			for (int r = 0; r < s; r++) {
				for (int c = 0; c < s; c++) {
					if (floor.getfloorPlan()[r][c] == 3) {
						int[] initialLocation = { r, c };
						Person p = new Person(initialLocation); //create one person
						unsortedPeople.add(p);
					}
				}
			}
		
		}
		for (Person p:unsortedPeople) {
			int i = p.getInitialLocation()[0];
			int j=p.getInitialLocation()[1];
			int[] closetExit = getClosetExit(p);
			int[][] distanceMap = getDistanceWithWall(closetExit);
			p.setDistanceToExit(distanceMap[i][j]);
		}
		
		Collections.sort(unsortedPeople); //set the priority that person with the shorter distance has the priority over person with longer distance
		
		return sortedPeople;
	}

	public ArrayList<Person> getPeople() {
		return people;
	}
	
	/**using BREADTH-FIRST SEARCH
	 * @param location of exit
	 * This method will take the location of one exit and generate a 2D array
	 * to store the distance between this exit to all the available location (not a wall) on a floor map. 
	 */
	  public int[][] getDistanceWithWall(int[] oneExit) {	
		int h=floor.getSize();
		if(h==0)
			return null;
		int l=floor.getSize();
		boolean[][] visited = new boolean[h][l];
		int[][] distanceWithWall = new int[h][l];
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(oneExit);
		int distance=0;
		while(!queue.isEmpty()) {
			int[] curVertex = queue.remove();
			int row = curVertex[0];
			int col = curVertex[1];
			int[]leftVertex = {row,col-1};
			int[]rightVertex = {row,col+1};
			int[]upVertex = {row-1,col};
			int[]downVertex = {row+1,col};
			
			if (row < 0 || col < 0 || row >= h || col >= l || visited[row][col])
                continue;
			
			visited[row][col]=true;
			if(floor.getfloorPlan()[row][col]==1) {
				distanceWithWall[row][col]=-1; // if there is a wall on that point, then the distance return -1.
			}
			else {
				distanceWithWall[row][col]=distance;
				distance++;
			}
				
			queue.add(leftVertex); //go left
            queue.add(rightVertex); //go right
            queue.add(upVertex); //go up
            queue.add(downVertex); //go down		
		}		
		return distanceWithWall;
	}
	
	

	//helper method to find which exit is the closet one for one person
	public int[] getClosetExit(Person p) {
		int r = p.getInitialLocation()[0];
		int c = p.getInitialLocation()[1];
	
		HashMap<int[],Integer> distanceToEachExit = new HashMap<int[], Integer>();
			
		for (int[] oneExit: exits.getExitLocations()) {
			int[][] distanceMapForExit = getDistanceWithWall(oneExit);
			p.setDistanceToExit(distanceMapForExit[r][c]);
			distanceToEachExit.put(oneExit,p.getDistanceToExit());
		}
		
		int shortestDistance = Collections.min(distanceToEachExit.values());
		int[] closetExit = new int[2];
		for(Entry<int[], Integer> entry: distanceToEachExit.entrySet()) {
			if(entry.getValue()==shortestDistance) {
				closetExit = entry.getKey();
			}
		}			
		return closetExit;			
	}
	
	/**
	 * @param A person
	 * This method will take all people on the floor and return a HashMap outline closest exit each person should go
	 */


	/**
	 * @param A person
	 * This method will take all people on the floor and return a HashMap outline closest exit each person should go
	 */
	public HashMap<Person, int[]> closestExit() {			
		HashMap<Person, int[]> personToExit = new HashMap<Person, int[]>(); 
		
		for(Person p:people) {
			int[] closetExit = getClosetExit(p);
			personToExit.put(p, closetExit);
		}	
		return personToExit;
	}
	
	
}
	
