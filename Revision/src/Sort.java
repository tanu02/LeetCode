public class Sort {
}


class QuickSort {

    public int[] sortArray(int[] nums) {
        sort(0, nums.length - 1, nums);
        return nums;
    }

    void sort(int st, int end, int[] arr) {
        if (st > end) return;

        int part = partition(st, end, arr);
        sort(st, part - 1, arr);
        sort(part + 1, end, arr);
    }

    int partition(int st, int end, int[] arr) {
        int pivotVal = arr[end];
        int j = st;

        for (int i = st; i < end; i++) {        //process elements before pivot
            if (arr[i] < pivotVal) swap(i, j++, arr);// left has < right has >=
        }

        swap(j, end, arr); //swap pivot
        return j;
    }

    private void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}


