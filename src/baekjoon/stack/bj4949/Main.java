package baekjoon.stack.bj4949;

import java.util.Scanner;
import java.util.Stack;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//input에 예제 한줄씩 입력받고 .가 나오면 입력을 종료한다
		while (true) {	
			String input = sc.nextLine();
			if (input.equals(".")) {
				break;
			}
			//스택생성
			Stack<Character> stack = new Stack<>();
			//문자열 길이만큼 반복
			for (int i = 0; i < input.length(); i++) {
				//인덱스값에 ( 가 있으면 ( 값을 스택에 넣는다
				if (input.charAt(i) == '(') {
					stack.push('(');		
				}
				//인덱스값에 [ 가 있으면 [ 값을 스택에 넣는다
				else if (input.charAt(i) == '[') {
					stack.push('[');
				}
				//1. 인덱스값에 ) 가 있을 때
				else if (input.charAt(i) == ')') {				
					//1-1. 스택의 사이즈가 0이 아니면서 스택의 맨 위에 있는 값이 ( 라면 스택에서 ( 를 제거한다
					if (stack.size() !=0 && stack.peek() == '(') {
						stack.pop();
					}
					//1-2. 그게 아니라면 ) 를 스택에 넣는다 => 균형 X
					else {
						stack.push(')');
						break;
					}
				}
				//2. 인덱스값에 ] 가 있을 때
				else if (input.charAt(i) == ']') {
					//2-1. 스택의 사이즈가0이 아니면서 스택의 맨 위에있는 값이 [ 라면 스택에서 [ 를 제거한다
					if (stack.size() != 0 && stack.peek() == '[') {
						stack.pop();
					}
					//2-2. 그게 아니라면 ]를 스택에 넣는다 => 균형 X
					else {
						stack.push(']');
						break;
					}
				}
			}
			//결과 출력부분
			//위의 조건문 1-1, 2-1에 의하여 (), [] 짝이 맞으면 스택에서 제거되었으므로 스택이 비어있다
			if (stack.isEmpty()) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
