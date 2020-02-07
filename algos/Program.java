public class Program {
    public static void main(String[] args) {
        
       HashTable ht = new HashTable(1);
       
	   ht.set("firstName", "Lee");
	   ht.set("lastName", "Douglas");
	   ht.set("firstName", "Reena");
       
	    try {
			System.out.println(ht.get("lastName"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}