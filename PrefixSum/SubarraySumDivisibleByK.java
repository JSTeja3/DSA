package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySumDivisibleByK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraysDivByK(nums, k));
        sc.close();
    }
    public static int subarraysDivByK(int[] nums, int k) {
        int currSum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            int temp = ((currSum%k)+k)%k; //for all numbers including negative numbers
            if(map.containsKey(temp)){
                count += map.get(temp);
            }
            map.put(temp, map.getOrDefault(temp, 0)+1);
        }
        return count;
    }
}
