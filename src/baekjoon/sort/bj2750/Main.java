package baekjoon.sort.bj2750;

import java.util.Scanner;

public class Main {

	static int n;
	static int[] num;
	static int temp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		num = new int[n];
		for(int i=0; i<n; i++) {
			num[i] = sc.nextInt();
			
		}
		for(int j=num.length; j>0; j--) {
			for(int i=0; i<j-1; i++) {
				if(num[i]>num[i+1]) {
					temp = num[i];
					num[i] = num[i+1];
					num[i+1] = temp;
				}
			}
		}
		for(int i=0; i<num.length; i++) {
			System.out.println(num[i]);
		}
	}

}
