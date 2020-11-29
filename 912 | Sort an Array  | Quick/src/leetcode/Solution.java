package leetcode;

class Solution {
	int[] arr;

	public int[] sortArray(int[] nums) {
		arr = nums;
		sort(0, nums.length - 1);
		return arr;
	}

	void sort(int st, int end) {
		if (st >= end)
			return;
		int part = partition(st, end);
		sort(st, part - 1);
		sort(part + 1, end);
	}

	int partition(int st, int end) {
		int largerElemIndex = st;
		int piv = arr[end];

		for (int i = st; i < end; i++) {
			if (arr[i] < piv ) {
				swap(i, largerElemIndex);
				largerElemIndex++;
			}
		}
			swap(largerElemIndex, end);

		return largerElemIndex; // piv is the largest of all

	}

	private void swap(int i, int j) {
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}

}
