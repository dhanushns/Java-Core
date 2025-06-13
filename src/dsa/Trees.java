package dsa;

import java.util.List;
import java.util.ArrayList;

public class Trees {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.inOrder(root);
		System.out.println();
		root.postOrder(root);
		System.out.println();
		root.preOrder(root);
		System.out.println();
		List<List<Integer>> res = new ArrayList<>();
		root.levelOrder(root, 0, res);
		System.out.println(res);
		
	}
	
	
}
