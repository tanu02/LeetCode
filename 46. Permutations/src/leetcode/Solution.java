package leetcode;

class Solution {
	int[] nums; 
	int[] dp; 
	public boolean canJump(int[] nums) {

		if (nums == null || nums.length == 0) return false;
		if(nums.length == 1) return true; //1 length  
			
		this.nums = nums;
		dp = new int[nums.length]; 
		
		for (int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == 0)	return false; 
			
			if (checkPath(i) == 2)
				return true;
		}
		return false;

	}

	private int checkPath(int i) {
		if(i == nums.length - 1) return 2;		// +ve destination	 
		
		if(nums[i] == 0 || dp[i] == 1) return 1; //either blocker (0) or
												// already processed and no path
		
		int maxJump = Math.min(i + nums[i], nums.length - 1); 
			for(int j = i + 1; j <= maxJump; j++) {
				if(checkPath(j) == 2) {
					dp[i] = 2; return 2; 
				} 
			}
			dp[i] = 1; 
			return 1; 
	}
}