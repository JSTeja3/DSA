package TwoPointer;

import java.util.Scanner;

public class LongestSubStringKDistinct {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(longestKSubstr(s, k));
        sc.close();
    }
    public static int longestKSubstr(String s, int k) {
        // code here
        int maxLength = -1;
        int p1 = 0;
        int p2 = 0;
        int[] arr = new int[26];
        int c = 0;
        while(p2<s.length()){
            int x = s.charAt(p2)-'a';
            arr[x]++;
            if(arr[x]==1){
                c++;
            }
            while(c>k){
                int y = s.charAt(p1)-'a';
                arr[y]--;
                if(arr[y]==0){
                    c--;
                }
                p1++;
            }
            if(c==k){
                maxLength = Math.max(maxLength, p2-p1+1);
            }
            p2++;
        }
        return maxLength;
    }
}

