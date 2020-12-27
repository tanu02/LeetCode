class Solution {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0 ) return new int[]{-1, -1};
        int left = -1, right = -1;
        left = binaryLeft(0, nums.length - 1, nums, target);
        if (left != -1) {
            right = binaryRight(0, nums.length - 1, nums, target);
        }
        return new int[]{left, right};
    }

    private int binaryLeft(int st, int end, int[] nums, int target) {
        if (st == end) {
            if (target == nums[st]) return st;
            return -1;
        }
        int mid = st + (end - st) / 2;
        if (target > nums[mid]) return binaryLeft(mid + 1, end, nums, target);
        return binaryLeft(st, mid, nums, target);
    }

    private int binaryRight(int st, int end, int[] nums, int target) {
        if (st == end) {
            if (target == nums[st]) return st;
            return -1;
        }
        if (st + 1 == end) {
                    if(nums[end] == target) return end;
                    return st;
        }

        int mid = st + (end - st)/2;
        if(target >= nums[mid]) return binaryRight(mid , end, nums, target);
        return binaryRight(st, mid - 1, nums, target);
    }
}