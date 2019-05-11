package no739_DailyTemperatures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
	Solution s;
	
	@BeforeEach
	void setup() {
		s=new Solution();
	}
	
	
	@Test
	void testDailyTemperatures() {
		int[] result;
		result =s.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73});
		assertArrayEquals(new int[] {1, 1, 4, 2, 1, 1, 0, 0}, result);
		
		result=s.dailyTemperatures(new int[] {89,62,70,58,47,47,46,76,100,70});
		assertArrayEquals(new int[] {8,1,5,4,3,2,1,1,0,0}, result);
		
	}

}
