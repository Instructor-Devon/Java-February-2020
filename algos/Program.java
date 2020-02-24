import java.nio.charset.Charset;

public class Program {
    public static void main(String[] args) {
    	
    	int[] numbers = {1,5,6,7,10,13,20,25};
    	
    	BST result = new BST();
    	result.add(10);
    	result.add(5);
    	result.add(20);
    	result.add(1);
    	result.add(7);
    	result.add(13);
    	result.add(25);
    	result.display(result.root,0);
    	
    	
    	//10
    	// |_ 5
    	// 	  |_ 7
    	//    |_ 1
    	// |_ 20
    	// 	  |_ 13
    	//    |_ 25
    	
    }
    public static BST arrToBst(int[] sortedArray) {
    	BST tree = new BST();
    	rArrToBst(sortedArray, tree, 0, sortedArray.length-1);
    	return tree;
    }
    public static void rArrToBst(int[] sortedArray, BST tree, int start, int end) {
    	// too far!
    	if(start > end) {
    		return;
    	}
    	// find middle of sortedArray
    	int middle = (start + end)/2;
    	tree.add(sortedArray[middle]);
    	
    	// find all of the other middles
    	// find left middle
    	
    	rArrToBst(sortedArray, tree, start, middle-1);
    	// find right middle
    	rArrToBst(sortedArray, tree, middle+1, end);
    }
}