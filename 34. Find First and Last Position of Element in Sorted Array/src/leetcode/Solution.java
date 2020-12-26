class Solution {
    public int[] searchRange(int[] nums, int target) {

        int left = -1, right = -1;
        left = binaryLeft(0, nums.length - 1, nums, target);
        if (left != -1) binaryRight(0, nums.length - 1);
        return new int[]{left, right};
    }

    private int binaryLeft(int st, int end, int[] nums, int target) {
        if(st == end) {
            if(target == nums[st]) return st;
            return -1;
        }
        int mid = st + (end - st)/2;
        if(target > mid) return binaryLeft(mid + 1, end, nums, target);
        return binaryLeft(st, mid, nums, target);
    }

    private int binaryRight(int st, int end, int[] nums, int target){
        if(st == end) {
            if(target == nums[st]) return st;
            return -1;
        }
        if(st + 1 == end){
            
        }
    }
}