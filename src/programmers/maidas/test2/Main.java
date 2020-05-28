package programmers.maidas.test2;

public class Main {

	public static void main(String[] args) {
		int x = -1;
		int y = 2;
		int r = 2;
		int d = 60;
		int[][] target = {{0, 1}, {-1, 1}, {1, 0}, {-2, 2}};
		System.out.println(solution(x, y, r, d, target));
	}
	public static int solution(int x, int y, int r, int d, int[][] target) {
		int ans = 0;
		int meX = x;
		int meY = y;
		
		for(int i = 0; i < target.length; i++) {
			int enemyX = target[i][0];
			int enemyY = target[i][1];
			double distance = Math.sqrt(enemyX*enemyX+enemyY*enemyY);
//		System.out.println(distance);
			
			double a = ((enemyX*meX+enemyY*meY))/Math.sqrt(Math.abs(enemyX*enemyX))*Math.sqrt(Math.abs(meX*meY));
			double b = Math.cos(d/2);
//		System.out.println(a);
//		System.out.println(b);
			if(a >= b && distance <= r) ans++;
		}
		
		return ans;
	}
}
