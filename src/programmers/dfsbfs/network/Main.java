package programmers.dfsbfs.network;

public class Main {
	 public static void main(String[] args) {
	        Solution solution = new Solution();
	        int n = 3;
	        //[[1, 1, 0], [1, 1, 0], [0, 0, 1]]
	        int[][] computers = new int[][]{{1,1,0}, {1,1,0}, {0,0,1}};
	        System.out.println(solution.solution(n, computers));
	    }
	}
class Solution {
    public int solution(int n, int[][] computers) {
    	
    	int answer = 0;
    	boolean visited[] = new boolean[computers.length];
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false){
                answer++;
                dfs(i, visited, computers);
            }            
        }
        
        return answer;
    }
    
    public void dfs(int node, boolean[] visited, int[][] computers){
    	
        visited[node] = true;
        
        for(int i = 0; i < computers.length; i++){
            if(visited[i] == false && computers[node][i] == 1){
                dfs(i, visited, computers);
            }
        }
    }   
}
