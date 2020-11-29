package leetcode;

class Solution {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if(n == 0) return true; 
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 1 || (i > 0 && flowerbed[i - 1] == 1)
					|| (i < flowerbed.length - 1 && flowerbed[i + 1] == 1))
				continue;

			flowerbed[i] = 1;
			count++;
			if (count == n)
				return true;
		}
		return false;

	}
}
