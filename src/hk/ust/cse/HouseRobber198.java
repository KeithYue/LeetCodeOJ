package hk.ust.cse;

public class HouseRobber198 {
	public static void main(String [] args){
		int [] a = {100, 1, 1, 100};
		HouseRobber198 h =  new HouseRobber198();
		System.out.println(h.rob(a));
	}
	public int rob(int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
    	int [] max  = new int [nums.length+1];
    	max[0] = 0;
    	
    	
    	for(int i = 1;i<nums.length+1;i++){
    		if(i==1){
    			max[i] = nums[i-1];
    		}else{
    			max[i] = max2(nums[i-1] + max[i-2], max[i-1]);
    		}
    		// System.out.println(max[i]);
    	}
    	
    	return max[nums.length];
    }

	public int max2(int a, int b) {
		return (a > b) ? a : b;
	}
}
