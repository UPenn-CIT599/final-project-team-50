import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PlannerTest {
	
	@Test
	void testGetFloor() {
		
	}

	@Test
	void testGetDistanceWithWall() {
			
		Planner p = new Planner(9,1,2);
		int [][] res = p.getFloor().getfloorPlan();
		System.out.println("The floor looks like below at Time 0:");
		for (int i = 0; i < res.length; ++i) {
			for (int j = 0; j < res[i].length; ++j) {
				if (res[i][j] == 0) {
					System.out.print(" ");
				} else {
					System.out.print(res[i][j]);
				}
			}
			System.out.println();
		}
		
		int[] oneExit = p.getExits().getExitLocations().get(0); //test the first exist
		int r = oneExit[0];
		int c = oneExit[1];
		
		System.out.println("The location of exit A is: ("+r+","+c+")");
		int[][] distanceGrid = p.getDistanceWithWall(oneExit);
		
		System.out.println("The distance grid of exit A looks like: ");
		for (int i = 0; i < distanceGrid.length; ++i) {
			for (int j = 0; j < distanceGrid[i].length; ++j) {	
				System.out.printf("%d\t", distanceGrid[i][j]);
			}
			System.out.println();
		}
		
		assertEquals(distanceGrid[0][0], 0);
		assertEquals(distanceGrid[0][p.getFloor().getSize()-1], 0);
		assertEquals(distanceGrid[p.getFloor().getSize()-1][0], 0);
		assertEquals(distanceGrid[p.getFloor().getSize()-1][p.getFloor().getSize()-1], 0);
		
		
		
		ArrayList<Person> people = p.getPeople();
//		System.out.println(people.size());
//		for (int i = 0; i < people.size(); ++i) {
//			System.out.println(people.get(i).getDistanceToExit());
//		}
//		
//		HashMap<Person, int[]> closestExit = p.closestExit();
	}

}
