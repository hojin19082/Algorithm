import java.io.*;
import java.util.*;

public class NO1707 {
	static ArrayList<Integer>[] arr;
	static int[] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new ArrayList[n+1];
			visited = new int[n + 1];
			for(int i=1; i<n+1; i++) {
				arr[i] = new ArrayList<Integer>();
				visited[i] = 0;
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				arr[u].add(v);
				arr[v].add(u);
			}
			bfs();
		}
	}

	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 1; i < n + 1; i++) {
			if (visited[i] == 0) {
				q.add(i);
				visited[i] = 1;
			}
			while (!q.isEmpty()) {
				int v = q.poll();

				for (int j = 0; j < arr[v].size(); j++) {
					if (visited[arr[v].get(j)] == 0) {
						q.add(arr[v].get(j));
					}
					if (visited[arr[v].get(j)] == visited[v]) {
						System.out.println("NO");
						return;
					}

					if (visited[v] == 1 && visited[arr[v].get(j)] == 0) {
						visited[arr[v].get(j)] = 2;
					} else if (visited[v] == 2 && visited[arr[v].get(j)] == 0) {
						visited[arr[v].get(j)] = 1;
					}
				}

			}

		}
		System.out.println("YES");
	}
}
