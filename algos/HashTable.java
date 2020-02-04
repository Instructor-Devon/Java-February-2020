public class HashTable {
    // things hash table has!
    int capacity;
    String[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new String[capacity];
    }

    // getter
    // ht.get("firstName") => "Lee"
    public String get(String key) {

        // convert "key" into hashCode
        // convert hashCode into index for our table
        // return value in table at index
        return "";
    }
    // setter
    public void set(String key, String value) {

    }
}