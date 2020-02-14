import java.util.List;

public class Program {
    public static void main(String[] args) {
        
    	BST tree = new BST();
    	tree.add(50);
    	tree.add(10);
    	tree.add(100);
    	tree.add(5);
    	tree.add(24);
    	tree.add(70);
    	tree.add(101);
    	
    	int[] arr = tree.toSortedArray();
    	System.out.println(arr);
    }
}