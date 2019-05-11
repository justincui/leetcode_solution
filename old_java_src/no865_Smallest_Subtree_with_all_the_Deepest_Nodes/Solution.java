package no865_Smallest_Subtree_with_all_the_Deepest_Nodes;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	class SubResult{
		TreeNode node;
		int depth; //depth of the deepest child
		
		public SubResult(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
	/*
	 * get the result of a subtree
	 */
	SubResult getSubResult(TreeNode subroot, int curDepth) {
		if(subroot==null) {
			return null;
		}
		//leaf node
		if(subroot.left==null && subroot.right==null) {
			return new SubResult(subroot, curDepth);
		}
		
		//branch node
		SubResult left= getSubResult(subroot.left, curDepth+1);
		SubResult right= getSubResult(subroot.right, curDepth+1);
		if(left==null) {
			return right;
		}
		else if(right==null) {
			return left;
		}
		else if(left.depth>right.depth){
			return left;
		}
		else if(left.depth<right.depth) {
			return right;
		}
		else { //left.depth == right.depth
			return new SubResult(subroot, left.depth);
		}
	}
	
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return getSubResult(root, 0).node;
    }
}