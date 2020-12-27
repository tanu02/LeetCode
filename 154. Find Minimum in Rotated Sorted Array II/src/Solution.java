class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        return binarySearch(0, nums.length - 1, nums);

    }

    private int binarySearch(int st, int end, int[] nums) {
        if (st == end) return nums[st];

        int mid = st + (end - st) / 2;

        if (nums[mid] == nums[end]) return binarySearch(st, end - 1, nums);

        if (nums[mid] > nums[end]) return binarySearch(mid + 1, end, nums);

        return binarySearch(st, mid, nums);
    }
}