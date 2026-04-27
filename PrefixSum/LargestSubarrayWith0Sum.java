package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LargestSubarrayWith0Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxLength(arr));
        sc.close();
    }
    public static int maxLength(int arr[]) {
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength, i-map.get(sum));
            }
            else{
                map.put(sum, i);
            }
        }
        return maxLength;
    }
}
