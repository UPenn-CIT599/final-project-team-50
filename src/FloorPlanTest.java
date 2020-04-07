import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class FloorPlanTest {
	@Test
	public void testLocatePeople () {
		int k = 10;
		Exit exits = new Exit();
		
		FloorPlan fp = new FloorPlan(k, exits);
		
		boolean result1 = fp.locatePeople(54);
		assertTrue(result1);
		boolean result2 = fp.locatePeople(55);
		assertFalse(result2);
	}

}
