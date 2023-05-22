import java.util.*;
//start,B,A에서 특정 노드까지 시작하여 갈 수 있는 최소거리를 구하고, (다익스트라)
//각 노드마다 값을 더하면 같이 타고갈때+내리고 각 집까지 가는 거리로 구할 수 있음.
//그 중 가장 작은 값이 합승 택시 요금이 가장 적을 때!
class Edge implements Comparable<Edge>{
        int index;
        int cost;
        Edge(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge e){
            return this.cost - e.cost;
        }
    }
class Solution {
    static ArrayList<ArrayList<Edge>> graph;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        graph = new ArrayList<>();
        for(int i = 0 ; i <= n ; i ++){
            graph.add(new ArrayList<>());
        }

        for(int[] i : fares){
            graph.get(i[0]).add(new Edge(i[1], i[2]));
            graph.get(i[1]).add(new Edge(i[0], i[2]));
        }

        int[] startA = new int[n + 1];
        int[] startB = new int[n + 1];
        int[] start = new int[n + 1];
        
        Arrays.fill(startA, Integer.MAX_VALUE);
        Arrays.fill(startB, Integer.MAX_VALUE);
        Arrays.fill(start, Integer.MAX_VALUE);
        
        startA = dijkstra(a, startA);
        startB = dijkstra(b, startB);
        start = dijkstra(s, start);
        
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);
        }
        return answer;
    }
    public static int[] dijkstra(int start, int[] costs){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        costs[start] = 0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            int nIndex = now.index;
            int nCost = now.cost;
            
            if(nCost > costs[nIndex]) continue;
            
            ArrayList<Edge> edges = graph.get(nIndex);
            for(Edge edge : edges){
                int cost = costs[nIndex] + edge.cost;
                
                if(cost < costs[edge.index]){
                    costs[edge.index] = cost;
                    pq.offer(new Edge(edge.index, cost));
                }
            }
        }
        return costs;
    }
}
