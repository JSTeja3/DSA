package TwoPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        List<Integer> ans = findAnagrams(s, p);
        for(int v: ans){
            System.out.print(v+" ");
        }
        sc.close();
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pCount = countArray(p);
        int[] subCount = new int[26];
        int required = uniqueChar(pCount);
        int formed = 0;
        int p2 = 0;
        int p1 = 0;
        List<Integer> ans = new ArrayList<>();
        while(p2<s.length()){
            int x = s.charAt(p2)-'a';
            subCount[x]++;
            if(subCount[x]==pCount[x]){
                formed++;
            }
            while(formed==required){
                if(p2-p1+1 == p.length()){
                    ans.add(p1);
                }
                int y = s.charAt(p1)-'a';
                subCount[y]--;
                p1++;
                if(subCount[y]<pCount[y]){
                    formed--;
                }
            }
            p2++;
        }
        return ans;
    }
    public static int[] countArray(String temp){
        int[] tempCount = new int[26];
        for(int i=0; i<temp.length(); i++){
            int x = temp.charAt(i)-'a';
            tempCount[x]++;
        }
        return tempCount;
    }
    public static int uniqueChar(int[] countArray){
        int count = 0;
        for(int i=0; i<26; i++){
            if(countArray[i]>0){
                count++;
            }
        }
        return count;
    }
}
