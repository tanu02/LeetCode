package leetcode;

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        return binarySearch(0, x / 2, x);
    }

    private int binarySearch(int st, int end, long target) {
        if (st + 1 == end) {
            if (target >= (long) end * end) return end;
            return st;
        }

        int mid = st + (end - st) / 2;
        if (target > (long) mid * mid) return binarySearch(mid, end, target);
        return binarySearch(st, mid, target);
    }

}