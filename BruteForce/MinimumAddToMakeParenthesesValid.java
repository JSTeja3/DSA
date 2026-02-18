import java.util.Scanner;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minAddToMakeValid(s));
        sc.close();
    }
    public static int minAddToMakeValid(String s){
        int count = 0;
        boolean[] mark = new boolean[s.length()];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==')'){
                mark[i] = true;
                boolean found = false; 
                for(int j=i-1; j>=0; j--){
                    if(s.charAt(j)=='(' && !mark[j]){
                        mark[j] = true;
                        found = true;
                        break;
                    }
                }
                if(!found){
                    count++;
                }
            }
        }
        for(int i=0; i<mark.length; i++){
            if(!mark[i]){
                count++;
            }
        }
        return count;
    }
}
