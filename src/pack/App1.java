package pack;

public class App1 {
    private static boolean solve(String a, String b){
        int a_length = a.length();
        String temp = "";

        for(int i=0; i<a_length; i++){
            //System.out.println("a.substring(i) : " + a.substring(i));
            //System.out.print("a.substring(i) : " + a.substring(0,i));

            temp = a.substring(i) + a.substring(0,i);
            //System.out.println("temp : " + temp);

            if(temp.equals(b)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(solve("abc", "bca") == true);
        System.out.println(solve("abcd", "abcd") == true);
        System.out.println(solve("abcde", "abced") == false);
    }
}