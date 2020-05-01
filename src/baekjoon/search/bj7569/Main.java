package baekjoon.search.bj7569;

//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.*;
//	 
//public class Main {
//	
//	    //3차원 이므로 x,y,z 방향으로 움직이는 배열을 만든다.
//	    static int[] dz = {0,0,0,0,1,-1};
//	    static int[] dx = {-1,1,0,0,0,0};
//	    static int[] dy = {0,0,-1,1,0,0};
//	    static int x,y,z;
//	    static int[][][] map;
//	    static boolean[][][] visited;
//	    static Queue<dot> tomato = new LinkedList<dot>();
//	    static int day = 0;
//	    static boolean flag = true;
//	    
//	    public static void main(String[] args) throws Exception {
//	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	        
//	        String[] str = br.readLine().split(" ");
//	        
//	        y = Integer.parseInt(str[0]);
//	        x = Integer.parseInt(str[1]);
//	        z = Integer.parseInt(str[2]);
//	        
//	        map = new int[z][x][y];
//	        visited = new boolean[z][x][y];
//	        
//	        for(int i=0; i<z; i++) {
//	            for(int j=0; j<x; j++) {
//	                str = br.readLine().split(" ");
//	                for(int k=0; k<y; k++) {
//	                    map[i][j][k] = Integer.parseInt(str[k]);
//	                    
//	                    if(map[i][j][k] == 1) {
//	                        tomato.add(new dot(j,k,i));
//	                    }
//	                }
//	            }
//	        }
//	        //while문을 한 번 도는게 1일이 지나는거라고 하자.
//	        //토마토는 한 번에 하루가 지나면 주변으로 퍼지기 때문에 미리 Queue에 토마토를 추가하였다.
//	        //bfs를 했는데 Queue의 사이즈가 0이 된다면, 이는 더 이상 익게 할 수 있는 토마토가 없다는 뜻이다.
//	        //flag를 변경해서 while문을 벗어날 수 있도록한다. 
//	        //이 flag는 안 익은 토마토가 있을 수도 있기 때문에 check를 통해 한 번 더 확인해준다.
//	        while(true) {        
//	            bfs(tomato);
//	            if(!flag) {
//	                break;
//	            }
//	            day++;
//	        }
//	        check();
//	    }
//	    
//	    static void bfs(Queue<dot> tomato) {
//	        int size = tomato.size();
//	        
//	        for(int i=0; i<size; i++) {
//	            dot d = tomato.poll();
//	            int x1 = d.x;
//	            int y1 = d.y;
//	            int z1 = d.z;
//	            
//	            for(int j=0; j<6; j++) {
//	                int x2 = x1 + dx[j];
//	                int y2 = y1 + dy[j];
//	                int z2 = z1 + dz[j];
//	                //익게 할 수 있는 토마토가 있다면 토마토 Queue에 추가해준다.
//	                if(z2>=0 && z2<z && x2>=0 && x2<x && y2>=0 && y2<y && map[z2][x2][y2] == 0) {
//	                    map[z2][x2][y2] = 1;
//	                    tomato.add(new dot(x2,y2,z2));
//	                }
//	            }
//	        }
//	        
//	        if(tomato.size() == 0) {
//	            flag = false;
//	            return;
//	        }
//	    }
//	    //익지 않은 토마토가 있다면 -1을 출력하고, 아니라면 day를 출력해준다.
//	    public static void check() {
//	        for(int i=0; i<z; i++) {
//	            for(int j=0; j<x; j++) {
//	                for(int k=0; k<y; k++) {
//	                    if(map[i][j][k] == 0) {
//	                        System.out.println(-1);
//	                        return;
//	                    }
//	                }
//	            }
//	        }
//	        
//	        System.out.println(day);
//	    }
//	}
//	 
//	class dot {
//	    int x;
//	    int y;
//	    int z;
//	    
//	    public dot(int x,int y,int z) {
//	        this.x = x;
//	        this.y = y;
//	        this.z = z;
//	    }
//	}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, H, count, day;
	static int[][][] arr;
	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();
	static Queue<Integer> q3 = new LinkedList<Integer>();
	static int[] dx = { 0, -1, 0, 1, 0, 0 };
	static int[] dy = { 1, 0, -1, 0, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		StringTokenizer st = new StringTokenizer(str, " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		count = N * M * H;

		arr = new int[N + 1][M + 1][H + 1];

		for (int k = 0; H > k; ++k) {
			for (int i = 0; N > i; ++i) {
				str = br.readLine();
				st = new StringTokenizer(str, " ");
				for (int j = 0; M > j; ++j) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		bfs();

	}

	public static void bfs() {

		for (int i = 0; N > i; ++i) {
			for (int j = 0; M > j; ++j) {
				for (int k = 0; H > k; ++k) {
					if (arr[i][j][k] == 1) {
						--count;
						q1.add(i);
						q2.add(j);
						q3.add(k);
					} else if (arr[i][j][k] == -1) {
						--count;
					}
				}
			}
		}

		while (!q1.isEmpty()) {
			int x = q1.poll();
			int y = q2.poll();
			int z = q3.poll();

			for (int i = 0; 6 > i; ++i) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx >= 0 && ny >= 0 && nx <= N - 1 && ny <= M - 1 && nz >= 0 && nz <= H - 1) {
					if (arr[nx][ny][nz] == 0) {
						q1.add(nx);
						q2.add(ny);
						q3.add(nz);
						arr[nx][ny][nz] = arr[x][y][z] + 1;
						day = arr[x][y][z];
						--count;
					}
				}
			}
		}

		if (count == 0) {
			System.out.print(day);
		} else if (count > 0) {
			System.out.print("-1");
		}

	}

}
