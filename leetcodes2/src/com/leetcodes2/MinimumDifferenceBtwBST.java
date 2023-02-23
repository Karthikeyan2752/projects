package com.leetcodes2;

public class MinimumDifferenceBtwBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	int min = Integer.MAX_VALUE;
	TreeNode prev = null;

	public int minDiffInBST(TreeNode root) {
		helper(root);
		return min;
	}

	public void helper(TreeNode root) {
		if (root == null) {
			return;
		}

		helper(root.left);

		if (prev != null) {
			min = Math.min(min, root.val - prev.val);
		}
		prev = root;

		helper(root.right);
	}

	public static void main(String[] args) {

	}

}
