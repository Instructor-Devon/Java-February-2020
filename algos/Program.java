public class Program {
    public static void main(String[] args) {
        
    	BST tree = new BST();
    	tree.add(20);
    	tree.add(10);
    	tree.add(30);
    	tree.add(5);
    	tree.add(11);
    	tree.add(23);
    	tree.add(100);
    	tree.add(13);
    	tree.add(1);
    	tree.add(7);
    	
    	tree.contains(7, tree.root);
    	
   
    	tree.remove(20);
    	
    	System.out.println(tree.height(tree.root));
    	
    	SLL list = new SLL();
    	list.add(new KeyValuePair("haha", "LOL"));
    	list.add(new KeyValuePair("haha", "LOL"));
    	list.add(new KeyValuePair("haha", "LOL"));
    	list.add(new KeyValuePair("haha", "LOL"));
    	list.add(new KeyValuePair("haha", "LOL"));
    	
    	System.out.println(list.size(list.head));
    }
}