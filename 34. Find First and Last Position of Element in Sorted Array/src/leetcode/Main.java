

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] nums2 = { 5, 7, 7, 8, 8, 10};
    	int target2 = 6;

        int[] nums3 = {};
        int target3 = 0;

        System.out.println(sol.search(nums, target));
        System.out.println(sol.search(nums2, target2));
        System.out.println(sol.search(nums3, target3));
    }

}
