package baekjoon.greedy.bj5585.wono;

import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = sc.nextInt();
		int[] coin = {500, 100, 50, 10, 5, 1};
		int cnt = 0;
		int remain = 1000 - n;
		
		for(int i=0; i<coin.length; i++) {
			if(remain/coin[i] != 0) {
				cnt += remain/coin[i];
				remain = remain%coin[i];
//				System.out.println("잔금"+remain);
//				System.out.println(coin[i]+"엔 동전 : " + cnt);
			}
		}
		System.out.println(cnt);
	}
}
