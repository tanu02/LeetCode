public class BinarySearch {
}

class PeakElement162 {

    public int findPeakElement(int[] arr) {
        return findPeak(0, arr.length - 1, arr);

    }

    private int findPeak(int st, int end, int[] arr) {
        if (st == end)
            return st;
        int mid = st + (end - st) / 2;

        if (arr[mid + 1] > arr[mid])
            return findPeak(mid + 1, end, arr);

        return findPeak(st, mid, arr);

    }
}


class SearchinRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int inflect = findInflect(nums, 0, nums.length - 1);

        if (inflect == 0) return binarySearch(nums, 0, nums.length - 1, target);

        else if (target >= nums[0]) return binarySearch(nums, 0, inflect - 1, target);

        return binarySearch(nums, inflect, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int st, int end, int target) {
        if (st == end) {
            if(nums[st] == target) return st;
            return -1;
        }
        int mid = st + (end - st) / 2;
        if (target > nums[mid]) return binarySearch(nums, mid + 1, end, target);
        return binarySearch(nums, st, mid, target);
    }

    private int findInflect(int[] nums, int st, int end) {
        if (st == end) return st;
        int mid = st + (end - st) / 2;
        if (nums[end] < nums[mid] ) return findInflect(nums, mid + 1, end);
        return findInflect(nums, st, mid);
    }
}

// 1 2 3 4              inflect = 1 [search from 0 to len-1]
// 3 4 1 2              inflect = 1 [either search from (0 , inflect -1) or (inflect, len-1)]


class FindMinimuminRotatedSortedArrayII154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(0, nums.length - 1, nums);

    }

    private int binarySearch(int st, int end, int[] nums) {
        if (st == end) return nums[st];

        int mid = st + (end - st) / 2;

        if (nums[end] == nums[mid]) return binarySearch(st, end - 1, nums);

        if (nums[end] < nums[mid]) return binarySearch(mid + 1, end, nums);

        return binarySearch(st, mid, nums);
    }
}
// 1 2 3 4          min = 1        4 > 2 move left (normal array as expected in a sorted array)
// 4 5 6 7 1 2 3    min = 1        3 < 7 move right  ( all the rotated elements will  be  < than mid )
// 1 3 3            min = 1        3 = 3 min is in left side
// 3 3 1            min = 1        3 = 3 min is in right side
//special handling for duplicate to move left by 1 step i.e just get rid of end element.


