package baekjoon.binarySearch.bj2869;

import java.util.Scanner;

public class Main {
	
	static int A, B, V;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt(); // 낮에 A미터 올라감
		B = sc.nextInt(); // 밤에 B미터 미끄러짐
		V = sc.nextInt(); // 목표 높이
		
		int h = 0;
		int day = 0;
		
		while(h < V) {
			day++; // +1일
			h += A; // 낮
			if(h>=V) break; // 목표 높이에 도달할 경우 반복문 탈출
			h -= B; // 밤
		}
		
		System.out.println(day);	
	}
}