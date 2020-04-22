
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yao16
 * Assumption: 1. the person closer to an exit will move first
 * 			   2. the move speed of each person are same
 */
public class Planner {
	private FloorPlan floor;
	private UserInput userDefine;
	private Exit exit;
	
	public Planner() {
		exit = new Exit();
		floor = new FloorPlan(userDefine.getFloorSize(),exit);		
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
	
	//A helper method to store all the people on the floor in an ArrayList
	private ArrayList<Person> buildPeopleArray(){
		ArrayList<Person> people = new ArrayList<>();		
		if(!floor.locatePeople(userDefine.getNumberOfPeople())) {
			System.out.println("The number of people exceeds the maximum");
			userDefine.setNumberOfPeople();
		}
		else {
			int s = floor.getSize();
			int personID = floor.getMaxPeople();
			for(int r=0;r<s;r++) {
				for(int c=0;c<s;c++) {
					if (floor.getfloorPlan()[r][c]==3) {
						int []initialLocation = {r,c};				
						Person p = new Person(personID--,1,initialLocation);
						people.add(p);
					}
				}
			}
		}	
		return people;
	}


	/**
	 * @param A person
	 * This method will take all people on the floor and return a HashMap outline closest exit each person should go
	 */
	public HashMap<Person, Exit> closestExit() {
		ArrayList<Person> people = buildPeopleArray();
		
		HashMap<Person, Exit> personToExit = new HashMap<Person, Exit>(); 
		
			}
		}
		
		return personToExit;
	}
	/**
	 * @param A person
	 * This method will take one person and return the distance between this person and the exit he/she is going
	 */
	public int distanceToExit (Person p){  
		int distance=0;
		
		//implement the method
		
		return distance;
	}
	
	/**
	 * @param everyone on the floor
	 * This method will take everyone on the floor and sorted them by their distance to the target exit.
	 */
	public Person[] movePriority(Person[] allPeople) {
		Person[] sortedPeople = new Person[userDefine.numberOfPeople()];
		
		//implement the method
		
		return sortedPeople;
	}
}
	
