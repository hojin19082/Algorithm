package dp;

import java.io.*;
import java.util.*;
public class Áö¸§±æ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		Map<Integer, ArrayList<int[]>> map = new HashMap<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if (end > D) continue;
            if (end - start <= dist) continue;
            if(!map.containsKey(start)) {
            	map.put(start, new ArrayList<>());
            	map.get(start).add(new int[] {end, dist});
            }else {
            	for(int j=0; j<map.get(start).size(); j++) {
            		int one = map.get(start).get(j)[0];
            		int two = end;
            		if(one == two) {
            			int one_dist = map.get(start).get(j)[1];
            			int two_dist = dist;
            			if(one_dist > two_dist) {
            				map.put(start, new ArrayList<>());
                        	map.get(start).add(new int[] {end, dist});
            			}
            		}else {
            			map.get(start).add(new int[] {end, dist});
            		}
            	}
            }
		}
		int[] dp = new int[D+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0]= 0;
        for(int i=0; i<D; i++) {
        	if(map.containsKey(i)) {
        		for(int j=0; j<map.get(i).size(); j++) {
        			dp[map.get(i).get(j)[0]] = Math.min(dp[map.get(i).get(j)[0]], dp[i] + map.get(i).get(j)[1]);
        		}
        	}
        	dp[i+1] = Math.min(dp[i+1], dp[i]+1);
        }
        
        System.out.println(dp[D]);
	}
}
