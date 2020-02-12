
public class BSTNode {
	 int value;
	 BSTNode left;
	 BSTNode right;
	public BSTNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	public boolean isLeaf() {
		return this.left == null && this.right == null;
	}
	public boolean isFull() {
		return this.left != null && this.right != null;
	}
	 
}
