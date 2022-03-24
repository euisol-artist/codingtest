package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs5 {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[][] visit;
	static int max;
	static Queue<Position> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		
		map = new int[N][M];
		visit = new int[N][M];
		queue = new LinkedList<Position>();
		
		//시작할 수 있는 곳 모두 queue에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					queue.add(new Position(i, j));
				}
			}
		}
		
		while(queue.isEmpty() == false) {
			//1. queue에 poll
			Position current = queue.poll();
			
			//2. 연결 된 길
			for (int i = 0; i < 4; i++) {
				int targetY = current.y + dy[i];
				int targetX = current.x + dx[i];
				
				//3. 갈수있는가
				if(targetY >= 0 && targetY < N && targetX >= 0 && targetX < M) {
					if(map[targetY][targetX] == 0) {
						//4. queue에 add
						queue.add(new Position(targetY, targetX));
						//5. 방문체크
						map[targetY][targetX] = map[current.y][current.x] + 1;
					}
				}
			}
		}
		
		//답 출력
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 0) {
					max = -1;
					break;
				}
				if(map[y][x] > max) {
					max = map[y][x];
				}
			}
			if(max == -1) {
				break;
			}
		}
		
		if(max == -1) {
			System.out.println(max);
		}else {
			System.out.println(max-1);
		}

	}
}
