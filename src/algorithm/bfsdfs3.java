package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs3 {
	static int N, M, S;
	static int[][] map;
	static boolean[] visitedBFS;
	static boolean[] visitedDFS;
	static int[] historyBFS;
	static int[] historyDFS;
	static int count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); //정점
		M = sc.nextInt(); //간선
		S = sc.nextInt(); //시작점
		
		map = new int[N + 1][N + 1];
		
		visitedBFS = new boolean[N + 1];
		visitedDFS = new boolean[N + 1];
		historyBFS = new int[N + 1];
		historyDFS = new int[N + 1];
		
		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		count = 1;
		dfs(S);
		
		for (int i = 1; i <= N; i++) {
			System.out.print(historyDFS[i] + " ");
		}
		System.out.println();
		
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		count = 1;
		queue.add(S);
		
		visitedBFS[S] = true;
		historyBFS[count++] = S;
		
		while(queue.isEmpty() == false) {
			//1. 가져오기
			int current = queue.poll();
			//2. 연결된 길
			for (int i = 1; i <= N; i++) {
				//3. 갈 수 있는가?
				if(map[current][i] == 1 && visitedBFS[i] == false) {
					//4. q에 넣음
					queue.add(i);
					//5. 방문체크
					visitedBFS[i] = true;
					historyBFS[count++] = i;
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(historyBFS[i] + " ");
		}
		System.out.println();
	}
	
	static void dfs(int current) {
		//1. 방문체크
		visitedDFS[current] = true;
		historyDFS[count++] = current;
		//2. 연결된 길
		for(int i = 1; i <= N; i++) {
			//3. 갈 수 있는가?
			if(map[current][i] == 1 && visitedDFS[i] == false) {
				//4. 간다
				dfs(i);
			}
		}
	}
	
}
