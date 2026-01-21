package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubArraySumK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(longestSubarray(arr, K));
        sc.close();
    }
    public static int longestSubarray(int[] arr, int k) {
        int currSum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        
        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
            if(map.containsKey(currSum-k)){
                int temp = map.get(currSum-k);
                maxLength = Integer.max(maxLength, i-temp);
            }
            if(!map.containsKey(currSum)){
                map.put(currSum, i);
            }
        }
        
        return maxLength;
    }
}
