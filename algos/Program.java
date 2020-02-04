public class Program {
    public static void main(String[] args) {
        
        String keyName = "firstName";
        String keyName2 = "firstName";
        // we convert keyName into hashCode();

        
        int hashCode = keyName.hashCode(); // 1
        int hashCode2 = keyName2.hashCode(); // 1
        
        System.out.println(hashCode);
        System.out.println(hashCode2);

        // we constrict the size of our Array
        int tableSize = 10;

        // we store our values in an ARRAY!
        String[] table = new String[tableSize];

        int index = hashCode%tableSize;
        table[index] = "Lee";

        System.out.println(table[index]);
    }
}