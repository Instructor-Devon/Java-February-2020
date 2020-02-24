import java.nio.charset.Charset;
import java.util.ArrayList;

public class BST {
	 BSTNode root;
	 public BST() {
		 this.root = null;
	 }
	 public void display(BSTNode node, int depth) {
		 // keep track of depth? DONE
		 
		 // format ws*depth
		 // ws: 4 spaces?
         int numSpaces = 4;
		 String ws = "";
		 for(int i=0; i<depth*numSpaces; i++) {
			 // last numSpaces iterations should use "-" instead of " "
			 if(i < depth*numSpaces-numSpaces) {
				 ws += " ";
			 }
			 else if (i == depth*numSpaces-numSpaces) {
				 ws += "|";
			 }
			 else {
				 ws += "-";
			 }
		 }
		 
		 // iterate node, print node values
		 System.out.println(ws + node.value);
		 if(node.left != null) {
			 this.display(node.left, depth+1);
		 }
		 if(node.right != null) {
			 this.display(node.right, depth+1);
		 }
		 
	 }
	 public int[] toSortedArray() {
		 int[] payload = new int[this.size()];
		 
		 populateArray(this.root, payload, 0);
		 return payload;
	 }
	 private int populateArray(BSTNode node, int[] arr, int i) {
		 if(node.left != null) {
			 i = this.populateArray(node.left, arr, i);
		 }
		 arr[i] = node.value;
		 i++;
		 if(node.right != null) {
			 i = this.populateArray(node.right, arr, i);
		 }
		 return i;
	 }
	 
	 // size() 4
	 public int size() {
		 if(this.root == null) {
			 return 0;
		 }
		 return this.size(this.root);
	 }
	 private int size(BSTNode node) {
		 if(node == null) {
			 return 0;
		 }
		 int leftSize = this.size(node.left);
		 int rightSize = this.size(node.right);
		 return 1 + leftSize + rightSize;
	 }
	 public void remove(int value) {
		
		 this.remove(value, this.root);
	 }
	 public void remove(int value, BSTNode node) {
		 // base case: if node has no children
		 if(node.left == null && node.right == null) {
			 return;
		 }
		 // look left
		 if(node.left != null && node.left.value == value) {
			 // determine CASE for removal
			 if(node.left.isLeaf()) {
				 // we have a leaf
				 node.left = null;
				 return;
			 } else if(node.left.isFull()) {
				 // we find a valid successor
				 BSTNode replacement = this.getValidSuccessor(node.left);
				 replacement.left = node.left.left;
				 replacement.right = node.left.right;
				 node.left = replacement;
				 return;
			 } else {
				 // move pointer to single child of node to remove
				 // find out which side has child
				 BSTNode grandchild = (node.left.left != null) ? node.left.left : node.left.right;
				 node.left = grandchild;
				 return;
				 
			 }
		 } else if(node.right != null && node.right.value == value) {
			// determine CASE for removal
			 if(node.right.isLeaf()) {
				 // we have a leaf
				 node.right = null;
				 return;
			 } else if(node.right.isFull()) {
				// we find a valid successor
				 BSTNode replacement = this.getValidSuccessor(node.right);
				 replacement.left = node.right.left;
				 replacement.right = node.right.right;
				 node.right = replacement;
				 return;
			 } else {
				// move pointer to single child of node to remove
				 BSTNode grandchild = (node.right.left != null) ? node.right.left : node.right.right;
				 node.right = grandchild;
				 return;
			 }
		 } else {
			 // keep looking
			 if(value > node.value) {
				 // descend right
				 this.remove(value, node.right);
			 } else {
				 // descend left
				 this.remove(value, node.left);
			 }
		 }
		 
		 // CASE 1: node to remove is a leaf DONE
		 // CASE 2: node to remove has ONE child DONE
		 // CASE 3: node to remove has TWO children ???
		 
		 
	 }
	 public BSTNode getValidSuccessor(BSTNode node) {
		 BSTNode successor;
		 // go left ONCE
		 node = node.left;
		 // go right until LEAF
		 while(node.right.right != null) {
			 node = node.right;
		 }
		 successor = node.right;
		 node.right = null;
		 return successor;
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
