package baekjoon.backtracking.bj15650;

import java.util.Scanner;

public class Main {
   static boolean[] visit = new boolean[10];
   static int[] Output = new int[10];
   
   static void Backtracking(int index, int N, int M) {
       if(index == M) {
           for(int i = 0; i < M; i++) {
               System.out.print(Output[i]);
               if(i != M)
                   System.out.print(' ');
           }
           System.out.println();
       }
       for(int i = 1; i <= N; i++) {
           if(visit[i]) {
               continue;
           }
           visit[i] = true;
           Output[index] = i;
           if(index == 0)	//처음 수의 경우 비교 대상이 없으니 다음단계로 넘어감
               Backtracking(index + 1, N, M);
           if(index > 0 && Output[index] > Output[index - 1]) {
           // 배열에 저장되어 있던 수와 비교하여 오름차순이 아닐경우 실행되지 않음
               Backtracking(index + 1, N, M);
           }
           visit[i] = false;
       }
       
   }
   
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
       int N = sc.nextInt();
       int M = sc.nextInt();
       Backtracking(0, N, M);
   }
}
