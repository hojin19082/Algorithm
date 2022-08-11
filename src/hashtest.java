public class hashtest{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashTable ht = new hashTable(3);

		ht.set("Lee", "lee is pretty");
		ht.set("Kim", "kim is smart");
		ht.set("Hee", "hee is an angel");
		ht.set("Choi", "choi is cute");
		
		System.out.println(ht.get("Lee"));
		System.out.println(ht.get("Kim"));
		System.out.println(ht.get("Hee"));
		System.out.println(ht.get("Choi"));

		System.out.println(ht.get("Kang"));
		
		ht.set("Choi", "choi is sexy");
		System.out.println(ht.get("Choi"));
	}

}
