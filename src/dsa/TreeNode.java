package dsa;

import java.util.List;
import java.util.ArrayList;

public class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int data){
		
		this.data = data;
		this.left = this.right = null;
		
	}
	
	TreeNode(int data, TreeNode left, TreeNode right){
		
		this.data = data;
		this.left = left;
		this.right = right;
		
	}
	
	TreeNode(){}
	
	public void inOrder(TreeNode node) {
		
		if(node == null) return;
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	public void postOrder(TreeNode node) {
		
		if(node == null) return;
		
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
		
	}
	
	public void preOrder(TreeNode node) {
		
		if(node == null) return;
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
		
	}
	
	public void levelOrder(TreeNode node, int level, List<List<Integer>> res){
		
		if(node == null) return;
		
		if(res.size() <= level) res.add(new ArrayList<Integer>());
		
		res.get(level).add(node.data);
		
		levelOrder(node.left, level + 1, res);
		levelOrder(node.right, level + 1, res);
		
		
	}
	
}
