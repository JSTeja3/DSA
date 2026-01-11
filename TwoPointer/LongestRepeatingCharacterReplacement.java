package TwoPointer;

import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(characterReplacement(s, k));
        sc.close();
    }
    public static int characterReplacement(String s, int k) {
        int maxLength = 0;
        int maxRepeat = 0;
        int[] count = new int[26];
        int p2 = 0;
        int p1 = 0;
        while(p2<s.length()){
            int x = s.charAt(p2)-'A';
            count[x]++;
            if(count[x]>maxRepeat){
                maxRepeat = count[x];
            }
            /* keeping maxRepeat stale for few iterations is fine instead of 
            constantly updating it, as it wouldn't affect the final maxLength
            (try tracing few few examples to understand better) */    
            while(((p2-p1+1)-maxRepeat)>k){
                int y = s.charAt(p1)-'A';
                count[y]--; 
                p1++;
            }
            maxLength = Math.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
