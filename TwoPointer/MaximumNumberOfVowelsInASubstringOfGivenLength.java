package TwoPointer;

import java.util.Scanner;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(maxVowels(s, k));
        sc.close();
    }
    public static int maxVowels(String s, int k) {
        int maxCount = 0;
        int p1 = 0;
        int p2 = 0;
        int v = 0;
        while(p2<s.length()){
            if(s.charAt(p2)=='a'||s.charAt(p2)=='e'||s.charAt(p2)=='i'||s.charAt(p2)=='o'||s.charAt(p2)=='u'){
                v++;
            }
            if(p2-p1+1>k){
                if(s.charAt(p1)=='a'||s.charAt(p1)=='e'||s.charAt(p1)=='i'||s.charAt(p1)=='o'||s.charAt(p1)=='u'){
                    v--;
                }
                p1++;
            }
            if(p2-p1+1==k){
                maxCount = Integer.max(maxCount, v);
            }
            p2++;
        }
        return maxCount;
    }
}
