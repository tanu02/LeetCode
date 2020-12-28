import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0) return new ArrayList<>();

        int st = binarySearch(0, arr.length - k, arr, x, k); // (arr.length - 1) - (k -1)
        return Arrays.stream(arr, st, st + k).boxed().collect(Collectors.toList());
    }

    private int binarySearch(int st, int end, int[] arr, int target, int k) {
        if (st >= end) return st;
        int mid = st + (end - st) / 2;
        if (arr[mid + k] - target < target - arr[mid]) //compare element just after your window
            return binarySearch(mid + 1, end, arr, target, k);
        return binarySearch(st, mid, arr, target, k);
    }
}