package no866_PrimePalindrome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {
	Solution s = new Solution();

	@Test
	void test1() {
		assertEquals(7, s.primePalindrome(6));
	}
	
	@Test
	void test2() {
		assertEquals(11, s.primePalindrome(8));
	}
	
	@Test
	void test3() {
		assertEquals(101, s.primePalindrome(13));
	}
	
	@Test
	void test4() {
		assertEquals(131, s.primePalindrome(102));
	}
	
	@Test
	void test5() {
		assertEquals(100030001, s.primePalindrome(9989900));
	}
}
