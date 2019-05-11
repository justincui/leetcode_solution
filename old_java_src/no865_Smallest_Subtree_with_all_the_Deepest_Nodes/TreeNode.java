package no865_Smallest_Subtree_with_all_the_Deepest_Nodes;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
	int val;
	TreeNode left=null;
	TreeNode right=null;

	TreeNode(int x) {
		val = x;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(val);
		if (left != null || right != null) {
			s.append(", ");
			s.append(left == null ? "null" : left.toString());
			s.append(", ");
			s.append(right == null ? "null" : right.toString());
		}
		return s.toString();
	}
}
