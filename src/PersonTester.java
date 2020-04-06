import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * @author feihan
 * This is Junit test for test getLocation function in Person Class
 *
 */

class PersonTester {

	@Test
	public void testLocationGetter() {
		
		int[] location = new int[]{1, 2};
		
		People num1 = new Person(1,1.0,location);
		
        assertTrue(num1.getLocation() == location);
    }
	}

