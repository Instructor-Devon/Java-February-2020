import java.nio.charset.Charset;

public class Program {
    public static void main(String[] args) {
    	
    	int[] t1 = {10};
    	int[] t2 = {20,10};
    	int[] t3 = {20,10,5};
    	int[] t4 = {20,10,4,1};
    	Sorts.mergeSort(t1);
    	Sorts.mergeSort(t2);
    	Sorts.mergeSort(t3);
    	Sorts.mergeSort(t4);
    	
    	
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