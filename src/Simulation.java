import java.util.ArrayList;

public class Simulation {
	public void simulate(Planner Plan) {
		//Planner Plan = new Planner();
		int[][] Floor = Plan.getFloor().getfloorPlan();
		ArrayList<Person> People = Plan.getPeople();

		int timer = 0;
		
		//run below code as long as there is any people left on the floor
		while (Plan.getFloor().hasPeopleOnFloor()) {
			for (Person p : People) {
				
				// index of current location
				int iCur = p.getCurrentLocation()[0]; // row
				int jCur = p.getCurrentLocation()[1]; // column
				int iNext = iCur;
				int jNext = jCur;

				//generate the distance index map for the closet exit this person is going
				int[][] distanceGrid = Plan.getDistanceWithWall(Plan.getClosetExit(p));

				//when the person at the door (the distance to exit is only 1)
				if (p.getDistanceToExit() == 1) {
					People.remove(new Person(p.getCurrentLocation()));
					Floor[iCur][jCur] = 0;
				}

				else {
					//person go up
					if (iCur > 0) {
						int distanceIfGoUp = distanceGrid[iCur - 1][jCur];
						if (distanceIfGoUp == p.getDistanceToExit() - 1 && Floor[iCur - 1][jCur] == 0) {
							iNext = iCur - 1;
						}
					}
					//person go down
					if (iCur < Plan.getFloor().getSize() - 1) {
						int distanceIfGoDown = distanceGrid[iCur + 1][jCur];
						if (distanceIfGoDown == p.getDistanceToExit() - 1 && Floor[iCur + 1][jCur] == 0) {
							iNext = iCur + 1;
						}
					}
					//person go left
					if (jCur > 0) {
						int distanceIfGoLeft = distanceGrid[iCur][jCur - 1];
						if (distanceIfGoLeft == p.getDistanceToExit() - 1 && Floor[iCur][jCur - 1] == 0) {
							jNext = jCur - 1;
						}
					}
					//person go right
					if (jCur < Plan.getFloor().getSize() - 1) {
						int distanceIfGoRight = distanceGrid[iCur][jCur + 1];
						if (distanceIfGoRight == p.getDistanceToExit() - 1 && Floor[iCur][jCur + 1] == 0) {
							jNext = jCur + 1;
						}
					}
					
					//person moved, so update the floorplan.
					Floor[iCur][jCur] = 0;
					Floor[iNext][jNext] = 3;

					iCur = iNext;
					jCur = jNext;
					p.setCurrentLocation(iCur, jCur);
					p.setDistanceToExit(distanceGrid[iCur][jCur]);

				}

			}
			timer++;
			//print out what the floor looks like at one moment
			for (int i = 0; i < Floor.length; ++i) {
				for (int j = 0; j < Floor[i].length; ++j) {
					if (Floor[i][j] == 0) {
						System.out.print(" ");
					} else {
						System.out.print(Floor[i][j]);
					}
				}
				System.out.println();
			}
		}
		System.out.println("The escape takes " + timer + " mins");
	}

}
