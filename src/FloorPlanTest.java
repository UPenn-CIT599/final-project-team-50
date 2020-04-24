import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class FloorPlanTest {
	@Test
	public void testLocatePeople () {
		int k = 12;
		Exit exits = new Exit();
		
		FloorPlan fp = new FloorPlan(k, exits);
		
		int [][] res =  fp.getfloorPlan();
		for (int i = 0; i < res.length; ++i) {
			for (int j = 0; j < res[i].length; ++j) {
				System.out.print(res[i][j]);
			}
			System.out.println();
		}
		
		
		boolean result1 = fp.locatePeople(54);
		assertTrue(result1);
		boolean result2 = fp.locatePeople(55);
		assertFalse(result2);
	}

}
