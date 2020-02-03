package hellojava.algos;
public class Algos {
    // takes IN integer array
    // returns largest value
    public static int maxArrayValue(int[] nums) {
        // "current" max variable
        int currentMax = nums[0];

        // loop the array
        for(int i=1; i<=nums.length; i++) {
            // if we find value > currentMax
            //             i
            // [1,2,3,4,5]
            try {
                if(nums[i] > currentMax) {
                    // update currentMax
                    currentMax = nums[i];
                }
            }
            catch(IndexOutOfBoundsException e) {
                System.err.println(e);
            }
        }
        return currentMax;
    }
}