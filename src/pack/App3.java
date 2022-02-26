package pack;

public class App3 {
	private static int check(int[] ints) {
		int max_num = 1;
		for(int i=0; i<ints.length; i++) {
			if(ints[i] > max_num) {
				max_num = ints[i];
			}
		}
		return max_num - ints.length;
	}
	
	public static void main(String[] args) {
		System.out.println(check(new int[]{1, 5, 3, 2}) == 1);
		System.out.println(check(new int[]{1, 7}) == 5);
		System.out.println(check(new int[]{1, 2}) == 0);
		
	}
}
