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
                if(c==k){ 
                    maxLength = Math.max(maxLength, j-i+1); 
                } 
            } 
        } 
        return maxLength; 
    }
}
