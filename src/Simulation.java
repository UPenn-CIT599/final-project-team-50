
public class Simulation {

	public static void main(String[] args) {
		Planner Plan = new Planner();
		int timer = 0;

		while (Plan.getFloor().hasPeopleOnFloor()) {
			for (Person p : Plan.getPeople()) {
				// index of current location
				int iCur = p.getCurrentLocation()[0]; // row
				int jCur = p.getCurrentLocation()[1]; // column
				int iNext = iCur;
				int jNext = jCur;

				int[][] distanceGrid = Plan.getDistanceWithWall(Plan.getClosetExit(p));

				if (iCur > 0) {
					int distanceIfGoUp = distanceGrid[iCur - 1][jCur];
					if (distanceIfGoUp == p.getDistanceToExit() - 1
							&& Plan.getFloor().getfloorPlan()[iCur - 1][jCur] == 0) {
						iNext = iCur - 1;
					}
				}

				if (iCur < Plan.getFloor().getSize() - 1) {
					int distanceIfGoDown = distanceGrid[iCur + 1][jCur];
					if (distanceIfGoDown == p.getDistanceToExit() - 1
							&& Plan.getFloor().getfloorPlan()[iCur + 1][jCur] == 0) {
						iNext = iCur + 1;
					}
				}

				if (jCur > 0) {
					int distanceIfGoLeft = distanceGrid[iCur][jCur - 1];
					if (distanceIfGoLeft == p.getDistanceToExit() - 1
							&& Plan.getFloor().getfloorPlan()[iCur][jCur - 1] == 0) {
						jNext = jCur - 1;
					}
				}

				if (jCur < Plan.getFloor().getSize() - 1) {
					int distanceIfGoRight = distanceGrid[iCur][jCur + 1];
					if (distanceIfGoRight == p.getDistanceToExit() - 1
							&& Plan.getFloor().getfloorPlan()[iCur][jCur + 1] == 0) {
						jNext = jCur + 1;
					}
				}
			
				Plan.getFloor().getfloorPlan()[iCur][jCur] = 0;
				Plan.getFloor().getfloorPlan()[iNext][jNext] = 3;
				
				iCur = iNext;
				jCur = jNext;
				p.setCurrentLocation(iCur, jCur);
				p.setDistanceToExit(distanceGrid[iCur][jCur]);
				
				
			}
			timer++;
			
			int [][] res = Plan.getFloor().getfloorPlan();
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
		}
		System.out.println("The escape takes " + timer + "mins");
	}

}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			