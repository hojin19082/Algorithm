import java.io.*;

public class maze {
	private static int N=8;
	private static int [][] maze = {
			{0,0,0,0,0,0,0,1},
			{0,1,1,0,1,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,0,0,1,1,0,0},
			{0,1,1,1,0,0,1,1},
			{0,1,0,0,0,1,0,1},
			{0,0,0,1,0,0,0,1},
			{0,1,1,1,0,1,0,0}
	};
	private static final int pathway_colour=0;
	private static final int wall_colour = 1;
	private static final int blocked_colour = 2;
	private static final int path_colour = 3;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		if(findmazepath(0,0)==true) {
			System.out.println("True");
		}
		
	}
	public static boolean findmazepath(int x, int y) {
		if(x<0 || y<0 || x>=N || y>=N) {
			return false;
		}else if(maze[x][y] != pathway_colour) {
			return false;
		}else if(x==N-1 && y==N-1) {
			maze[x][y] = path_colour;
			return true;
		}else {
			maze[x][y] = path_colour;
			if(findmazepath(x-1, y) || findmazepath(x, y+1) 
					|| findmazepath(x+1, y) || findmazepath(x, y-1)) {
				return true;
			}
			maze[x][y] = blocked_colour;
			return false;
		}
	}
}
