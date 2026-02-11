package MonotonicDeque;

import java.util.*;

public class RemoveKDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(removeKdigits(num, k));
        sc.close();
    }
    public static String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<num.length(); i++){
            while(!dq.isEmpty() && dq.peekLast()>num.charAt(i) && k>0){
                dq.removeLast();
                k--;
            }
            dq.addLast(num.charAt(i));
        }
        while(!dq.isEmpty() && k>0){
            dq.removeLast();
            k--;
        }
        StringBuilder ans = new StringBuilder();
        while(!dq.isEmpty()){
            ans.append(dq.removeFirst());
        }
        int i = 0;
        while(i<ans.length() && ans.charAt(i)=='0'){
            i++;
        }
        return (i==ans.length())?"0":ans.substring(i);
    }
}
