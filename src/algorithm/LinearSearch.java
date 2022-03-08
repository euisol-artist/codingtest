package algorithm;

import java.util.Scanner;

//선형 검색
public class LinearSearch {
	//n인 배열에서 key와 같은 요소를 선형 검색합니다.
	static int seqSearch(int[] a, int n, int key) {
		int i = 0;
		
		while(true) {
			if (i==n) 
				return -1;
			if (a[i] == key) 
				return i;
			i++;
		}
	}
	
//for문 사용
//	static int seqSearch(int[] a, int n, int key) {
//		for (int i = 0; i < n, i++)
//			if (a[i] == key)
//				return i;
//		return -1;
//	}
	
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("요솟수 : ");
		int num = stdIn.nextInt();
		int[] x = new int[num]; //요솟수가 num인 배열
		
		for (int i=0; i<num; i++) {
			System.out.print("x[" + i + "]:");
			x[i] = stdIn.nextInt();
		}
		
		System.out.print("검색할 값 : "); //키 값을 입력
		int ky = stdIn.nextInt();
		
		int idx = seqSearch(x, num, ky); //배열 x에서 키 값이 ky인 요소를 검색
		
		if (idx == -1)
			System.out.println("그 값의 요소가 없습니다.");
		else
			System.out.println(ky+"은(는) x[" + idx + "]에 있습니다.");
	}
}

//보초법 (맨 마지막에 보초를 세운다)
//class SeqSearchSen {
//	static int seqSearchSen(int[] a, int n, int key) {
//		int i = 0;
//		
//		a[n] = key; //보초를 추가
//		
//		while (true) {
//			if (a[i] == key) //검색 성공
//				break;
//			i++;
//		}
//		return i == n ? -1 : i;
//	}
//	
//	public static void main(String[] args) {
//		Scanner stdIn = new Scanner(System.in);
//		
//		System.out.print("요솟수: ");
//		int num = stdIn.nextInt(); //nextInt는 정수를 받는 메소드
//		int[] x = new int[num + 1]; //요솟수num + 1
//		
//		for (int i = 0; i < num; i++) {
//			System.out.print("x[" + i + "]:");
//			x[i] = stdIn.nextInt();
//		}
//		
//		System.out.print("검색할 값: "); //키 값을 입력
//		int ky = stdIn.nextInt();
//		
//		int idx = seqSearchSen(x, num, ky); //배열 x에서 값이 ky인 요소를 검색
//		
//		if (idx == -1)
//			System.out.println("그 값의 요소가 없습니다.");
//		else
//			System.out.println(ky + "은(는) x[" +idx+ "]에 있습니다.");
//	}
//}