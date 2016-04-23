package hk.ust.cse;

public class LongestIncreasingPathinaMatrix329 {
	public static void main(String [] args){
		int [][] m = {
				{9,9,4},
				{6,6,8},
				{2,1,1}
		};
		int r = (new LongestIncreasingPathinaMatrix329()).longestIncreasingPath(m);
		System.out.println(r);
	}
	public int longestIncreasingPath(int[][] matrix) {
		if (matrix.length < 1) {
			return 0;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;
		int[][] finished = new int[rows][columns]; // 0 means not finished
		int[][] longest = new int[rows][columns]; // the longest path starting
													// this node
		// initial
		int max_value = Integer.MIN_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				longest[i][j] = 1;
				finished[i][j] = 0;
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				int a = longestP(matrix, finished, longest, i, j);
				max_value = max(max_value, a);
			}
		}
		return max_value;
	}

	public int longestP(int[][] matrix, int[][] finished, int[][] longest,
			int i, int j) {
		// return the longest path starting from i,j
		// System.out.println(i + ", " + j);
		if (finished[i][j] == 1) {
			return longest[i][j];
		}
		int up = -1, down = -1, right = -1, left = -1;
		int current = matrix[i][j];
		if (i > 0) {
			if (current < matrix[i - 1][j]) {
				up = longestP(matrix, finished, longest, i - 1, j) + 1;
			}
		}
		if (i < matrix.length - 1) {
			if (current < matrix[i + 1][j]) {
				down = longestP(matrix, finished, longest, i + 1, j) + 1;
			}
		}
		if (j > 0) {
			if (current < matrix[i][j - 1]) {
				left = longestP(matrix, finished, longest, i, j - 1) + 1;
			}
		}
		if (j < matrix[0].length - 1) {
			if (current < matrix[i][j + 1]) {
				right = longestP(matrix, finished, longest, i, j + 1) + 1;
			}
		}
		int maxvalue = max(longest[i][j], max(up, max(down, max(left, right))));
		longest[i][j] = maxvalue;
		finished[i][j] = 1;
		return maxvalue;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

}
