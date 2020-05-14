package baekjoon.array.bj2798;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //카드의 갯수
        int N = sc.nextInt();
        //블랙잭 요구의 수
        int M = sc.nextInt();
        int[] cards = new int[N];
        for(int i=0; i<N; i++) {
        	cards[i] = sc.nextInt();
        }
        int max = 0;
        outline : for(int i=1; i<N; i++) {
        	for(int j=i+1; j<N; j++) {
        		for(int k=j+1; k<N; k++) {
        			int sum = cards[i] + cards[j] + cards[k];
        			if(sum <= M) {
        				max = Math.max(max, sum);
        			}
        			if(max == M) {
        				break outline;
        			}
        		}
        	}
        }
        System.out.println(max);
	}
}
