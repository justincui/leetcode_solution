package no867_TransposeMatrix;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {

	Solution s;
	
	@BeforeEach
	void setup() {
		s= new Solution();
	}
	
	@Test
	void test1() {
		int[][] input= {{1,2,3},{4,5,6}};
		int[][] expected= {{1,4},{2,5},{3,6}};
		
		int[][] result = s.transpose(input);
		assertArrayEquals(expected, result);
	}

	@Test
	void test2() {
		int[][] input= {{1,2,3},{4,5,6},{7,8,9}};
		int[][] expected= {{1,4,7},{2,5,8},{3,6,9}};
		
		int[][] result = s.transpose(input);
		assertArrayEquals(expected, result);
	}
}
