package TwoPointer;

import java.util.Scanner;

public class LongestSubStringWORepeat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(returnLongestSubStringLength(s));
        sc.close();
    }
    public static int returnLongestSubStringLength(String s){
        int maxLength = 0;
        int p1 = 0;
        int p2 = 0;
        int[] arr = new int[256]; // Total ASCII characters
        while(p2<s.length()){
            int x = s.charAt(p2);
            arr[x]++;
            while(arr[x]>1){
                int y = s.charAt(p1);
                arr[y]--;
                p1++;
            }
            maxLength = Math.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
