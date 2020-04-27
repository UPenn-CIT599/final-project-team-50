import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;


/**
 * @author feihan
 * This is Junit test methods in Person Class
 *
 */


class PersonTest {



	@Test
	void testSetDistanceToExit() {
		
		 class subPerson extends Person {//test setters without directly using getters
		     subPerson(int[] initialLocation) {
				super(initialLocation);
				
			}

		     Integer getterDistance() { return getDistanceToExit(); }
		   }
		
		int[] location = new int[]{1, 2};
		
		subPerson num1 = new subPerson(location);
		subPerson num2 = new subPerson(location);
		
		num1.setDistanceToExit(2);
		num2.setDistanceToExit(3);
		
        assertTrue(num1.getterDistance() ==2);
        assertFalse(num2.getterDistance() ==2);
		
	}

	@Test
	void testGetInitialLocation() {
		int[] location = new int[]{1, 2};
		
		Person num1 = new Person(location);
		
        assertTrue(num1.getInitialLocation() == location);
	}

	@Test
	void testGetDistanceToExit() {
		
		int[] location = new int[]{1, 2};
		
		Person num1 = new Person(location);
		
		num1.setDistanceToExit(2);
		
        assertTrue(num1.getDistanceToExit() ==2);
	}

	@Test
	void testCompareTo() {
		int[] location1 = new int[]{1, 2};
		int[] location2 = new int[]{3,4};
		Person num1 = new Person(location1);
		Person num2 = new Person(location2);
		num1.setDistanceToExit(3);
		num2.setDistanceToExit(4);
		//System.out.println(num1.compareTo(num2));
		assertTrue(num1.compareTo(num2)==num1.getDistanceToExit()-num2.getDistanceToExit());
		
	}

	@Test
	void testGetCurrentLocation() {
		int[] location1 = new int[]{1, 2};
		Person num1 = new Person(location1);
		assertTrue(num1.getCurrentLocation()==location1);
	}

	@Test
	void testSetCurrentLocation() {
		int[] location1 = new int[]{1, 2};
		Person num1 = new Person(location1);
		int r=2; int c=3;  int inarr1[] = {r,c}; 
		num1.setCurrentLocation(r, c);
		assertTrue(Arrays.equals(num1.getCurrentLocation(),inarr1));
				
	}


}
