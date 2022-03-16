package algorithm;

import java.util.Scanner;

public class cardgame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] color = new int[4]; //4가지 생상
		int[] num = new int[10]; //9가지 숫자
		
		for (int i=0; i<5; i++) {
			String temp = sc.next(); //String 받고 다음행으로
			char tempColor = temp.charAt(0); //int에서 char로 형변환
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
			int tempNum = sc.nextInt(); //int 받고 다음행으로
			num[tempNum]++; //중복 횟수
	}
		
		boolean isFlush = checkFlush(color);
		int straight = checkStraight(num);
		int fourCard = checkFourCard(num);
		int triple = checkTriple(num);
		int pair = checkPair(num, 1); //여러개 가능해서 시작점 만듬
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
		
		//모두 같은 색
		public static boolean checkFlush(int[] color) {
			for (int i = 0; i < color.length; i++) {
				if(color[i] == 5) {
					return true;
				}
			}
			return false;
		}
		
		//숫자가 연속적
		public static int checkStraight(int[] num) {
			int count = 0;
			for (int i = 1; i < num.length; i++) {
				if(num[i] > 0) {
					count++;
					if(count == 5) {
						return i;
					}
				}else {
					count = 0;
				}
			}
			return 0;
		}
		
		//4장의 숫자가 같음
		public static int checkFourCard(int[] num) {
			for (int i =1; i < num.length; i++) {
				if(num[i] == 4) {
					return i;
				}
			}
			return 0;
		}
		
		//3장의 숫자가 같음
		public static int checkTriple(int[] num) {
			for (int i =1; i<num.length; i++) {
				if(num[i] == 3) {
					return i;
				}
			}
			return 0;
		}
		
		//2장의 숫자가 같음 (또 다른 2장의 숫자가 같을 수 있음)
		public static int checkPair(int[] num, int start) {
			for (int i = start; i<num.length; i++) {
				if (num[i] == 2) {
					return i;
				}
			}
			return 0;
		}
		
		//가장 큰 숫자
		public static int getMax(int[] num) {
			for (int i = num.length-1; i>0; i--) {
				if(num[i] > 0) {
					return i;
				}
			}
			return 0;
		}

}
