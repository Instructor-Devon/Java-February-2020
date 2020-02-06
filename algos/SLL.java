
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
}
