/**
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
	public int guessNumber(int n) {
		return binarySearch(1, n);
	}

	private int binarySearch(int st, int end) {
		if (st == end) return st;
		int mid = st + (end - st) / 2;
		if (guess(mid) == 1) return binarySearch(mid + 1, end);
		return binarySearch(st, mid);
	}
}