package Greedy;

import java.util.Scanner;

public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minAddToMakeValid(s));
        sc.close();
    }
    public static int minAddToMakeValid(String s) {
        int open = 0;
        int add = 0;
        for(char c: s.toCharArray()){
            if(c=='('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    add++;
                }
            }
        }
        return open+add;
    }
}
