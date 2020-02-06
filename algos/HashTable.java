import java.util.ArrayList;

public class HashTable {
    // things hash table has!
    int capacity;
    SLL[] table;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new SLL[capacity];
    }
    private int getIndex(String key) {
    	int code = Math.abs(key.hashCode());
    	return code%this.capacity;
    }
    // getter
    // ht.get("firstName") => "Lee"
    public String get(String key) {

     
        // convert hashCode into index for our table
    	int i = getIndex(key);
        // return value in table at index
    	if(this.table[i] == null) {
    		return "No Key here!";
    	}
    	return null;
    }
    // setter
    public void set(String key, String value) {
    	String[] kvp = {key, value};
    	int i = getIndex(key);
//    	this.table[i] = new KeyValuePair(key, value);
    }
    @Override
    public String toString() {
    	String output = "{";
//    	for(KeyValuePair kvp:this.table) {
//    		if(kvp!=null) {
//    			output += kvp.key + ": " + kvp.value + ", ";
//    		}
//    	}
    	output += "}";
    	return output;
    }
    // { "firstName": "Lee", "lastName": "Douglas" }
}