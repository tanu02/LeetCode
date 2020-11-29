package leetcode;

class Solution {

	public Integer computeSnowpack(Integer[] arr) {
		// Todo: Implement computeSnowpack
		if (arr == null || arr.length == 0)
			return 0;
		int[] maxLeftArr = new int[arr.length];
		int[] maxRightArr = new int[arr.length];
		maxLeftArr[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxLeftArr[i - 1] > arr[i]) {
				maxLeftArr[i] = maxLeftArr[i - 1];
			} else
				maxLeftArr[i] = arr[i];

		}
		int n  = arr.length; 
		maxRightArr[n - 1] = arr[n - 1];
		

		for (int i = arr.length - 2; i >= 0; i--) {
			if (maxRightArr[i + 1] > arr[i]) {
				maxRightArr[i] = maxRightArr[i + 1];
			} else
				maxRightArr[i] = arr[i];
		}

		int sum = 0;
		int min = 0;
		for (int j = 0; j < arr.length; j++) {
			min = Math.min(maxLeftArr[j], maxRightArr[j]);

			sum += min - arr[j];

		}
		return sum;
	}
}