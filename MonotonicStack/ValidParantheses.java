package MonotonicStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ValidParantheses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
    public static boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                dq.push(c);
            }
            else{
                if(!dq.isEmpty() && ((c==')' && dq.peek()=='(') || (c==']' && dq.peek()=='[') || (c=='}' && dq.peek()=='{'))) {
                    dq.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(!dq.isEmpty()){
            return false;
        }
        return true;
    }
}
