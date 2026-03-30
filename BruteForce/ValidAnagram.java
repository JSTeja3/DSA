import java.util.Scanner;

public class ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(isAnagram(s, t));
        sc.close();
    }
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        boolean[] used = new boolean[s.length()];
        for(int i=0; i<t.length(); i++){
            boolean found = false;
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j)==t.charAt(i) && !used[j]){
                    used[j] = true;
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}
