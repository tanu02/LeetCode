//252. Meeting Rooms
//https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;
import java.util.stream.Stream;

public class MeetingRooms252 {
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

class Main {
    public static void main(String args[]) {
        MeetingRooms252 sol = new MeetingRooms252();
        int[][] arr = {{0, 30}, {30, 100}, {100, 200}};
        int[][] arr1 = {{0, 100}, {20, 50}, {60, 80}};

        System.out.println(sol.canAttendMeetings(arr1));
    }
}

