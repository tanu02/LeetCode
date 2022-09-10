package prepare.heap;


import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementStream703 {
    Queue<Integer> q;
    int k;

    public KthLargestElementStream703(int k, int[] nums) {
        q = new PriorityQueue<>();
        k = k;
        for(int elem : nums){
            q.add(elem);
        }
    }

    public int add(int val) {
        int count = 0;
        while(count < k && !q.isEmpty()){
            int elem = q.poll();
            if(count == k) return elem;
        }
        return -1;
    }
}
