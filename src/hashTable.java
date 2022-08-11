import java.util.LinkedList;
public class hashTable {
	class Node{
		String key;
		String value;
		
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		String getValue() {
			return value;
		}
		void setValue() {
			this.value = value;
		}
	}
	
	// chaining ±â¹ý
	LinkedList<Node>[] data;
	
	hashTable(int size) {
		this.data = new LinkedList[size];
	}
	
	int gethashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode+=c;
		}
		return hashcode;
	}
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	Node searchKey(LinkedList <Node> list, String key) {
		if (list == null) return null;
		for(Node node:list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	void set(String key, String value) {
		int index = convertToIndex(gethashCode(key));
			LinkedList<Node> list = data[index];
			
			if(list == null) {
				list = new LinkedList<Node>();
				data[index] = list;
			}
			Node node = searchKey(list, key);
			
			if(node == null) {
				list.addLast(new Node(key, value));
			}else {
				node.value = value;
			}
			System.out.println("hashcode : "+gethashCode(key)+", index : " +index + ", ");
		}
	
	String get(String key) {
		int index = convertToIndex(gethashCode(key));
		LinkedList<Node> list = data[index];
		
		Node node = searchKey(list, key);
				
		return node == null ? "Not Found" : node.value;
	}
}