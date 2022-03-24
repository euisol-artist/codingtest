package algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsdfs4 {
	static int N, K;
	static int[] visit;
	static Queue<Integer> queue;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		visit = new int[100001];
		queue = new LinkedList<Integer>();
		queue.add(N);
		
		while(queue.isEmpty() == false) {
			//1. queue에 poll
			int current = queue.poll();
			
			//목적지 인가?
			if(current == K) {
				System.out.println(visit[current]);
				break;
			}
			
			//2. 연결된 길 -> 갈 수 있는 길 -> queue.add -> 방문체크
			if(current - 1 >= 0 && current - 1 != N && visit[current - 1] == 0) {
				queue.add(current - 1);
				visit[current - 1] = visit[current] + 1;
			}
			
			if(current + 1 <= 100000 && current + 1 != N && visit[current + 1] == 0) {
				queue.add(current + 1);
				visit[current + 1] = visit[current] + 1;
			}
			
			if(current * 2 <= 100000 && current * 2 != N && visit[current * 2] == 0) {
				queue.add(current * 2);
				visit[current * 2] = visit[current] + 1;
			}
		}
	}
}
