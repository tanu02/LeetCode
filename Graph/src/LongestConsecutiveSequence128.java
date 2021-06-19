import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int elem : nums) {
            set.add(elem);

        }
        int maxLength = 0;
        for (int num : nums) {
            int count = 0;
            int currElem = num;

            if (!set.contains(currElem - 1)) {  // 3 2 1 4 -> skip 3, skip 2
                while (set.contains(currElem)) { //  start from 1 till 4	-> 1 2 3 4
                    count++;
                    currElem++;
                }

            }

            maxLength = Math.max(maxLength, count);

        }
        return maxLength;
    }
}

class Main5{
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 0, -1};
        int[] nums1 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}; //9
        LongestConsecutiveSequence128 sol  = new LongestConsecutiveSequence128();
        System.out.println(sol.longestConsecutive(nums));
        System.out.println(sol.longestConsecutive(nums1));

    }
}

