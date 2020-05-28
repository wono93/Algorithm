package programmers.maidas.test1;

public class Main {
	 public static void main(String[] args) {
	        Solution solution = new Solution();
	        String[] strs = {"abcaefg", "abcdefg", "abcdhfg"};
	        System.out.println(solution.solution(strs));
	    }
}
class Solution {
	public String solution(String[] strs) {
		String answer = "";
		String temp ="";
		boolean flag =true;
			//꺼내서 추가해주기
			for(int j=0; j<strs[0].length(); j++) {
				if(flag) {
					temp += strs[0].charAt(j);
				}
				//temp와 다음배열 비교
				out:
				for(int k=1; k<strs.length; k++) {
					for(int l=0; l<temp.length(); l++) {
//							System.out.println("temp.charAt(l)="+temp.charAt(l));
//							System.out.println("strs[k].charAt(l)="+strs[k].charAt(l) +", k="+k+", l="+l);
							
						if(temp.charAt(l)!=strs[k].charAt(l)) {
//							System.out.println("temp ="+temp);
							flag=false;
							break out;
						}else {
							flag=true;
						}
					}
				}
			}
			answer = temp.substring(0,temp.length()-1);

		return answer;
	}
}
