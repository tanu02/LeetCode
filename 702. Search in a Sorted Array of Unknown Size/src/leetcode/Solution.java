package leetcode;


class Solution {
    int deadEnd = 2147483647;

    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == deadEnd) return -1;

        int end = findLastIndexGivenUniqueElements(target, reader);

        return binarySearch(0, end, target, reader);
    }

    private int binarySearch(int st, int end, int target, ArrayReader reader) {
        if (st == end) {
            if (target == reader.get(st)) return st;
            return -1;
        }
        int mid = st + (end - st) / 2;
        if (target > reader.get(mid)) return binarySearch(mid + 1, end, target, reader);
        return binarySearch(st, mid, target, reader);
    }

    private int findLastIndexMultiplesOf2(int target, ArrayReader reader) {
        int right = 1;
        while (reader.get(right) != deadEnd && target > reader.get(right)) {
            right *= 2;
        }
        return right;
    }

    private int findLastIndexGivenUniqueElements(int target, ArrayReader reader) {
        return target - reader.get(0);
    }
}