package baekjoon.greedy.bj1931;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[][] rArr = new int[n][2]; 
		
		for(int i = 0; i<n; i++) {
			rArr[i][0] = sc.nextInt();
			rArr[i][1] = sc.nextInt();
		}
		//2차원배열 정렬(람다식)
		//종료시간 오름차순, 시작시간이 같은경우도 오름차순
		//종료시간이 같으면 시작시간을 비교?
		Arrays.sort(rArr, (o1,o2)->{
			if(o1[1] == o2[1])
				return Integer.compare(o1[0], o2[0]);
			else
				return Integer.compare(o1[1], o2[1]);
		});
		
		int min = -1;
		
		int result = 0;
		
		for(int i=0; i<n; i++) {
			if(rArr[i][0] >= min) {
				min = rArr[i][1];
				result++;
			}
		}
		System.out.println(result);
	}
}
