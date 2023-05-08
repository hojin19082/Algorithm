package Level3;
import java.util.*;
public class 가장먼노드 {
	    static class Node{
	        int node, length;
	        Node(int node, int length){
	            this.node =node;
	            this.length = length;
	        }
	    }
	    static ArrayList<Integer>[] arr;
	    static ArrayList<Node> ans;
	    public int solution(int n, int[][] edge) {
	        int answer = 0;
	        arr = new ArrayList[n+1];
	        ans = new ArrayList<>();
	        for(int i=1; i<=n; i++){
	            arr[i] = new ArrayList<>();
	        }
	        for(int i=0; i<edge.length; i++){
	            int a = edge[i][0];
	            int b = edge[i][1];
	            arr[a].add(b);
	            arr[b].add(a);
	        }
	        
	        bfs(1, n);
	        
	        Collections.sort(ans, (o1,o2)-> o2.length - o1.length);
	        int max = ans.get(0).length;
	        for(int i=1; i<ans.size(); i++){
	            if(max > ans.get(i).length){
	                break;
	            }else{
	                answer++;
	            }
	        }
	        return answer;
	    }
	    public static void bfs(int start, int n){
	        Queue<Node> q = new LinkedList<>();
	        q.offer(new Node(1, 0));
	        boolean[] visited= new boolean[n+1];
	        visited[start] = true;
	        while(!q.isEmpty()){
	            Node nn = q.poll();
	            ans.add(nn);
	            for(int nextNode : arr[nn.node]){
	                if(!visited[nextNode]){
	                    visited[nextNode] = true;
	                    q.offer(new Node(nextNode, nn.length+1));
	                }
	            }
	        }
	    }
	}
