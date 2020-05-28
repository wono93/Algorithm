package programmers.summerCoding.test1;


public class Main {

	 public static void main(String[] args) {
	        Solution solution = new Solution();
	        int p = 1987;
	        System.out.println(solution.solution(p));
	    }
	}
class Solution {
	public static int solution(int p) {
		int answer = 0;
		while(true) {
			p++;
			String s = Integer.toString(p);
			out:
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < s.length(); j++) {
					if(j == i) continue;
					if(s.charAt(i) == s.charAt(j)) break out;
					if(i == s.length()-1 && j == s.length()-2) answer = p;
				}
			}
			if(answer != 0) return answer;
		}
	}
//    public int solution(int p) {
//    	int answer = 0;
//    	boolean flag = false;
//    	
//    	p++;
//    	
//    	check(p, flag);
//    	if(flag) answer = p;
//        return answer;
//    }
//
//	public void check(int p,boolean flag) {
//		String str;
//		str = Integer.toString(p);
//		for(int i=0; i<4; i++) {
//			for(int j=1; j<4; j++) {
//				if(str.charAt(i)==str.charAt(j)) {
//					p++;
//				}
//				else {
//					flag = true;
//					break;
//				}
//			}
//		}
//		
//	}
}
