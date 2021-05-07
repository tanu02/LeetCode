
public class Main {

	public static void main(String[] args) {
		SearchinRotatedSortedArray33 sol = new SearchinRotatedSortedArray33();

		int[] nums = {4,5,6,7,0,1,2};
		int target = 0;
		int target2 = 3;

		int[] nums1 = {1};
		int target1 = 0;

		System.out.println(sol.search(nums, target));
		System.out.println(sol.search(nums, target2));
		System.out.println(sol.search(nums1, target1));
	}

}
