package algorithm;

import java.util.Scanner;

public class cardgame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] color = new int[4];
		int[] num = new int[10];
		
		for (int i=0; i<5; i++) {
			String temp = sc.next(); //다음행으로
			char tempColor = temp.charAt(0);
			switch(tempColor) {
			case 'R':
				color[0]++;
				break;
			case 'B':
				color[1]++;
				break;
			case 'Y':
				color[2]++;
				break;
			case 'G':
				color[3]++;
				break;
		}
			int tempNum = sc.nextInt();
			num[tempNum]++;
	}

}
