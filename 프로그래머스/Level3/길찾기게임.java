import java.util.*;
class Solution {
    public class Node{
        Point p;
        int value;
        Node left;
        Node right;
        
        public Node(Point p, int value, Node left, Node right) {
            this.p = p;
            this.value = value;
            this.left = left;
            this.right = right;
        }
        
    }
    static class Point{
        int x,y;
        Point(int x, int y){
            this.x =x;
            this.y = y;
        }
    }
    static int[][] answer;
    static int idx;
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        Node[] nodes = new Node[nodeinfo.length];
        for(int i=0; i<nodeinfo.length; i++){
            Point p = new Point(nodeinfo[i][0], nodeinfo[i][1]);
            nodes[i] = new Node(p, i+1, null, null);
        }
        //y좌표에 따라 트리 level이 구현되어 있으며
        //x좌표에 따라 왼쪽, 오른쪽 자식을 형성
        Arrays.sort(nodes, (o1, o2)-> {
            if(o1.p.y == o2.p.y){
                return o1.p.x - o2.p.x;
            }
            return o2.p.y - o1.p.y;
        });
        Node root = nodes[0];
        //루트와 다음 노드를 이용해서
        //트리 구현!
        for(int i=1; i<nodes.length; i++){
            insertNode(root, nodes[i]);
        }
        idx = 0;
        preorder(root);
        
        idx = 0;
        postorder(root);
        return answer;
    }

    //root의 마지막 자식까지 내려가서 왼쪽, 오른쪽 자식에 연결!
    public static void insertNode(Node root, Node node){
        if(root.p.x > node.p.x){
            if(root.left == null) root.left = node;
            else insertNode(root.left, node);
        }else{
            if(root.right == null) root.right = node;
            else insertNode(root.right, node);
        }
    }
    //postorder는 왼쪽 자식 끝까지 간 후, 오른쪽 자식 끝까지 간 후, 루트
    public static void postorder(Node root){
        if(root != null){
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }
    //preorder는 부모 먼저 그리고 왼쪽 자식, 오른쪽 자식
    public static void preorder(Node root){
        if(root != null){
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
}
