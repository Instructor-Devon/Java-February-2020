// we need a class!
package hellojava;
import hellojava.algos.Algos;
import java.util.ArrayList;
public class Program {
    // Entry Point Method

    // static vs "object"
    public static void main(String[] args) {
        
        // WHERE WE DEFINE TYPES
        // 1) Variables
        // String
        // int, short, long

        // Strings
        String reena = "Reena";
        String cassandra = "Cassandra";
        String lee = "Lee";
        String devon = "Devon";

        if("Lee".equals("Lee")) {
            System.out.println("Same Names!!");
        }

        // 32bit integer 1,000,000
        int number;
        // HERE, what is number???
        number = 5;
        if(number == 0) {
            number = -5;
        }

        // Object type (has methods/properties, CAN BE NULL)
        Integer numberObject;

        // 16bit integer
        short shorty = 5;
        Short shortyObject = 5;

        // 64bit integer 1,000,000,000
        long longy = 5;
        Long longyObject = 5L;

        // ARRAYS
        // Arrays must have a defined TYPE
        // people!
        String[] people = { reena, devon, cassandra, lee, "Michael" };
        // ARRAYS, once initialized, are FIXED in size
        
        int[] numbers = new int[10];
        // loop
        for(int i=0; i<numbers.length; i++) {
            numbers[i] = i+1;
        }
        // [1,2,3,4,5,6,7,8,9,10]
        System.out.println(numbers);

        
        ArrayList<String> stringList = new ArrayList<String>();
        stringList.add("One");
        stringList.add("Two");
        stringList.add("Three");
        stringList.remove("One");
          

        // 2) Function's return
        // 3) Function's paramters
        int maxNum = Algos.maxArrayValue(numbers);
        System.out.println(maxNum);
    }
    
}