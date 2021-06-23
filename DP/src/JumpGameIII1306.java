import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class JumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        if (arr == null) return true;

        int length = arr.length;
        int visited[] = new int[arr.length];
        Arrays.fill(visited, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                if (arr[index] == 0) return true; //jumps is hops b/w dst and src

                if (visited[index] != -1) continue;//visited continue
                visited[index] = 1;

                int left = index - arr[index];
                int right = index + arr[index];

                if (left >= 0 && visited[left] == -1)
                    queue.offer(left);  //every element can max n-1 Child elements at a time queue can have n2 elements
                if (right < length && visited[right] == -1)
                    queue.offer(right);
            }
        }
        return false;
    }
}