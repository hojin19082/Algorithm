import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
public class ������������̾ {
	static int N, M, K;
	// ������ �����ؼ� 8����
	// 2���� �迭�� Queue�� �����ϰ�
	// �� ĭ�� LinkedList�� �ʱ�ȭ -> �ش� ��ǥ�� �� add�� �̿��Ͽ� �� ĭ�� ���� ��ü�� ����
	// list�� size�� �̿��Ͽ� >=2 �̻��ΰ� Ȯ��!
	
	//4���� ���̾��
	//for�� +=2 �� �ؼ� 0~8 || 1~8�� ���� list�� �����Ͽ� �Ȱ��� �ݺ�
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static ArrayList<Fire> arr;
	static Queue<Fire>[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();
		// �����̶� ĭ�� ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			arr.add(new Fire(r,c,m,s,d));
		}
		
		grid = new Queue[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                grid[i][j] = new LinkedList<>();
            }
        }
		for (int i = 0; i < K; i++) {
			fire_move();
			
			//�̵��� ���� �� 2�� �̻��� ���̾ ĭ ���
			divideAndCombine();
		}
		
		int answer = 0;
        for (Fire f : arr) {
            answer += f.m;
        }
        System.out.print(answer);
		
	}

	public static void fire_move() {
		for(Fire f : arr) {
			f.r = f.r + dx[f.d] * (f.s % N);
			f.c = f.c + dy[f.d] * (f.s % N);

			if(f.r < 1) {
				f.r += N;
			}else if(f.r > N) {
				f.r -= N;
			}
			
			if(f.c < 1) {
				f.c += N;
			}else if(f.c > N) {
				f.c -= N;
			}
			
			grid[f.r][f.c].add(f);
		}
	}
	public static void divideAndCombine() {
		for(int i=1; i<N+1; i++){
			for(int j=1; j<N+1; j++) {
				if(grid[i][j].size() >= 2) {
					int m_sum = 0, s_sum = 0;
					int cnt_sum = grid[i][j].size();
					boolean odd = true, even =true;
					
					while(!grid[i][j].isEmpty()) {
						Fire f = grid[i][j].poll();
						m_sum += f.m;
						s_sum += f.s;
						if(f.d % 2 == 0) {
							odd = false;
						}else {
							even = false;
						}
						arr.remove(f);
					}
					int nm = m_sum/5;
					
					if(nm == 0) continue;
					
					int ns = s_sum/cnt_sum;
					if(odd | even) {
						for(int k=0; k<8; k+=2) {
							arr.add(new Fire(i,j,nm,ns,k));
						}
					}else {
						for(int k=1; k<8; k+=2) {
							arr.add(new Fire(i,j,nm,ns,k));
						}
					}
				}else {
					grid[i][j].clear();
				}
			}
		}
	}

}

class Fire {
	int r,c,m, s, d;

	Fire(int r, int c, int m, int s, int d) {
		this.r = r;
		this.c = c;
		this.m = m;
		this.s = s;
		this.d = d;
	}
}
