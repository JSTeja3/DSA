import java.util.Scanner;

public class ValidParantheses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
    public static boolean isValid(String s){
        while(true){
            String curr = s.replace("()", "").replace("{}","").replace("[]","");
            if(curr.equals(s)){
                break;
            }
            s = curr;
        }
        return s.isEmpty();
    }
}
