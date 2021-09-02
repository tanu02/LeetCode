public class Merge {

    public int[] sortArray(int[] nums) {
        if(nums == null || nums.length < 2) return nums;
        sort(0, nums.length - 1, nums);

    }

    private void sort(int st, int end, int[] arr) {
        if(arr == null || arr.length < 2) return nums;
        if(st > end) return;
        int mid = st + (end - st)/2;
        int[] arr1 = sort(st, mid, arr);
        int[] arr2 = sort(mid + 1, end, arr);

        combine(st, end, )
    }
}
