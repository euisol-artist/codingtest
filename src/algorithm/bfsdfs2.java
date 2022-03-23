package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs2 {
	static int N, M;
	static int[][] map; //맵
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit; //방문 여부
	static int distance;
	static Queue<Position> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		visit = new int[N][M];
		queue = new LinkedList<Position>();
		
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				if(temp.charAt(j) == '1') {
					map[i][j] = 1;
				}else {
					map[i][j] = 0;
				}
			}
		}
		
		queue.add(new Position(0, 0));
		visit[0][0] = 1;
		
		while(queue.isEmpty() == false) {
			Position current = queue.poll(); //1. queue에서 꺼냄
			
			for(int i=0; i<4; i++) { //2. 연결된 길
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				
				if(targetY >= 0 && targetY < N && targetX >= 0 && targetX < M) { //3. 갈수있는 가
					if(map[targetY][targetX] == 1) {
						if(visit[targetY][targetX] == 0) {
						queue.add(new Position(targetY, targetX)); //4. q에 넣는다
						visit[targetY][targetX] = visit[current.y][current.x] + 1; //5. 방문 체크
						}
					}
				}
			}
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		
		System.out.println(visit[N-1][M-1]); //결과 출력
	}
}

class Position {
	int x;
	int y;
	int dist;
	
	public Position(int y, int x) { 
		this.y = y;
		this.x = x;
	}
	
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + ", dist=" + dist + "]";
	}
}
