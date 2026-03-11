package PrefixSum;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(checkSubarraySum(nums, k));
        sc.close();
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            int temp = currSum%k;
            if(map.containsKey(temp)){
                if(i-map.get(temp)>1){
                    return true;
                }
            } 
            else{
                map.put(temp, i);
            }
        }
        return false;
    }
}
