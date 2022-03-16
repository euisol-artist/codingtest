package algorithm;

import java.util.Scanner;

public class bfsdfs {
	static int T,N,M,K; //테스트개수, 가로길이, 세로길이, 위치의 개수
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int count; //최소 개수
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		for (int t = 0; t < T; t++) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();
			
			map = new int[N][M];
			count = 0;
			
			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[x][y] = 1;
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if(map[y][x] == 1) { //배추 발견
						dfs(y, x);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	public static void dfs(int y, int x) {
		map[y][x] = 2; //확인한 배추는 2로 수정
		for (int i = 0; i < 4; i++) {
			int targetY = y + dy[i];
			int targetX = x + dx[i];
			
			if(targetY >= 0 && targetY < N && targetX >= 0 && targetX < M) {
				if(map[targetY][targetX] == 1) { //주변에 배추 있으면 다시 반복
					dfs(targetY, targetX);
				}
			}
		}
	}

}
