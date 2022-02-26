package pack;

public class App2 {
	private static boolean checkPassword(String s){
		
		if(s.length()<5){
			return false;
		}
		
		boolean num_flag = false;
		boolean big_flag = false;
		
		for(int i=0; i<s.length(); i++){
			char character = s.charAt(i);
			//System.out.println("character : " + character);
			
			if(!num_flag){
				num_flag = Character.isDigit(character);
				//System.out.println("num_flag : " + num_flag);
			}
			
			if(!big_flag){
				big_flag = Character.isUpperCase(character);
				//System.out.println("big_flag : " + big_flag);
			}
			
			if(num_flag && big_flag) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(checkPassword("8eqq") == false);
		System.out.println(checkPassword("password1") == false);
		System.out.println(checkPassword("password1") == true);
	}
}


