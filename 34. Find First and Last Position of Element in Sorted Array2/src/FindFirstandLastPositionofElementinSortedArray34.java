//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//34. Find First and Last Position of Element in Sorted Array
class FindFirstandLastPositionofElementinSortedArray34 {
    public int[] searchRange(int[] nums, int target) {

        if(nums == null || nums.length == 0 ) return new int[]{-1, -1};
        int right = -1;
        int left = binaryLeft(0, nums.length - 1, nums, target);
        if (left != -1) { //only if you find an entry
            right = binaryRight(0, nums.length - 1, nums, target);
        }
        return new int[]{left, right};
    }

    private int binaryLeft(int st, int end, int[] nums, int target) {
        if (st == end) {
            if (target == nums[st]) return st; //left most entry
            return -1;
        }
        int mid = st + (end - st) / 2;
        if (target > nums[mid]) return binaryLeft(mid + 1, end, nums, target);
        return binaryLeft(st, mid, nums, target);
    }

    private int binaryRight(int st, int end, int[] nums, int target) {
        if (st == end) { //if input array is of size 1 or  case 8 9 9 9 single occurence of target
            if (target == nums[st]) return st; //right most entry
            return -1;
        }
        if (st + 1 == end) {  //7 7 8 8 OR 7 8 8 8
                    if(nums[end] == target) return end;
                    return st;
        }

        int mid = st + (end - st)/2;
        if(target >= nums[mid]) return binaryRight(mid , end, nums, target);
        return binaryRight(st, mid - 1, nums, target);
    }

}