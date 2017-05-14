package hk.ust.cse;

import java.util.ArrayList;
import java.util.List;

public class FindKPairswithSmallestSums373 {
	public static void main(String[] args) {
		FindKPairswithSmallestSums373 f = new FindKPairswithSmallestSums373();
		int[] a = { 1, 1, 2 };
		int[] b = { 1, 2, 3 };
		f.kSmallestPairs(a, b, 10);
	}

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> result = new ArrayList<int[]>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) {
			return result;
		}
		int i = 0, j = 0;
		while (i < nums1.length && j < nums1.length) {
			if (result.size() == k) {
				break;
			} else {
				int[] a = { nums1[i], nums2[j] };
				result.add(a);
				if (i == nums1.length - 1 && j == nums2.length - 1) {
					break;
				} else if (i == nums1.length - 1 && j < nums2.length - 1) {
					j++;
				} else if (i < nums1.length - 1 && j == nums2.length - 1) {
					i++;
				} else {
					if (nums1[i + 1] < nums2[j + 1]) {
						i++;
					} else {
						j++;
					}
				}
			}
		}
		// print array
		for (i = 0; i < result.size(); i++) {
			int[] b = result.get(i);
			for (j = 0; j < 2; j++) {
				System.out.print(b[j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		return result;
	}
}
