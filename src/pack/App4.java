package pack;

public class App4 {
	private static int solution(int[] A) {
		int answer = 0; //return을 위한 변수 생성
		
		for(int i=0; i<A.length; i++) {
			for(int j=(i+1); j<A.length; j++) {
				if(A[i]+A[j]==0) {
					if(answer<Math.abs(A[i])) {
						answer=Math.abs(A[i]);
						break;
					}
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int A[] = {3,2,-2,5,-5};
		int B[] = {1,1,2,-1,2,-1};
		int C[] = {1,2,3,-4};
		System.out.println(solution(A));
		System.out.println(solution(B));
		System.out.println(solution(C));
		
	}

}
