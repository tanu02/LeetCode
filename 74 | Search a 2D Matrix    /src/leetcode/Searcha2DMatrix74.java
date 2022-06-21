package leetcode;
//array is sorted row wise : mn is sorted start from 0 to mn
//Link: https://leetcode.com/problems/search-a-2d-matrix/
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