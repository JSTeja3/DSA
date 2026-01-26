package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSubarrayWithGivenXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarrayXor(nums, k));
        sc.close();
    }
    public static long subarrayXor(int arr[], int k) {
        int count = 0 ;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<arr.length; i++){
            xor ^= arr[i];
            if(map.containsKey(xor^k)){
                count += map.get(xor^k);
            }
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }
        return count;
    }
}
