import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PlannerTest {

	@Test
	void testGetFloor() {
		Planner p = new Planner(9, 2, 2);
		FloorPlan floor = p.getFloor();
		int[][] floorArray = floor.getfloorPlan();

		assertEquals(floorArray[0][0], 1);
	}

	@Test
	void testGetExits() {
		Planner p = new Planner(9, 2, 2);
		Exit e = p.getExits();
		int numberOnFloorForExit = 0;

		for (int[] oneExit : e.getExitLocations()) {
			int r = oneExit[0];
			int c = oneExit[1];
			numberOnFloorForExit = p.getFloor().getfloorPlan()[r][c];
			assertEquals(numberOnFloorForExit, 2);
		}
	}

	@Test
	void testGetPeople() {
		Planner p = new Planner(9, 2, 2);
		ArrayList<Person> ppl = p.getPeople();
		int numberOnFloorForPeople = 0;

		for (Person per : ppl) {
			int r = per.getInitialLocation()[0];
			int c = per.getInitialLocation()[1];
			numberOnFloorForPeople = p.getFloor().getfloorPlan()[r][c];
			assertEquals(numberOnFloorForPeople, 3);
		}

	}

	@Test
	void testGetDistanceWithWall() {

		Planner p = new Planner(9, 2, 2);
		int[][] res = p.getFloor().getfloorPlan();
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

		int[] oneExit = p.getExits().getExitLocations().get(0); // test the first exist
		int r = oneExit[0];
		int c = oneExit[1];

		System.out.println("The location of exit A is: (" + r + "," + c + ")");
		int[][] distanceGrid = p.getDistanceWithWall(oneExit);

		System.out.println("The distance grid of exit A looks like: ");
		for (int i = 0; i < distanceGrid.length; ++i) {
			for (int j = 0; j < distanceGrid[i].length; ++j) {
				System.out.printf("%d\t", distanceGrid[i][j]);
			}
			System.out.println();
		}

		ArrayList<Person> people = p.getPeople();
		Person per = people.get(0); // test the first person
		int h = per.getCurrentLocation()[0];
		int l = per.getCurrentLocation()[1];
		int[] closetExit = p.getClosetExit(per);
		System.out.println("The closest exit for person at (" + h + "," + l + ") is the exit at (" + closetExit[0] + ","
				+ closetExit[1] + ")");

	}
	
	@Test
	void testGetClosetExit() {
		Planner p = new Planner (9, 2, 2);
		Person per = p.getPeople().get(0);
		int[] closetExit = p.getClosetExit(per);
		assertEquals(closetExit.length, 2);
	}
	
	@Test
	void testClosetExit() {
		Planner p = new Planner (9, 2, 2);
		HashMap<Person, int[]> personToExitIndex = p.closestExit();
		int size = personToExitIndex.size();
		assertEquals(size, 2);	
	}

}

	


