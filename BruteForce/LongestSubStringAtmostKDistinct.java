import java.util.Scanner;

public class LongestSubStringAtmostKDistinct {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(kDistinctChars(s, k));
        sc.close();
    }
    public static int kDistinctChars(String s, int k) { 
        int maxLength = -1; 
        for(int i=0; i<s.length(); i++){
            int c = 0; 
            int[] arr = new int[256]; 
            for(int j=i; j<s.length(); j++){
                int x = s.charAt(j); 
                arr[x]++; 
                if(arr[x]==1){ 
                    c++; 
                } 
                if(c>k){ 
                    break; 
                } 
                    maxLength = Math.max(maxLength, j-i+1); 
            } 
        } 
        return maxLength; 
    }
}
