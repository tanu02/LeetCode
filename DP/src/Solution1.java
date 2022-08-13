/*
45. Jump Game II

https://leetcode.com/problems/jump-game-ii/
*/


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution1 {
    public int jump(int[] nums) {//[2,3,1,1,4]
        if (nums == null) return 0;

        int count = 0;
        int length = nums.length;
        int visited[] = new int[nums.length];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == length - 1) return count - 1; //jumps is hops b/w dst and src

                if (visited[index] != -1) continue;//visited continue
                visited[index] = 1;

                for (int j = 1; j <= nums[index]; j++) { //neighbors
                    int next = index + j;
                    if (next < length && visited[next] == -1)
                        queue.offer(next);  //every element can max n-1 Child elements at a time queue can have n2 elements
                }
            }
        }
        return 0;
    }
}

class Main00 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        int[] nums1 = {2, 3, 0, 1, 4};
        Solution1 sol = new Solution1();

        System.out.println(sol.jump(nums));//2
        System.out.println(sol.jump(nums1));//2
    }
}

