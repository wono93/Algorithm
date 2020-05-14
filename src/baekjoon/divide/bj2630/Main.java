package baekjoon.divide.bj2630;

import java.util.Scanner;

public class Main {
	static boolean[][] map;
	static int white, blue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		map = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.next().equals("1");
			}
		}
		divide(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

	static void divide(int x, int y, int n) {
		if(n==1) {
			if(map[y][x]) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		
		boolean sameColor = true;
		boolean color = map[y][x];
		
		out:
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[y+i][x+j] != color) {
					sameColor = false;
					break out;
				}
			}
		}
		
		if(sameColor) {
			if(map[y][x]) {
				blue++;
			}else {
				white++;
			}
			return;
		}
		divide(x, y, n/2);
		divide(x+n/2, y, n/2);
		divide(x, y+n/2, n/2);
		divide(x+n/2, y+n/2, n/2);
	}

}
