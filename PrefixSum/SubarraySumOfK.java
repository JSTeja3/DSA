package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumOfK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraySum(nums, k));
        sc.close();
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int currSum = 0;
        map.put(0, 1);
        for(int i=0; i<nums.length; i++){
           currSum += nums[i];
           if(map.containsKey(currSum-k)){
            count += map.get(currSum-k);
           }
           map.put(currSum, map.getOrDefault(currSum, 0)+1);
        }
        return count;
        
    }
}
