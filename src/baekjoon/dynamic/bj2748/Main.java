package baekjoon.dynamic.bj2748;

import java.util.Scanner;

public class Main {
/*
 * 0 : 0,
 * 1 : 1,
 * -------
 * 2 : 1,
 * 3 : 2,
 * 4 : 3,
 * 5 : 5,
 * 6 : 8
 */
	
	static Scanner sc = new Scanner(System.in);
	static long[] temp = new long[91];
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		
		temp[0] = 0;
		temp[1] = 1;
		
		for(int i=2; i<=n; i++)
			temp[i] = temp[i-1] + temp[i-2];
		
		System.out.println(temp[n]);
		
//		long fn = 0;
//		long fn_1 = 0;
//		long fn_2 = 0;
//	
//		if(n > 0 && n <= 90) {
//			if(n == 1) fn = 1;
//			else {
//				fn_1 = 1;
//				
//				for(int i=2; i<= n; i++) {
//					fn = fn_1 + fn_2;
//					fn_2 = fn_1;
//					fn_1 = fn;
//				}
//			}
//			System.out.println(fn);
//		}
	}
}
