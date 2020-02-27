
public class Sorts {
	public static void mergeSort(int[] arr) {
		splitIt(arr, 0, arr.length-1);
	}
	public static void splitIt(int[] arr, int left, int right) {
		// we "split" the array down
		// find the middle
		int mid = (left+right)/2;
		if(left < right) {
			
			
			// do this for left and right
			splitIt(arr, left, mid);
			splitIt(arr, mid+1, right);
			zipIt(arr, left, mid, right);
			
		}
	}
	public static void zipIt(int[] arr, int left, int mid, int right) {
		// arr:[3,9,6,10,13]
		// left:0 mid: 0 right: 1
		
		// make temp left and right arrays
		int sizeL = mid-left+1;
		int sizeR = right-mid;
		int[] leftArr = new int[sizeL];
		int[] rightArr = new int[sizeR];
		
		// prepare temp arrays
		for(int i=0; i<sizeL; i++) {
			leftArr[i] = arr[left+i];
		}
		for(int i=0; i<sizeR; i++) {
			rightArr[i] = arr[mid+1+i];
		}
		int i = 0;
		int j = 0;
		int p = left;
		//    i
		// [3,9]
		//  j
		// [6,10]
		
		// now we have two arrays to merge!
		// loop partitioned array
		while(i < sizeL && j < sizeR) {
			 if(leftArr[i] <= rightArr[j]) {
				  arr[p] = leftArr[i];
				  i++;
			 }
			 else {
				  arr[p] = rightArr[j];
				  j++;
			 }
			 p++;
			
		}
		// get remaining items from leftArr and rightArr into arr
		// if i<sizeL we still have items in leftArr
		while(i < sizeL) {
			arr[p] = leftArr[i];
			i++;
			p++;
		}
		// if j<sizeR we still have items in rightArr
		while(j < sizeR) {
			arr[p] = rightArr[j];
			j++;
			p++;
		}
		//     p
		// => [3,9,6,10]
		
	}
}
