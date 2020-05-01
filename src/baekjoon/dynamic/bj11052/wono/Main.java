package baekjoon.dynamic.bj11052.wono;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n = sc.nextInt();
		int[] p = new int[n+1];
		int[] result = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			p[i] = sc.nextInt();
		}
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				int tmp = p[j] + result[i-j];
				result[i] = (result[i] >= tmp)?result[i]:tmp;
			}
		}
		System.out.println(result[n]);
	}
}
