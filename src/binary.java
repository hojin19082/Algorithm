/**
 * Node Class
 *

 */
class Node {
    int value;
    Node leftChild;
    Node rightChild;

    public Node(int value) {
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }
}

/**
 * Binary Search Tree
 *
 */
class BinaryTree {
    Node rootNode = null;

    /**
     * ���ο� ��� ����
     */
    public void insertNode(int element) {

        /*
         * ��Ʈ�� �� ���, �� �ƹ� ��嵵 ���� ���
         */
        if (rootNode == null) {
            rootNode = new Node(element);
        } else {
            Node head = rootNode;
            Node currentNode;

            while (true) {
                currentNode = head;

                /*
                 * ������ ��Ʈ���� ���� ���, �������� Ž���� �Ѵ�.
                 */
                if (head.value > element) {
                    head = head.leftChild;

                    /*
                     * ���� �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 �����Ѵ�.
                     * ���� currenNode head�� ����Ű�� �ִ�.
                     */
                    if (head == null) {
                        currentNode.leftChild = new Node(element);
                        break;
                    }
                } else {
                    /*
                     * ������ ��Ʈ���� ū ���, ���������� Ž���� �Ѵ�.
                     */
                    head = head.rightChild;

                    /*
                     * ������ �ڽ� ��尡 ����ִ� ���, �ش� ��ġ�� �߰��� ��带 �����Ѵ�.
                     * ���� currenNode head�� ����Ű�� �ִ�.
                     */
                    if (head == null) {
                        currentNode.rightChild = new Node(element);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Ư�� ��� ����
     */
    public boolean removeNode(int element) {
        Node removeNode = rootNode;
        Node parentOfRemoveNode = null;

        while (removeNode.value != element) {
            parentOfRemoveNode = removeNode;

            /* ������ ���� ���� ��庸�� ������ ������ Ž���Ѵ�. */
            if (removeNode.value > element) {
                removeNode = removeNode.leftChild;
            } else {
                removeNode = removeNode.rightChild;
            }

            /*
             * �� ��Ҹ� ���ϸ� Ž������ ��
             * �� ���(Leaf node)�� ��� ������ ���� Ž�� ����
             */
            if (removeNode == null)
                return false;

        }

        /* �ڽ� ��尡 ��� ���� �� */
        if (removeNode.leftChild == null && removeNode.rightChild == null) {
            /* ���� ����� Ʈ���� ��Ʈ�� �� */
            if (removeNode == rootNode) {
                rootNode = null;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = null;
            } else {
                parentOfRemoveNode.leftChild = null;
            }
        }

        /* ������ �ڽ� ��常 �����ϴ� ��� */
        else if (removeNode.leftChild == null) {
            if (removeNode == rootNode) {
                rootNode = removeNode.rightChild;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                /*
                 * ���� ����� ������ �ڽ� ��带 ���� ��� ��ġ�� �д�.
                 */
                parentOfRemoveNode.rightChild = removeNode.rightChild;
            } else {
                parentOfRemoveNode.leftChild = removeNode.rightChild;
            }
        }

        /* ���� �ڽ� ��常 �����ϴ� ��� */
        else if (removeNode.rightChild == null) {
            if (removeNode == rootNode) {
                rootNode = removeNode.leftChild;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = removeNode.leftChild;
            } else {
                /*
                 * ���� ����� ���� �ڽ��� ���� ��� ��ġ�� �д�.
                 */
                parentOfRemoveNode.leftChild = removeNode.leftChild;
            }
        }

        /*
         * �� ���� �ڽ� ��尡 �����ϴ� ���
         * ������ ����� ���� ���� Ʈ���� �ִ� ���� ū �� ��带 �ø��ų�
         * ������ ���� Ʈ���� �ִ� ���� ���� �� ��带 �ø��� �ȴ�.
         * ���� �ڵ�� 2��° ����� ����Ѵ�.
         */
        else {
            /* ���� ��� ����� �ڽ� ��� �߿��� ��ü�� ���(replaceNode)�� ã�´�. */
            Node parentOfReplaceNode = removeNode;

            /* ���� ����� ������ ���� Ʈ�� Ž�� ���� */
            Node replaceNode = parentOfReplaceNode.rightChild;

            while (replaceNode.leftChild != null) {
                /* ���� ���� ���� ã�� ���� ���� �ڽ� ���� Ž���Ѵ�. */
                parentOfReplaceNode = replaceNode;
                replaceNode = replaceNode.leftChild;
            }

            if (replaceNode != removeNode.rightChild) {
                /* ���� ���� ���� �����ϱ� ������ ��ü ����� ���� �ڽ��� �� ��尡 �ȴ�. */
                parentOfReplaceNode.leftChild = replaceNode.rightChild;

                /* ��ü�� ����� ������ �ڽ� ��带 ������ ����� ���������� �����Ѵ�. */
                replaceNode.rightChild = removeNode.rightChild;
            }

            /* ������ ��尡 ��Ʈ ����� ��� ��ü�� ���� �ٲ۴�. */
            if (removeNode == rootNode) {
                rootNode = replaceNode;
            } else if (removeNode == parentOfRemoveNode.rightChild) {
                parentOfRemoveNode.rightChild = replaceNode;
            } else {
                parentOfRemoveNode.leftChild = replaceNode;
            }

            /* ���� ��� ����� ���� �ڽ��� �մ´�. */
            replaceNode.leftChild = removeNode.leftChild;
        }

        return true;
    }

    /**
     * ���� ��ȸ
     */
    public void inorderTree(Node root, int depth) {
        if (root != null) {
            inorderTree(root.leftChild, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("��");
            }
            System.out.println(root.value);
            inorderTree(root.rightChild, depth + 1);
        }
    }

    /**
     * ���� ��ȸ
     */
    public void postorderTree(Node root, int depth) {
        if (root != null) {
            postorderTree(root.leftChild, depth + 1);
            postorderTree(root.rightChild, depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("��");
            }
            System.out.println(root.value);
        }
    }

    /**
     * ���� ��ȸ
     */
    public void preorderTree(Node root, int depth) {
        if (root != null) {
            for (int i = 0; i < depth; i++) {
                System.out.print("��");
            }
            System.out.println(root.value);
            preorderTree(root.leftChild, depth + 1);
            preorderTree(root.rightChild, depth + 1);
        }
    }
}


public class binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree tree = new BinaryTree();
        tree.insertNode(5);
        tree.insertNode(8);
        tree.insertNode(7);
        tree.insertNode(10);
        tree.insertNode(9);
        tree.insertNode(11);
		
        if (tree.removeNode(10)) {
            System.out.println("��� ����");
        }

        tree.preorderTree(tree.rootNode, 0);
    }
}
