package hk.ust.cse;

public class FirstMissingPositive41 {
	public static void main(String[] args) {
		FirstMissingPositive41 f = new FirstMissingPositive41();
		int[] a = { 1, 2, 0 };
		int[] b = { 3, 4, -1, 1 };
		int[] c = { 0 };
		System.out.println(f.firstMissingPositive(a));
		System.out.println(f.firstMissingPositive(b));
		System.out.println(f.firstMissingPositive(c));
	}

	public int firstMissingPositive(int[] nums) {
		// get max value of nums
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		if (max <= 0) {
			return 1;
		}
		// initialized with false
		// length is max+2 since first missing may be larger than max
		boolean[] positive = new boolean[max + 2];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				positive[nums[i]] = true;
			}
		}
		int missing = 0;
		for (int i = 1; i < positive.length; i++) {
			// System.out.println(i + ":" + positive[i]);
			if (positive[i] == false) {
				missing = i;
				break;
			}
		}
		return missing;
	}
}
