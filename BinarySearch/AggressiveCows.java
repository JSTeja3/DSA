package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stalls = new int[N];
        for (int i = 0; i < N; i++) {
            stalls[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(aggressiveCows(stalls, k));
        sc.close();
    }
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int low = 1;
        int high = stalls[stalls.length-1]-stalls[0];
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(countCows(mid, stalls, k)){
                low = mid+1;
                ans = mid;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    public static boolean countCows(int d, int[] stalls, int k){
        int temp = stalls[0];
        int reqK = 1;
        for(int i=1; i<stalls.length; i++){
            if(stalls[i]-temp >= d){
                reqK++;
                temp = stalls[i];
            }
        }
        return reqK>=k;
    }
}
