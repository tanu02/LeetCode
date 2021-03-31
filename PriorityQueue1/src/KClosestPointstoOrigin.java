import java.util.Arrays;

class KClosestPointstoOrigin {

    public int[][] kClosest(int[][] points, int K) {

        if (points == null || points.length == 0 || points[0].length == 0) return new int[][]{};
        findKClosest(0, points.length - 1, K, points);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void findKClosest(int st, int end, int k, int[][] arr) {
        if (st >= end) return;
        int part = partition(st, end, arr);

        if (k < part) findKClosest(st, part - 1, k, arr);
        else if (k > part) findKClosest(part + 1, end, k, arr);

    }

    private int partition(int st, int end, int[][] arr) {
        int[] pivVal = arr[end];
        int j = st;

        for (int i = st; i < end; i++) {
            if (dist(arr[i]) <= dist(pivVal)) swap(i, j++, arr);
        }
        swap(j, end, arr);
        return j;
    }

    private void swap(int i, int j, int[][] arr) {
        int[] temp = {arr[j][0], arr[j][1]};

        arr[j][0] = arr[i][0];
        arr[j][1] = arr[i][1];
        arr[i][0] = temp[0];
        arr[i][1] = temp[1];

    }

    private int dist(int[] coordinates) {

        return coordinates[0] * coordinates[0] + coordinates[1] * coordinates[1];
    }

}