package TwoPointer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(maximumSubarraySum(nums, k));
        sc.close();
    }
    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int p2=0; 
        int p1=0;
        while(p2<nums.length){
            map.put(nums[p2], map.getOrDefault(nums[p2], 0)+1);
            sum += nums[p2];
            while(map.get(nums[p2])>1 || map.size()>k){
                map.put(nums[p1], map.get(nums[p1]) - 1);
                if(map.get(nums[p1]) == 0){
                    map.remove(nums[p1]);
                }
                sum -= nums[p1];
                p1++;
            }
            if(map.size()==k){
                maxSum = Math.max(maxSum, sum);
            }
            p2++;
        }
        return maxSum;
    }
}
