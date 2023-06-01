package Level3;
import java.util.*;
public class 섬연결하기 {
	//모든 정점을 가장 최소의 값으로 연결
	//MST -> 최소 스패닝 트리 크루스칼 알고리즘으로 해결
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        int[] parent = new int[n];
	        
	        Arrays.sort(costs, (o1, o2) -> {
	            return o1[2] - o2[2];
	        });
	        for(int i=0; i<n; i++){
	            parent[i] = i;
	        }
	        
	        for(int i=0; i<costs.length; i++){
	            if(find(costs[i][0], parent) != find(costs[i][1], parent)){
	                union(parent, costs[i][0], costs[i][1]);
	                answer += costs[i][2];
	            }
	        }
	        
	        return answer;
	    }
	    public static int find(int a, int[] parent){
	        if(parent[a] == a){
	            return a;
	        }else{
	            return find(parent[a], parent);
	        }
	    }
	    public static void union(int[] parent, int a, int b){
	        if(parent[a] == parent[b]){
	            return;
	        }     
	        int x = find(a, parent);
	        int y = find(b, parent);
	        if(x>y){
	            parent[x] = y;
	        }else{
	            parent[y] = x;
	        }
	    }

}
