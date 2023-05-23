import java.util.*;
class Solution {
    static class Edge implements Comparable<Edge>{
        int to, weight;
        Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
    static HashSet<Integer> gateSet;
    static HashSet<Integer> summitsSet;
    static ArrayList<Edge>[] arr;
    static int N;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        N = n;
        arr = new ArrayList[n+1];
        gateSet = new HashSet<>();
        summitsSet = new HashSet<>();
        for(int i=1; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<gates.length; i++){
            gateSet.add(gates[i]);
        }
        for(int i=0; i<summits.length; i++){
            summitsSet.add(summits[i]);
        }
        for(int i=0; i<paths.length; i++){
            int from = paths[i][0];
            int to = paths[i][1];
            int weight = paths[i][2];
            arr[from].add(new Edge(to, weight));
            arr[to].add(new Edge(from, weight));
        }
     
        return dijkstra(gates, summits);
    }
    public static int[] dijkstra(int[] gates, int[] summits){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] intensity = new int[N + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for (int gate : gates) {
            pq.add(new Edge(gate, 0));
            intensity[gate] = 0;
        }
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            if(summitsSet.contains(now.to)) continue;
            if(now.weight > intensity[now.to]) continue;
                for(Edge next : arr[now.to]){
                    if(gateSet.contains(next.to)) continue;
                        int dis = Math.max(intensity[now.to], next.weight);
                        if(intensity[next.to] > dis){
                            intensity[next.to] = dis;
                            pq.add(new Edge(next.to, dis));
                        
                    }
                }
            }
        int mn = Integer.MAX_VALUE;
        int mw = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for(int summit : summits){
            if(intensity[summit] < mw){
                mn = summit;
                mw = intensity[summit];
            }
        }
        return new int[]{mn, mw};
        }
    
}
