import java.util.Scanner;

public class ValidPalindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
        sc.close();
    }
    public static boolean isPalindrome(String s) {
        StringBuilder alphaString = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                alphaString.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        s = alphaString.toString();
        return s.equals(alphaString.reverse().toString());
    }
}
