import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

class PlannerTest {

	@Test
	void testGetDistanceWithWall() {
			
		Planner p = new Planner();
		int [][] res = p.getFloor().getfloorPlan();
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
		
		ArrayList<Person> people = p.getPeople();
		System.out.println(people.size());
		for (int i = 0; i < people.size(); ++i) {
			System.out.println(people.get(i).getDistanceToExit());
		}
		
		HashMap<Person, int[]> closestExit = p.closestExit();
	}

}
