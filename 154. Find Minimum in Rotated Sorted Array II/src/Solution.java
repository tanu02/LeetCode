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


