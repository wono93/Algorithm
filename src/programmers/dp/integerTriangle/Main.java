package programmers.dp.integerTriangle;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution.solution(triangle));
    }
}
class Solution {
    public int solution(int[][] triangle) {
    	int[][] dp = new int[triangle.length][triangle.length];
    	
    	dp[0][0] = triangle[0][0];
    	
    	for(int i=1; i<triangle.length; i++) {
    		//dp에 왼쪽 끝 값 누적시키기
    		dp[i][0] = dp[i-1][0] + triangle[i][0];
    		//dp에 오른쪽 끝 값 누적시키기
    		dp[i][i] = dp[i-1][i-1] + triangle[i][i];
    	}
    	//dp에 중간 값 누적시키기
    	for(int i=2; i<triangle.length; i++) {
    		for(int j=1; j<i; j++) {
    			dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
    		}
    	}
    	
    	int answer = dp[dp.length-1][0];
    	for(int i=1; i<triangle.length; i++) {
    		int num = dp[dp.length-1][i];
    		if(answer<num)
    			answer = num;
    	}
    	
    	return answer;
//        int[][] copyTriangle = new int[triangle.length][triangle.length];
//
//        copyTriangle[0][0] = triangle[0][0];
//        for (int i = 1; i < triangle.length; i++) {
//            copyTriangle[i][0] = copyTriangle[i - 1][0] + triangle[i][0];
//            copyTriangle[i][i] = copyTriangle[i - 1][i - 1] + triangle[i][i];
//        }
//
//        for (int i = 2; i < triangle.length; i++) {
//            for (int j = 1; j < i; j++) {
//                copyTriangle[i][j] = Math.max(copyTriangle[i - 1][j - 1], copyTriangle[i - 1][j])
//                    + triangle[i][j];
//            }
//        }
//
//        int maxNo = copyTriangle[copyTriangle.length - 1][0];
//        for (int i = 1; i < triangle.length; i++) {
//            int checkNo = copyTriangle[copyTriangle.length - 1][i];
//            if (maxNo < checkNo) {
//                maxNo = checkNo;
//            }
//        }
//        return maxNo;
    }
}