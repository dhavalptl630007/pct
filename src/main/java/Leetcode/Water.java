package Leetcode;

import java.util.Arrays;

public class Water {

	public static void main(String[] args) {

		int[] arr = { 6320 ,6020, 6098, 1332, 7263, 672, 9472, 2838, 3401, 9494};

		int maxArea = 0;

		int minHeight = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int pos = 0;
			minHeight = Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {

				if (minHeight >= arr[j]) {
					minHeight = arr[j];
					pos = j;
				}

			}

			int k = 1;
			for (int j = pos; j < arr.length; j++) {

				maxArea = Math.max(maxArea, minHeight * k);

				k++;

			}

		}

		for (int i = arr.length - 1; i >= 0; i--) {
			int pos = arr.length - 1;
			minHeight = Integer.MAX_VALUE;
			for (int j = i; j >= 0; j--) {

				if (minHeight > arr[j]) {
					minHeight = arr[j];
					pos = j;
				}

			}

			int k = 1;
			for (int j = pos; j >= 0; j--) {

				maxArea = Math.max(maxArea, minHeight * k);

				k++;

			}

		}

		System.out.println(maxArea);

	}

}
