package no866_PrimePalindrome;

class Solution {
	private boolean is_prime(int n) {
		if (n <= 1) {
			return false;
		}
		else if (n <= 3) {
			return true;
		}
		else if (n % 2 == 0 || n % 3 == 0) {
			return false;
		}
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}
		}
		return true;
	}
	
	// for example 12321, head is 123, tail is 21
	int odd_palindrome(int head) {
		int tail=0;
		int exp=1; //10 exponent number
		for(int r=head/10; r>0; r/=10) {
			int d = r%10;
			tail=tail*10+d;
			exp *= 10;
		}
		return head * exp + tail;
	}
	
	public int primePalindrome(int N) {
		if(N>7 && N<=11) {
			return 11; //11 is the only even-palindrome that's prime.
		}
		for(int i=0; i<100000;i++) {
			int p = odd_palindrome(i);
			if(p>=N && is_prime(p)) {
				return p;
			}
		}
		return -1;
	}
}