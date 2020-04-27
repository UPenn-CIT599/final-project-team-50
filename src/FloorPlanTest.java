import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/*
*@author chizhang
*This is Junit test methods in FloorPlan Class

*/
class FloorPlanTest {
	@Test
	//when numPeople <= 86, people can be located successfully
	public void testLocatePeopleSuccess () {
		int k = 12;
		Exit exits = new Exit();
		
		FloorPlan fp = new FloorPlan(k, exits);
		
		
		boolean result1 = fp.locatePeople(54);
		assertTrue(result1);
	}
	
	
	@Test
	//when numPeople > 86, people cannot be located, it exceed the max ppl number
	public void testLocatePeopleFail () {
		int k = 12;
		Exit exits = new Exit();
		
		FloorPlan fp = new FloorPlan(k, exits);
		
		boolean result2 = fp.locatePeople(87);
		assertFalse(result2);
	}
	
	@Test
	public void testhasPeopleOnFloor () {
		int k = 12;
		Exit exits = new Exit();
		FloorPlan fp = new FloorPlan(k, exits);
		fp.locatePeople(3);
		boolean res = fp.hasPeopleOnFloor();
		
		assertTrue(res);
	}
	
	@Test
	public void testInbound() {
		int k = 12;
		Exit exits = new Exit();
		FloorPlan fp = new FloorPlan(k, exits);
		
		boolean result1 = fp.inbound(6,6);
		assertTrue(result1);
		boolean result2 = fp.inbound(20,11);
		assertFalse(result2);
	}
	
	@Test
	public void testGetMaxPeople() {
		int k = 12;
		Exit exits = new Exit();
		FloorPlan fp = new FloorPlan(k, exits);
		
		assertEquals(fp.getMaxPeople(),86);
	}
	
	@Test
	public void testGetFloorPlan() {
		int k = 12;
		Exit exits = new Exit();
		FloorPlan fp = new FloorPlan(k, exits);
		int[][] floorPlan = fp.getfloorPlan();
		
		assertEquals(1, floorPlan[4][4]);
	}
	
}
