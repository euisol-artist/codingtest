package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs2 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit;
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
			Position current = queue.poll(); //queue에서 꺼냄
			
			for(int i=0; i<4; i++) {
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				
				if(targetY >= 0 && targetY < N && targetX >= 0 && targetX < M) {
					if(map[targetY][targetX] == 1) {
						if(visit[targetY][targetX] == 0) {
						queue.add(new Position(targetY, targetX));
						visit[targetY][targetX] = visit[current.y][current.x] + 1;
					}
				}
			}
		}
	}
		for(int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(visit[i]));
		}
		
		System.out.println(visit[N-1][M-1]);
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
