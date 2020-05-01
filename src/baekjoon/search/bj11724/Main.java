package baekjoon.search.bj11724;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	static int n;
	static int m;

	static int result = 0;
	
	static int[][] arr;
	//정점 판별
	static boolean[] nBool;
	
	static Queue<Integer> queue = new  LinkedList<Integer>();
	
	public static void main(String[] args) {
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n+1][n+1];
		nBool = new boolean[n+1];
		
		for(int i=1; i<=m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		for(int i = 1; i<arr.length; i++) {
			if(!nBool[i]) {
				search(i);
				result++;
			}
		}
		System.out.println(result);
		
	}
	public static void search(int point) {
		nBool[point] = true;
		queue.offer(point);
		
		while(!queue.isEmpty()) {
			int i = queue.poll();
			for(int j = 1; j<arr.length; j++) {
				if(!nBool[j] && arr[i][j] == 1 ) {
					search(j);
				}
			}
		}
	}

}
