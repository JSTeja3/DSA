import java.util.*;

public class MinimumWindowSubstring{
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
        for(int i=0; i<s.length(); i++){ 
            int[] subCount = new int[256]; 
            for(int j=i; j<s.length(); j++){ 
                subCount[s.charAt(j)]++; 
                if(foundtstring(tCount, subCount) && (j-i+1)<minLength){ 
                    minLength = j-i+1; minSubString = s.substring(i,j+1); 
                } 
            }
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
    public static boolean foundtstring(int[] tCount, int[] subCount){ 
        for(int i=0; i<256; i++){ 
            if(tCount[i]>subCount[i]){ 
                return false; 
            } 
        } 
        return true; 
    }
}