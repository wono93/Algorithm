package baekjoon.dynamic.bj2565;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

			static Scanner sc = new Scanner(System.in);
			
			static int n = sc.nextInt(); // 입력받을 전기줄의 수
			static int arr[][] = new int[n + 1][2]; //[][1] : A 전깃줄 번호, [][2] B 전깃줄 번호
			static int dp[] = new int[n + 1]; // 해당 위치까지의 가장 많이 설치할 수 있는 전깃줄 갯수
			static int result = 0; // 최대 설치 개수  -> 카운트
			
		public static void main(String[] args) {
			
			for(int i = 1; i <=n; i++) {
				arr[i][0] = sc.nextInt(); //a전봇대의 값
				arr[i][1] = sc.nextInt(); //b전봇대의 값
			}
			
			//[][0] 정렬 (A 전봇대 기준으로) **A전봇대를 기준으로하든 B전봇대를 기준으로하든 무관함.
			Arrays.sort(arr, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
				
					return o1[0] - o2[0];
				}
			
			});
			// 기준점으로부터 연결되어 있는 번호가 지속적으로 늘어날때만 +1해줌
			for(int i=1; i<=n; i++) {
				
				dp[i] = 1; // 1부터 시작
				
				for(int j=1; j<i; j++) {
					if(arr[j][1] < arr[i][1]) {
						//가상의 dp 배열을 생성
						dp[i] = Math.max(dp[i], dp[j] + 1);
						//dp[i]번째의 값이 dp[j+1]번째의 값보다 크면 전깃줄 개수 +1
						//dp[i]는 최대의 값이 들어감 Math.max로 인해
					}
				}
				//가장 큰 수가 result에 들어감.
				result = Math.max(result, dp[i]); //최대 전깃줄 (dp[i]를 result에 담음)
//					
			}
				System.out.println(n - result); //전체 전깃줄 - 설치할 수 있는 전깃줄 개수 = 최소로 제거해야하는 전깃줄
			
			
			
			
			
	}
}
