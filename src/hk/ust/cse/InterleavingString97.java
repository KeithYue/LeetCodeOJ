package hk.ust.cse;

public class InterleavingString97 {
	public static void main(String[] s) {
		InterleavingString97 i = new InterleavingString97();
		// System.out.println(i.isInterleave("ab", "bc","bbac"));
		System.out.println(i.isInterleave("db", "b", "cbb"));
		// System.out.println(i.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		if (l3 != l1 + l2) {
			return false;
		}

		int[][] match = new int[l1 + 1][l2 + 1];
		int rows = match.length;
		int columns = match[0].length;

		// initialize match matrix
		match[0][0] = 1;
		for (int j = 1; j < columns; j++) {
			char c2 = s2.charAt(j - 1);
			char c3 = s3.charAt(j - 1);
			if (match[0][j - 1] == 0) {
				match[0][j] = 0;
			} else {
				if (c2 == c3) {
					match[0][j] = 1;
				} else {
					match[0][j] = 0;
				}

			}
		}
		for (int i = 1; i < rows; i++) {
			char c1 = s1.charAt(i - 1);
			char c3 = s3.charAt(i - 1);
			if (match[i - 1][0] == 0) {
				match[i][0] = 0;
			} else {
				if (c1 == c3) {
					match[i][0] = 1;
				} else {
					match[i][0] = 0;
				}
			}
		}

		// do the dp
		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				char c1 = s1.charAt(i - 1);
				char c2 = s2.charAt(j - 1);
				char c3 = s3.charAt(i + j - 1);
				if (match[i - 1][j] == 0 && match[i][j - 1] == 0) {
					match[i][j] = 0;
				} else {
					if (c1 != c3 && c2 != c3) {
						match[i][j] = 0;
					} else if (c1 == c3 && c2 != c3) {
						if (match[i - 1][j] == 1) {
							match[i][j] = 1;
						} else {
							match[i][j] = 0;
						}
					} else if (c1 != c3 && c2 == c3) {
						if (match[i][j - 1] == 1) {
							match[i][j] = 1;
						} else {
							match[i][j] = 0;
						}
					} else if (c1 == c3 && c2 == c3) {
						match[i][j] = 1;
					} else {
						match[i][j] = 0;
					}

				}
			}
		}

		// for (int i = 0; i < rows; i++) {
		// 	for (int j = 0; j < columns; j++) {
		// 		System.out.println(i + "," + j + ":" + match[i][j]);
		// 	}
		// }

		if (match[s1.length()][s2.length()] == 1) {
			return true;
		} else {
			return false;
		}

	}

}
