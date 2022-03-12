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
		
		boolean isFlush = checkFlush(color);
		int straight = checkStraight(num);
		int fourCard = checkFourCard(num);
		int triple = checkTriple(num);
		int pair = checkPair(num, 1);
		int max = getMax(num);
		
		if(isFlush == true && straight > 0) {
			System.out.println(900 + straight);
		}else if(fourCard > 0) {
			System.out.println(800 + fourCard);
		}else if(triple >0 && pair > 0)	{
			System.out.println(700 + triple + 10 + pair);
		}else if(isFlush == true) {
			System.out.println(600 + max);
		}else if(straight > 0) {
			System.out.println(500 + straight);
		}else if(triple > 0) {
			System.out.println(400 + triple);
		}else if(pair > 0 && checkPair(num, pair+1) > 0) {
			System.out.println(300 + checkPair(num, pair+1) * 10 + pair);
		}else if(pair > 0) {
			System.out.println(200 + pair);
		}else {
			System.out.println(100 + max);
		}
	}
		
		
		public static boolean checkFlush(int[] color) {
			for (int i = 0; i < color.length; i++) {
				if(color[i] == 5) {
					return true;
				}
			}
			return false;
		}
		
		public static int checkStraight(int[] num) {
			int count = 0;
			for (int i = 1; i < num.length; i++) {
				if(num[i] > 0) {
					count++;
					if(count == 5) {
						return i;
					}
					else {
						count = 0;
					}
				}
			}
			return 0;
		}
		
		public static int checkFourCard(int[] num) {
			for (int i =1; i < num.length; i++) {
				if(num[i] == 4) {
					return i;
				}
			}
			return 0;
		}
		
		public static int checkTriple(int[] num) {
			for (int i =1; i<num.length; i++) {
				if(num[i] == 3) {
					return i;
				}
			}
			return 0;
		}
		
		public static int checkPair(int[] num, int start) {
			for (int i = start; i<num.length; i++) {
				if (num[i] == 2) {
					return i;
				}
			}
			return 0;
		}
		
		public static int getMax(int[] num) {
			for (int i = num.length-1; i>0; i--) {
				if(num[i] > 0) {
					return i;
				}
			}
			return 0;
		}

}
