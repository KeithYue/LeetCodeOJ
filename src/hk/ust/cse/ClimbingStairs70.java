package hk.ust.cse;

public class ClimbingStairs70 {
    public int climbStairs(int n) {
    	if(n == 0){
    		return 0;
    	}
    	int [] r = new int [n+1];
    	r[0] = 1;
    	r[1] = 1;
    	for(int i =2;i<r.length;i++){
    		r[i] = r[i-1] + r[i-2];
    	}
    	return r[n];
    }
}
