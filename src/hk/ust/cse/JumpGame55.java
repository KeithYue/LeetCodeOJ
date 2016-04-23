package hk.ust.cse;

public class JumpGame55 {
	public static void main(String[] args) {
		int[] a = { 2,3,1,1,4};
		int[] b = { 3, 2, 1, 0, 4 };
		JumpGame55 j = new JumpGame55();
		System.out.println(j.canJump(a));
		System.out.println(j.canJump(b));
	}

	public boolean canJump(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		int[] can = new int[nums.length];
		int nearest = can.length - 1;
		can[nearest] = 1;

		int i = nums.length - 1;
		while (i >=0) {
			if (i + nums[i] >= nearest) {
				can[i] = 1;
				nearest = i;
			}else{
				can[i] = 0;
			}
			i--;
		}
		// for(int k=0;k<can.length;k++){
		// 	System.out.println(can[k]);
		// }
		if (can[0] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public int canJump(int[] nums, int[][] can, int i, int j) {
		// judeg whether can jump from i to j
		// -1: not set
		// 0: false
		// 1: true
		if (can[i][j] != -1) {
			return can[i][j];
		} else {
			int k = j;
			while (k > i) {
				k = k - 1;
				if (canJump(nums, can, i, k) == 1 && nums[k] >= j - k) {
					// System.out.println("I am here");
					can[i][j] = 1;
					return can[i][j];
				}
			}
			can[i][j] = 0;
			return can[i][j];

		}
	}
}
