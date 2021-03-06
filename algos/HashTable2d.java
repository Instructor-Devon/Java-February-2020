public class HashTable2d {
    // things hash table has!
    int capacity;
    String[][] table;

    public HashTable2d(int capacity) {
        this.capacity = capacity;
        this.table = new String[capacity][];
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
        return this.table[i][1];
    }
    // setter
    public void set(String key, String value) {
    	String[] kvp = {key, value};
    	int i = getIndex(key);
    	this.table[i] = kvp;
    }
    @Override
    public String toString() {
    	String output = "{";
    	for(String[] kvp:this.table) {
    		if(kvp!=null) {
    			output += kvp[0] + ": " + kvp[1] + ", ";
    		}
    	}
    	output += "}";
    	return output;
    }
    // { "Lee", "Douglas" }
}