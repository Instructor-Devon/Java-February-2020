
public class SLL {
	public SLLNode head;
	public SLL() {
		this.head = null;
	}
	
	public void add(KeyValuePair value) {
		// add node to end of list
		
		// If List is Empty
		if(this.head == null) {
			this.head = new SLLNode(value);
			return;
		}
		
		// Otherwise, travel to end of list
		SLLNode runner = null;
		// A					B                    D
		for(runner = this.head; runner.next != null; runner = runner.next) {}
		
		runner.next = new SLLNode(value);
	}
	public KeyValuePair contains(String key) {
		// returns a kvp if in list
		SLLNode runner = null;
		// A					B                    D
		for(runner = this.head; runner != null; runner = runner.next) {
			if(runner.value.key.equals(key)) {
				return runner.value;
			}
		}
		return null;
	}
	public boolean isEmpty() { return this.head == null; }
	@Override
	public String toString() {
		String output = "[";
		// iterate through
		SLLNode runner = null;
		if(this.isEmpty()) {
			output += "]";
			return output;
		}
		for(runner = this.head; runner.next != null; runner = runner.next) {
			output += runner.value.toString() + ", ";
		}
		output += runner.value.toString();
		// adding "THing, " in each iteration
		output += "]";
		return output;
	}
}
