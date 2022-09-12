import java.io.*;
import java.util.*;

class land{
   int x;
   int y;
   
   land(int x, int y){
      this.x = x;
      this.y = y;
   }
}

public class NO4963 {
   static int w, h, cnt;
   static int[] dx = {0,1,0,-1,1,-1,1,-1};
   static int[] dy = {1,0,-1,0,1,-1,-1,1};
   static int[][] map;
   static boolean[][] check;
   static Queue<land> queue = new LinkedList<>();

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      while(true) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         w = Integer.parseInt(st.nextToken());
         h = Integer.parseInt(st.nextToken());
         
         if(w == 0 && h == 0)break;
         
         map = new int[h + 1][w + 1];
         check = new boolean[h + 1][w + 1];
         
         for(int i = 1; i <= h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= w; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
            }
         }
         
         cnt = 0;
         for(int i = 1; i <= h; i++) {
            for(int j = 1; j <= w; j++) {
               if(map[i][j] == 1 && !check[i][j]) {
                  bfs(new land(i, j));
                  cnt++;
               }
            }
         }
        System.out.println(cnt);
      }
   }
   
   private static void bfs(land l) {
      queue.add(l);
      
      while(!queue.isEmpty()) {
         land t = queue.poll();
         
         for(int i = 0; i < 8; i++) {
            int nowx = t.x + dx[i];
            int nowy = t.y + dy[i];
            
            if(nowx <= 0 || nowy <=0 || nowx > h || nowy > w) {
            	continue;
            }
            
            if(map[nowx][nowy] == 0 || check[nowx][nowy]) {
            	continue;
            }
            
            queue.add(new land(nowx, nowy));
            check[nowx][nowy] = true;
            check[t.x][t.y] = true;

         }
      }
   }
}