package baekjoon.search.bj2178.bfs.wono;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n;
	static int m;
	static int[][] map;
	static int[][] visited;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static Queue<Point> q = new LinkedList<Point>();
	static Scanner sc =  new Scanner(System.in);
	
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i = 0; i<n; i++) {
			String tmp = sc.next();
			for(int j = 0; j<m; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		
		
		System.out.println(visited[n-1][m-1]);
	}


	public static void bfs(int x, int y) {
		q.offer(new Point(x,y));
		visited[x][y] = 1;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < m) {
					if(map[nx][ny] == 1 && visited[nx][ny] == 0) {
						visited[nx][ny] = visited[now.x][now.y]+1;
						q.offer(new Point(nx,ny));
					}
				}
			}
					
		}
	}
}
