import java.util.LinkedList;
import java.util.*;
import java.util.stream.Stream;

public class PriorityQueue {
}

class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 0)
            return new int[0];

        int[] outputArr = new int[k];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Queue<Integer> topKQueue = new java.util.PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for (Integer elem : frequencyMap.keySet()) {
            if (topKQueue.size() < k)  //keep piling till k size
                topKQueue.offer(elem);

            else if (frequencyMap.get(elem) > frequencyMap.get(topKQueue.peek())) {
                topKQueue.poll();        //current elem has to be greater than smallest elem in queue
                topKQueue.add(elem);
            }

        }

        for (int i = k - 1; i >= 0; i--) {   //queue has [0, 5, 10]
            outputArr[i] = topKQueue.poll(); //output is in descending order [10 5 0]
        }
        return outputArr;

    }
}


class MergeIntervals56 {
    int start = 0;
    int end = 1;

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return new int[0][0];

        Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[start], int2[start]));
        //  Stream.of(intervals).forEach(int1 -> System.out.println(Arrays.toString(int1)));

        LinkedList<int[]> outputList = new LinkedList<>();
        outputList.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][start] <= outputList.getLast()[end]) { //overlap
                int[] lastInterval = outputList.removeLast(); //get last entry
                lastInterval[end] = Math.max(lastInterval[end], intervals[i][end]); //sorted array --i's start will be >= i-1 start
                outputList.add(lastInterval);
            } else {
                outputList.add(intervals[i]);
            }

        }
        return outputList.toArray(new int[outputList.size()][]);
    }
}


class MeetingRoomsII {
    int start = 0;
    int end = 1;

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;

        // Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[start], int2[start]));
        Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[end], int2[end]));
        Stream.of(intervals).forEach(int3 -> System.out.println(Arrays.toString(int3)));
        Queue<Integer> queue = new java.util.PriorityQueue<>((end1, end2) -> Integer.compare(end1, end2));

        queue.add(intervals[0][end]); //push earliest completion time [as the array is sorted]

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][start] >= queue.peek()) {
                queue.poll();//non overlapping existing room
            }

            queue.add(intervals[i][end]); //insert current room
        }
        return queue.size();
    }
}

class MeetingRooms252 {
    int start = 0;
    int end = 1;

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return true;

        Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[end], int2[end]));
        //Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[start], int2[start])); //won't matter if it is start or end as we dont need info about more than 1 hop unlike meeting room2
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][start] < intervals[i - 1][end]) return false;
        }
        return true;
    }
}


class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length == 0 || points[0].length == 0) return new int[][]{};
        findKClosest(0, points.length - 1, K, points);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void findKClosest(int st, int end, int k, int[][] arr) {
        if (st >= end) return;
        int part = partition(st, end, arr);

        if (k < part) findKClosest(st, part - 1, k, arr);
        else if (k > part) findKClosest(part + 1, end, k, arr);

    }

    private int partition(int st, int end, int[][] arr) {
        int[] pivVal = arr[end];
        int j = st;

        for (int i = st; i < end; i++) {
            if (dist(arr[i]) < dist(pivVal)) swap(i, j++, arr);
        }
        swap(j, end, arr);
        return j;
    }

    private void swap(int i, int j, int[][] arr) {
        int[] temp = {arr[j][0], arr[j][1]};

        arr[j][0] = arr[i][0];
        arr[j][1] = arr[i][1];
        arr[i][0] = temp[0];
        arr[i][1] = temp[1];

    }

    private int dist(int[] coordinates) {

        return coordinates[0] * coordinates[0] + coordinates[1] * coordinates[1];
    }

}