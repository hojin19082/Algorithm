
public class RBtree {
	private static final int BLACK = 0;
	private static final int RED = 1;
	private static Node root;
	
	private static class Node{
		private int value;
		private int color;
		
		Node left;
		Node right;
		Node parent;
		
		Node(int value){
			this.value = value;
			color = BLACK;
			
			left = null;
			right = null;
			parent = null;
		}
		Node(){
			this(-1);
		}
		int getValue() {
			return value;
		}
		void setValue(int value) {
			this.value = value;
		}
		String getColor() {
			return color == RED ? "RED" : "BLACK";
		}
		void setColor(int color) {
			this.color = color;
		}
	}
	public static void printTree(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getValue() + "(" + node.getColor() + ")");
		printTree(node.left);
		printTree(node.right);
	}
	public static Node findNode(Node goal, Node node) {
		if(node == null) {
			return null;
		}
		if(goal.getValue() < node.getValue()) {
			if(node.left !=null) {
				return findNode(goal, node.left);
			}
		}else if(goal.getValue()>node.getValue()) {
			if(node.right != null) {
				return findNode(goal, node.right);
			}
		}else {
			return node;
		}
		return null;
	}
	public static void insertNode(Node node) {
		if(root == null) {
			root = node;
			
			System.out.println("Created RBT \n");
		}else {
			Node parent = root;
			node.setColor(RED);
			while(true) {
				if(parent.getValue() < node.getValue()) {
					if(parent.right == null) {
						parent.right = node;
						node.parent = parent;
						break;
					}else {
						parent = parent.right;
					}
				}else {
					if(parent.left == null) {
						parent.left = node;
						node.parent = parent;
						break;
					}else {
						parent = parent.left;
					}
				}
			}
			recolorTree(node);
		}
		System.out.println("Inserted " + node.getValue());
	}
	
	public static Node deleteNode(Node node) {
		Node y;
		Node x;
		if(node.left == null || node.right == null) {
			y = node;
		}else {
			Node removeNode = root;
			
			while(removeNode.getValue() != node.getValue()) {
				if(removeNode.getValue() > node.getValue()) {
					removeNode = removeNode.left;
				}else {
					removeNode = removeNode.right;
				}
				
				if(removeNode == null) {
					return null;
				}
			}
			y = removeNode;
		}
		
		if(y.left != null) {
			x = y.left;
		}else {
			x = y.right;
		}
		
		if(x != null) {
			x.parent = y.parent;
		}
		if(y.parent == null) {
			root = x;
		}else if(y == y.parent.left) {
			y.parent.left = x;
		}else {
			y.parent.right = x;
		}
		
		if(y != node) {
			if("BLACK".equals(y.getColor())) {
				node.setColor(BLACK);
			}else {
				node.setColor(RED);
			}
			node.setValue(y.getValue());
		}
		
		if("BLACK".equals(y.getColor())) {
			deleteRecolorTree(x);
		}
		
		return y;
	}
	
	private static void deleteRecolorTree(Node node) {
		while(node != root && "BLACK".equals(node.getColor())) {
			Node w = null;
			if(node == node.parent.left) {
				w = node.parent.right;
				if("RED".equals(w.getColor())){
					w.setColor(BLACK);
					node.parent.setColor(RED);
					rotateLeft(node.parent);
					w = node.parent.right;
				}
				if("BLACK".equals(w.left.getColor()) && "BLACK".equals(w.right.getColor())) {
					w.setColor(RED);
					node = node.parent;
				} else if("BLACK".equals(w.right.getColor())) {
					w.left.setColor(BLACK);
					w.setColor(RED);
					rotateRight(w);
					w = node.parent.right;
				}
				if("BLACK".equals(node.parent.getColor())) {
					w.setColor(BLACK);
				}else {
					w.setColor(RED);
				}
				node.parent.setColor(BLACK);
				w.right.setColor(BLACK);
				rotateLeft(node.parent);
				node = root;
			}else {
				w = node.parent.left;
				if("RED".equals(w.getColor())){
					w.setColor(BLACK);
					node.parent.setColor(RED);
					rotateRight(node.parent);
					w = node.parent.left;
				}
				if("BLACK".equals(w.left.getColor()) && "BLACK".equals(w.right.getColor())) {
					w.setColor(RED);
					node = node.parent;
				}else if("BLACK".equals(w.right.getColor())) {
					w.left.setColor(BLACK);
					w.setColor(RED);
					rotateLeft(w);
					w = node.parent.left;
				}
				if("BLACK".equals(node.parent.getColor())) {
					w.setColor(BLACK);
				}else {
					w.setColor(RED);
				}
				node.parent.setColor(BLACK);
				w.left.setColor(BLACK);
				rotateRight(node.parent);
				node = root;
			}
		}
		node.setColor(BLACK);
	}
	
	private static void recolorTree(Node node) {
		while(node.parent != null && "RED".equals(node.parent.getColor())) {
			Node next = null;
			if(node.parent == node.parent.parent.left) {
				next = node.parent.parent.right;
				if(next !=null && "RED".equals(next.getColor())) {
					node.parent.setColor(BLACK);
					next.setColor(BLACK);
					node.parent.parent.setColor(RED);
					node = node.parent.parent;
					continue;
				}
				if(node == node.parent.right) {
					node = node.parent;
					rotateLeft(node);
				}
				node.parent.setColor(BLACK);
				node.parent.parent.setColor(RED);
				rotateRight(node.parent.parent);
				break;
			}else {
				next = node.parent.parent.left;
				if(next !=null && "RED".equals(next.getColor())) {
					node.parent.setColor(BLACK);
					next.setColor(BLACK);
					node.parent.parent.setColor(RED);
					node = node.parent.parent;
					continue;
				}
				if(node == node.parent.left) {
					node = node.parent;
					rotateRight(node);
				}
				node.parent.setColor(BLACK);
				node.parent.parent.setColor(RED);
				rotateLeft(node.parent.parent);
				break;
			}
		}
		root.setColor(BLACK);
	}
	
	private static void rotateLeft(Node node) {
		if(node.parent == null) {
			Node right = root.right;
			root.right = root.right.left;
			right.left = new Node();
			right.left.parent = root;
			root.parent = right;
			right.left = root;
			right.parent = null;
			root = right;
		}else {
			if(node == node.parent.left) {
				node.parent.left = node.right;
			}else {
				node.parent.right = node.right;
			}
			node.right.parent = node.parent;
			node.parent = node.right;
			if(node.right.left!=null) {
				node.right.left.parent = node;
			}
			node.right = node.right.left;
			node.parent.left = node;
		}
	}
	
	private static void rotateRight(Node node) {
		if (node.parent == null) {
			Node left = root.left;
			root.left = root.left.right;
			left.right = new Node();
			left.right.parent = root;
			root.parent = left;
			left.right = root;
			left.parent = null;
			root = left;
		}
		else {
			if (node == node.parent.left)
				node.parent.left = node.left;
			else
				node.parent.right = node.left;
			
			node.left.parent = node.parent;
			node.parent = node.left;
			
			if (node.left.right != null)
				node.left.right.parent = node;
			
			node.left = node.left.right;
			node.parent.right = node;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = null;
		
		Node a = new Node(100);
		Node b = new Node(50);
		Node c = new Node(30);
		Node d = new Node(80);
		Node e = new Node(200);
		Node f = new Node(400);
		Node g = new Node(10);
		Node h = new Node(500);
		Node i = new Node(250);
		Node j = new Node(120);
		insertNode(a);
		insertNode(b);
		insertNode(c);
		insertNode(d);
		insertNode(e);
		insertNode(f);
		insertNode(g);
		insertNode(h);
		insertNode(i);
		insertNode(j);

		Node remove = deleteNode(g);
		System.out.println(remove.getValue());

		System.out.println();
		printTree(root);
	}

}
