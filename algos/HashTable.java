
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
    public String get(String key) throws Exception {

     
        // convert hashCode into index for our table
    	int i = getIndex(key);
        // return value in table at index
    	if(this.table[i] == null) {
    		throw new Exception("Key Error");
    	}
    	
    	// check to see if key already in table
    	KeyValuePair existing = this.table[i].contains(key);
    	if(existing != null) {
    		return existing.value;
    	}
    	throw new Exception("Key Error");
    }
    // setter
    // ht.get("firstName") => "Lee"
    // ht.get("firstName") => "Cassandra"
    public void set(String key, String value) {
    	KeyValuePair kvp = new KeyValuePair(key, value);
    	int i = getIndex(key);
    	
    	// is there anything here yet?
    	if(this.table[i] == null) {
    		// add new SLL here!
    		this.table[i] = new SLL();
    	}
    	
    	SLL collisions = this.table[i];
    	
    	// check to see if key already in table
    	KeyValuePair existing = collisions.contains(key);
    	if(existing != null) {
    		existing.value = value;
    	} else {
    		collisions.add(kvp);
    	}
    	
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