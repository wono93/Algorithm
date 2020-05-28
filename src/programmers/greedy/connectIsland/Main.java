package programmers.greedy.connectIsland;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int n = 4;
		System.out.println(solution(n, costs));
	}
	
	public static int solution(int n, int[][] costs) { // kruskal algorithm
		int answer = 0;
        int[][] adj = new int[n][n];
        
        for(int i = 0; i < costs.length; i++) {
            adj[costs[i][0]][costs[i][1]] = adj[costs[i][1]][costs[i][0]] = costs[i][2];
        }
        
        boolean[] visit = new boolean[n];
        List<Integer> connect = new ArrayList<>(n+1);
        
        connect.add(0);
        visit[0] = true;
        
        while(connect.size() < n) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int island = 0; island < connect.size(); island++) {
                int i = connect.get(island);
                for(int j = 0; j < n; j++) {
                    if(!visit[j] && i != j && adj[i][j] > 0 && adj[i][j] < min) {
                        min = adj[i][j];
                        minIdx = j;
                    }
                }
            }
            visit[minIdx] = true;
            connect.add(minIdx);
            answer += min;
        }
        
        return answer;
	        
	        
//        int answer = 0;
//        int[][] link = new int[n][n];
//        int minCost = costs[0][2];
//        int minIsland1 = costs[0][0], minIsland2 = costs[0][1];
//        
//        List<Boolean> visited = new ArrayList<>();
//        for(int i = 0; i < n; i++)
//        	visited.add(false);       
//        
//        for(int i = 0; i < costs.length; i++) {
//        	link[costs[i][0]][costs[i][1]] = costs[i][2];
//        	link[costs[i][1]][costs[i][0]] = costs[i][2];
//        	
//        	if(costs[i][2] < minCost) { // select first island
//        		minCost = costs[i][2];
//        		minIsland1 = costs[i][0];
//        		minIsland2 = costs[i][1];
//        	}
//        }      
//        
//        while(visited.contains(false)){
//        	answer += minCost;
//            visited.set(minIsland1, true);
//            visited.set(minIsland2, true);
//            minCost = (int)1e9;
//
//            for(int i = 0; i < n; i++) {
//            	if(visited.get(i) == true) {
//            		for(int j = 0; j < n; j++) {
//            			if(link[i][j] != 0 && visited.get(i)==false && minCost > link[i][j]) {
//            				minCost = link[i][j];
//            				minIsland1 = i;
//            				minIsland2 = j;
//            			}
//                    }		
//            	}
//            }
//        }
//  
//        return answer;
    }
}
