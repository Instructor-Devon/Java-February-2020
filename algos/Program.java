public class Program {
    public static void main(String[] args) {
        
       HashTable2d ht = new HashTable2d(1);
       
       ht.set("firstName", "Lee");
       ht.set("lastName", "Douglas");
       ht.set("firstName", "Reena");
       String first = ht.get("firstName");
   
    }
}