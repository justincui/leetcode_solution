package no865_Smallest_Subtree_with_all_the_Deepest_Nodes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.Test;

class SolutionTest {

	private TreeNode createTree(Integer... input) throws Exception {
		if(input.length==0) {
			return null;
		}
		TreeNode root=new TreeNode(input[0]);
		Queue<TreeNode> pending = new LinkedList<>();
		pending.add(root);
		for(int i=1; i<input.length; i++) {
			TreeNode node = pending.element();
			if(i%2==1) { //value for left child
				if(input[i]!=null) {
					if(node==null) {
						throw new Exception("invalid input: ["+i+"](value:"+input[i]+"), whose parent is null.");
					}
					node.left = new TreeNode(input[i]);
				}
				pending.add(node.left);
			}
			else { //value for right child
				if(input[i]!=null) {
					if(node==null) {
						throw new Exception("invalid input: ["+i+"](value:"+input[i]+"), whose parent is null.");
					}
					node.right = new TreeNode(input[i]);
				}
				pending.add(node.right);
				pending.remove(); //remove fully populated parent node.
			}
		}
		return root;
	}
	

	@Test
	void test() throws Exception {
		Solution s = new Solution();
		
		TreeNode root = createTree(3,5,1,6,2,0,8,null,null,7,4);
		TreeNode result = s.subtreeWithAllDeepest(root);
		assertEquals("2, 7, 4", result.toString());
	}

}
