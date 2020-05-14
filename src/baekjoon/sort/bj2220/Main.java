package baekjoon.sort.bj2220;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	       
	        int n = sc.nextInt(); //노드의갯수 입력
	        
	        int a[] = new int[n+1]; // 이진트리 배열
	        
	        for(int i=1; i<n; i++) {
	            for(int j=i; j>1; j/=2) {
	                a[j] = a[j/2];       //자식 노드에 부모노드의 값을 대입함
	            }
	            a[1] = i+1;
	        }
	        
	        a[n] = 1; // 마지막 노드에 1이여야 가장 많이 swap이 된다.
	        
	        for(int i=1; i<=n; i++)
	            System.out.print(a[i] + " ");
	}
	
//	static Scanner sc = new Scanner(System.in);
//	static int n;
//	static int[] ns;
//	public static void main(String[] args) {
//		n = sc.nextInt();
//		ns = new int[n+1];
//		ns[0] = 0;
//		ns[1] = 1;
//		for(int i = 2; i < n+1; i++) {
//			ns[i] = i;
//			swapNs(ns, i, i-1); // V(n-1)
//			int j = i - 1; // 2
//			while(j != 1) { // V1 => root node
//				swapNs(ns, j, j/2);
//				j = j/2;
//			}
//		}
//		for(int i = 1; i < n+1; i++) {
//			System.out.print(ns[i]+" ");
//		}
//		// 4 2 3 1 + 5
//		// 4 2 3 1 5
//		// 4 2 3 5 1
//		// 4 5 3 2 1
//		// 5 4 3 2 1 + 6
//		// 5 4 3 2 1 6
//		// 5 4 3 2 6 1
//		// 5 6 3 2 4 1
//		// 6 5 3 2 4 1 
//	}
//	public static void swapNs(int[] arr, int a, int b) {
//		int tmp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = tmp;
//	}
}
