
public class BST {
	 BSTNode root;
	 public BST() {
		 this.root = null;
	 }
	 // size() 4
	 public int size(BSTNode node) {
		 if(node == null) {
			 return 0;
		 }
		 int leftSize = this.size(node.left);
		 int rightSize = this.size(node.right);
		 return 1 + leftSize + rightSize;
	 }
	 public int height(BSTNode node) {
		 if(node == null) {
			 return 0;
		 }
		 int leftSize = this.height(node.left);
		 int rightSize = this.height(node.right);
		 if(leftSize > rightSize) {
			 return 1 + leftSize;
		 } else {
			 return 1 + rightSize;
		 }
	 }
	 // max() 2
	 // min() 2
	 // remove() 8
	 // contains O(logN)
	 public boolean contains(int value, BSTNode root) {
		 if(root == null) {
			 return false;
		 }
		 if(root.value == value) {
			 return true;
		 }
		 // VALUE NOT FOUND HERE
		 // LOOK SOMEWHERE ELSE
		 if(value >= root.value) { 
			 // GO RIGHT
			 return this.contains(value, root.right);
		 } else {
			 // GO LEFT
			 return this.contains(value, root.left);
		 }
	 }
	 
	 public void add(int value, BSTNode node) {
		
		 
		 // which way do we go? (compare value with node.value)
		 if(value >= node.value) {
			 // we are going right
			 // now, is there a right node?
			 if(node.right == null) {
				 // no? add there
				 node.right = new BSTNode(value);
				 return;
			 }
			 this.add(value, node.right);
			 
		 } else {
			 // we are going left
			 // now, is there a left node?
			 if(node.left == null) {
				 // no? add there
				 node.left = new BSTNode(value);
				 return;
			 }
			 this.add(value, node.left);
		 }
		 
		 
	 }
	 public void add(int value) {
		 if(this.root == null) {
			 this.root = new BSTNode(value);
			 return;
		 }
		 this.add(value, this.root);
	 }
}
