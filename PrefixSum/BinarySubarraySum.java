package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BinarySubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        System.out.println(numSubarraysWithSum(nums, goal));
        sc.close();
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-goal)){
                count += map.get(sum-goal);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}
