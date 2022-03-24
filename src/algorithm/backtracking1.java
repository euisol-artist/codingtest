package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class backtracking1 {
	static int L, C;
	static char[] data;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		L = sc.nextInt();
		C = sc.nextInt();
		
		data = new char[C];
		
		for(int i = 0; i < C; i++) {
			String temp = sc.next();
			data[i] = temp.charAt(0);
		}
		
		Arrays.sort(data);
		
		dfs(' ', 0, 0, 0, "");
	}
	
	static void dfs(char current, int depth, int mo, int ja, String pwd) {
		//1. 도착
		if(depth == L) {
			if(mo >= 1 && ja >= 2) {
				System.out.println(pwd);
			}
			return;
		}
		//2. 연결된 길
		for(int i = 0; i < C; i++) {
			//3. 갈 수 있는가
			if(data[i] > current) {
				//4. 간다
				if(data[i] == 'a' || data[i] == 'e' || data[i] == 'o' || data[i] == 'i' || data[i] == 'u') {
					dfs(data[i], depth + 1, mo + 1, ja, pwd + data[i]);
				}else {
					dfs(data[i], depth + 1, mo, ja + 1, pwd + data[i]);
				}
			}
		}
	}
	
}
