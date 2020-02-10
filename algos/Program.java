public class Program {
    public static void main(String[] args) {
        
    	BST tree = new BST();
    	tree.add(10);
    	tree.add(5);
    	tree.add(15);
    	tree.add(25);
    	
    	tree.contains(7, tree.root);
    }
}