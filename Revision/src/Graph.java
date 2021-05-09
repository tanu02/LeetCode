import java.util.HashSet;
import java.util.Set;

public class Graph {
}

//https://leetcode.com/problems/longest-consecutive-sequence/
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
//create a set of all the elements
//if arr[I] is the smallest element count the sequence[set does not contain smaller element than arr[I]]
//return max length