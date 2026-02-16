package MonotonicQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minRemoveToMakeValid(s));
        sc.close();
    }
    public static String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='('||c==')'){
                if(c==')' && !dq.isEmpty() && s.charAt(dq.peekLast())=='('){
                    dq.removeLast();
                }
                else{
                    dq.addLast(i);
                }
            }
        }
        for(int i=0; i<s.length(); i++){
            if(!dq.isEmpty() && i==dq.peekFirst()){
                dq.removeFirst();
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}
