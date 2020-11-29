class Solution {
    public int subtractProductAndSum(int n) { // 234
    	if(n == 0) return 0;
    
    	int prod = 1;
    	int sum = 0;
    	int q = n, r = 1;
    	
    	while(q != 0) {
    		r = q % 10;
    		prod *= r;
    		sum += r; 
    		
    		q = q/10;
    	}
    	
    	return prod - sum;
    }
    
    
}