package hk.ust.cse;

public class SortColors75 {
	public static void main(String[] args) {
		int[] a = { 2, 2, 2, 0, 0, 0 };
		SortColors75 f = new SortColors75();
		f.sortColors(a);
	}

	public void sortColors(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return;
		}
		int[] tmp = new int[3];
		for (int i = 0; i < nums.length; i++) {
			tmp[nums[i]]++;
		}

		for (int i = 0; i < tmp.length; i++) {
			System.out.println(tmp[i]);
		}

		int j = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int k = 0; k < tmp[i]; k++) {
				nums[j] = i;
				j++;
			}
		}

		// for(int i = 0;i<nums.length;i++){
		// System.out.println(nums[i]);
		// }
	}
}
