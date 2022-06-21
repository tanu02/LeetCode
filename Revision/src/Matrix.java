public class Matrix {
}
//Link: https://leetcode.com/problems/search-a-2d-matrix/
//DS.Array is sorted row wise and col wise
class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        int i = matrix.length - 1; //left bottom corner
        int j = 0;
        int col = matrix[0].length;

        while (i >= 0 && j < col) {

            if (target > matrix[i][j])
                j++;
            else if (target < matrix[i][j])
                i--;
            else if (target == matrix[i][j])
                return true; 				 //1 out of 10 positions will be k rest 9 will be either < or >
            //why check equal in 90% of cases
        }
        return false;

    }
}

//array is sorted row wise : mn is sorted start from 0 to mn
class Searcha2DMatrix74 {
    int row = 0;
    int col = 0;
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;

        this.row = matrix.length;
        this.col = matrix[0].length;

        return search(matrix, 0, row*col - 1, target);

    }

    private boolean search(int[][] arr, int st, int end, int target) {

        if(st > end) return false;
        int mid = st + (end - st)/2;
        int i = mid/col;
        int j = mid%col;

        if(target == arr[i][j]) return true;
        else if(target < arr[i][j])
            return search(arr, st, mid - 1, target);
        else
            return search(arr, mid + 1, end, target);

    }
}
