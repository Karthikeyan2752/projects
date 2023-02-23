package com.leetcodes2;

public class AddBinary {

	public static String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;

		String result = "";
		int carry = 0;
		while (i >= 0 && j >= 0) {
			// if(carry==2){
			// result+=1;
			// carry=1;
			// }
			if ((a.charAt(i) - '0' == 0) && (b.charAt(j) - '0' == 1) && carry == 1) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(i) - '0' == 0) && (b.charAt(j) - '0' == 1) && carry == 0) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(i) - '0' == 1) && (b.charAt(j) - '0' == 1) && carry == 1) {
				result += 1;
				carry = 1;
			} else if ((a.charAt(i) - '0' == 1) && (b.charAt(j) - '0' == 1) && carry == 0) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(i) - '0' == 0) && (b.charAt(j) - '0' == 0) && (carry == 1)) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(i) - '0' == 0) && (b.charAt(j) - '0' == 0) && (carry == 0)) {
				result += 0;
				carry = 0;
			}
			i--;
			j--;
		}
		while (i >= 0) {
			if ((a.charAt(i) - '0' == 0) && carry == 1) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(i) - '0' == 0) && carry == 0) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(i) - '0' == 1) && carry == 1) {
				result += "01";
				carry = 0;
			} else if ((a.charAt(i) - '0' == 1) && carry == 0) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(i) - '0' == 0) && (carry == 1)) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(i) - '0' == 0 && (carry == 0))) {
				result += 0;
				carry = 0;
			}
			i--;
		}
		while (j >= 0) {
			if ((a.charAt(j) - '0' == 0) && carry == 1) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(j) - '0' == 0) && carry == 0) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(j) - '0' == 1) && carry == 1) {
				result += "01";
				carry = 0;
			} else if ((a.charAt(j) - '0' == 1) && carry == 0) {
				result += 0;
				carry = 1;
			} else if ((a.charAt(j) - '0' == 0) && (carry == 1)) {
				result += 1;
				carry = 0;
			} else if ((a.charAt(j) - '0' == 0 && (carry == 0))) {
				result += 0;
				carry = 0;
			}
		}
		// result += carry;
		StringBuilder sb = new StringBuilder(result);
		return sb.reverse().toString();
	}
	public static void main(String[] args) {
		System.out.println(addBinary("11", "1"));

	}

}
