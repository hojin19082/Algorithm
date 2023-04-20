package Level3;
import java.util.*;

	class Solution {
	    static List<Integer>[] arr;
	    static int[] information;
	    static boolean[] visited;
	    static int maxSheep = 0;
	    public int solution(int[] info, int[][] edges) {
	        information = info;
	        visited = new boolean[info.length];
	        arr = new ArrayList[info.length];
	        for(int i=0; i<info.length; i++){
	            arr[i] = new ArrayList<>();
	        }
	        
	        for(int i=0; i<edges.length; i++){
	            arr[edges[i][0]].add(edges[i][1]);
	        }

	        List<Integer> list = new ArrayList<>();
	        list.add(0);
	        dfs(0, 0, 0,list);
	        return maxSheep;
	    }
	    public static void dfs(int start, int wolf, int sheep, List<Integer> nextList){
	        
	        if(information[start] == 1) wolf++;
	        else sheep++;
	        
	        if(wolf >= sheep) return;
	        maxSheep = Math.max(maxSheep, sheep);
	        
	        List<Integer> temp = new ArrayList<>();
	        temp.addAll(nextList);
	        temp.remove(Integer.valueOf(start));
	        
	        if(arr[start] !=null){
	            for(int v : arr[start]){
	                temp.add(v);
	            }
	        }
	        
	        for(int next : temp){
	            dfs(next, wolf, sheep, temp);
	        }
	    }
	}


