package TwoPointer;

import java.util.Scanner;

public class MinimumWindowSubstring {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(minWindow(s, t));
        sc.close();
    }
    public static String minWindow(String s, String t) {
        int[] tCount = countArray(t);
        int minLength = s.length()+1;
        String minSubString = "";
        int[] subCount = new int[256];
        int p1=0;
        int p2=0;
        int required = uniqueChar(tCount);
        int formed = 0;

        while(p2<s.length()){  
            int x = s.charAt(p2);
            subCount[x]++;
            if(subCount[x]==tCount[x]){
                formed++;
            }
            while(formed==required){
                if(minLength>(p2-p1+1)){
                    minSubString = s.substring(p1, p2+1);
                    minLength = p2-p1+1;
                }
                int y = s.charAt(p1);
                subCount[y]--;
                p1++;
                if(subCount[y]<tCount[y]){
                    formed--;
                }
            }
            p2++;
        }
        return minSubString;

    }
    public static int[] countArray(String temp){
        int[] tempArray = new int[256];
        for(int i=0; i<temp.length(); i++){
            int x = temp.charAt(i);
            tempArray[x]++;
        }
        return tempArray;
    }
    public static int uniqueChar(int[] tCount){
        int uniqueCount = 0;
        for(int i=0; i<256; i++){
            if(tCount[i]>0){
                uniqueCount++;
            }
        }
        return uniqueCount;
    }
}
