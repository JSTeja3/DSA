import java.util.*;

public class LongestSubStringWORepeat {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(returnLongestSubStringLength(s));
        sc.close();
    }
    public static int returnLongestSubStringLength(String s){
        int maxLength = 0;
        int N = s.length();
        for(int i=0; i<N; i++){
            int[] arr = new int[256]; // Total ASCII characters
            for(int j=i; j<N; j++){
                int x = s.charAt(j);
                arr[x]++;
                if(arr[x]>1){
                    break;
                }
                else{
                    maxLength = Math.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}
