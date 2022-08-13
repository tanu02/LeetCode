import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution2 {

    public boolean canJump(int[] nums) {//[2,3,1,1,4]
        if (nums == null) return true;

        int length = nums.length;
        int visited[] = new int[nums.length];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (index == length - 1) return true; //jumps is hops b/w dst and src

                if (visited[index] != -1) continue;//visited continue
                visited[index] = 1;

                for (int j = 1; j <= nums[index]; j++) { //neighbors
                    int next = index + j;
                    if (next < length && visited[next] == -1)
                        queue.offer(next);  //every element can max n-1 Child elements at a time queue can have n2 elements
                }
            }
        }
        return false;
    }
}
