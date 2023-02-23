package com.leetcodes2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public List<Integer> spiralOrder(int[][] arr) {
		List<Integer> list = new ArrayList<>();
		int rowStart = 0, rowEnd = arr.length - 1, colStart = 0, colEnd = arr[0].length - 1;

		while (rowStart <= rowEnd && colStart <= colEnd) {

			// printing left to right
			for (int i = colStart; i <= colEnd; i++) {
				list.add(arr[rowStart][i]);
			}
			rowStart++;

			// printing top to bottom
			for (int i = rowStart; i <= rowEnd; i++) {
				list.add(arr[i][colEnd]);
			}
			colEnd--;

			// printing right to left
			if (rowStart <= rowEnd) {
				for (int i = colEnd; i >= colStart; i--) {
					list.add(arr[rowEnd][i]);
				}
				rowEnd--;
			}

			// printing bottom to top
			if (colStart <= colEnd) {
				for (int i = rowEnd; i >= rowStart; i--) {
					list.add(arr[i][colStart]);
				}
				colStart++;
			}
		}
		return list;
	}

	public static void main(String[] args) {


	}

}
