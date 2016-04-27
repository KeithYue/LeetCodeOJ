package hk.ust.cse;

public class FindtheDuplicateNumber287 {
	public static void main(String [] args){
		int a []  = {3,4,1,7,8,2};
		FindtheDuplicateNumber287 f  = new FindtheDuplicateNumber287();
		f.quickSort(a, 0, a.length-1);
		for(int i =0;i<a.length;i++){
			System.out.println(a[i]);
		}
	}
    public int findDuplicate(int[] nums) {
    	if(nums.length>0){
    		quickSort(nums, 0, nums.length-1);
    		int i;
    		for(i =0;i<nums.length-1;i++){
    			if(nums[i] == nums[i+1]){
    				break;
    			}
    		}
    		return nums[i];
    	}else{
    		return 0;
    	}
    }
    public void quickSort(int [] nums, int low, int high){
    	if(low < high){
    		int p = partition(nums, low, high);
    		quickSort(nums, low, p-1);
    		quickSort(nums, p+1, high);
    	}
    }
    public int partition(int [] nums, int low, int high){
    	int pivot = nums[high];
    	int i = low;
    	for(int j = low;j<high;j++){
    		if(nums[j] < pivot){
    			int tmp = nums[j];
    			nums[j] = nums[i];
    			nums[i] = tmp;
    			i = i+1;
    		}
    	}
    	
    	nums[high] = nums[i];
    	nums[i] = pivot;
    	
    	return i;
    }
}
