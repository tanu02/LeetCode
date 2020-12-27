

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;

        int[] nums2 = { 5, 7, 7, 8, 8, 10};
    	int target2 = 6;

        int[] nums3 = {};
        int target3 = 0;

        int[] nums4 = {1,2,2};
        int target4 = 2;

        int[] nums5 = {2,2,3};
        int target5 = 2;

//        printOutput(sol.searchRange(nums, target));//[3,4]
//        printOutput(sol.searchRange(nums2, target2));
//        printOutput(sol.searchRange(nums3, target3));
       // printOutput(sol.searchRange(nums4 , target4));
        printOutput(sol.searchRange(nums5 , target5));
    }

    private static void printOutput(int[] arr){
        for(int val : arr){
            System.out.print(val + "\t");
        }
        System.out.println();
    }

}
