
class Solution {

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