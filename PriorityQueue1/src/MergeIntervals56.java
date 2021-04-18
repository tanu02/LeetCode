//56. Merge Intervals
//        https://leetcode.com/problems/merge-intervals/solution/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Stream;

public class MergeIntervals56 {
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

class Main6 {
    public static void main(String args[]) {
        MergeIntervals56 sol = new MergeIntervals56();
        int[][] arr = {{0, 30}, {30, 100}, {100, 200}}; //3
        int[][] arr1 = {{0, 100}, {20, 50}, {80, 90}}; //2 {20, 50}, {80, 90} will share 1
        int[][] arr2 = {{0, 50}, {40, 80}, {70, 100}}; //{0, 50}, {70, 100} will share 1
        int[][] arr4 = {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals1 = {{1,4},{4,5}};
        int[][] intervals2 = {{2,3},{4,5},{6,7},{8,9},{1,10}};

//        System.out.println(sol.minMeetingRooms(arr));
//        System.out.println(sol.minMeetingRooms(arr1));
//        System.out.println(sol.minMeetingRooms(arr2));
        Stream.of(sol.merge(intervals2)).
                forEach(int1 -> System.out.println(Arrays.toString(int1)));
    }
}
