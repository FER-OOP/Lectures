package hr.fer.oop.recapitulation.tree;

public class BST {
	private IntNode root = null;
	private int size = 0;
	
	public int size() {
		return size;
	}

	public void add(int i) {		
		if (root == null) {
			root = new IntNode(i);
			++size;
		}
		else {
			IntNode node = root;			
			while(true) {
				if (node.value == i) break;
				else if (i < node.value) {
					if (node.left == null) {
						node.left = new IntNode(i);
						++size;
						break;
					}
					else {
						node = node.left;
					}
				}
				else {
					if (node.right == null) {
						node.right = new IntNode(i);
						++size;
						break;
					}
					else {
						node = node.right;						
					}
				}
			}
		}		
	}

	public void print() {
		System.out.print("Tree:");
		inorder(root);	
		System.out.println();
	}
	
	private void inorder(IntNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.printf(" %d", node.value);
			inorder(node.right);
		}
	}
}