//253. Meeting Rooms II
//
//        https://leetcode.com/problems/meeting-rooms-ii/


import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class MeetingRoomsII {
    int start = 0;
    int end = 1;

    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) return 0;

      // Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[start], int2[start]));
        Arrays.sort(intervals, (int1, int2) -> Integer.compare(int1[end], int2[end]));
        Stream.of(intervals).forEach(int3 -> System.out.println(Arrays.toString(int3)));
        Queue<Integer> queue = new PriorityQueue<>((end1, end2) -> Integer.compare(end1, end2));

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

class Main5 {
    public static void main(String args[]) {
        MeetingRoomsII sol = new MeetingRoomsII();
        int[][] arr = {{0, 30}, {30, 100}, {100, 200}}; //3
        int[][] arr1 = {{0, 100}, {20, 50}, {80, 90}}; //2 {20, 50}, {80, 90} will share 1
        int[][] arr2 = {{0, 50}, {40, 80}, {70, 100}}; //{0, 50}, {70, 100} will share 1
        int[][] arr4 = {{2,15},{36,45},{9,29},{16,23},{4,9}};

//        System.out.println(sol.minMeetingRooms(arr));
//        System.out.println(sol.minMeetingRooms(arr1));
//        System.out.println(sol.minMeetingRooms(arr2));
        System.out.println(sol.minMeetingRooms(arr4));
    }
}