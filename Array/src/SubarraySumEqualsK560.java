import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/

public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1); //0 to ith index whole array's sum equals k, 0 is a notch to extract subarray
        int count = 0;      //now that index could be the first element as well
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            if (prefixMap.containsKey(currSum - k)) count += prefixMap.get(currSum - k);
            prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}

class Main {
    public static void main(String args[]) {
        SubarraySumEqualsK560 sol = new SubarraySumEqualsK560();
        int[] nums = {1, 1, 1};
        int k = 2;
        int[] nums1 = {4, 3, 4, 7};
        int k1 = 7;

        int[] num2 = {1, -1, 0};
        int k2 = 0;
        System.out.println(sol.subarraySum(nums, k));
        System.out.println(sol.subarraySum(nums1, k1));
        System.out.println(sol.subarraySum(num2, k2));

    }
}