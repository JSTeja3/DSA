package TwoPointer;

import java.util.Scanner;

public class LongestSubarrayWithSumAtmostK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestSubarrayAtmostKSum(nums, k));
        sc.close();
    }
    public static int longestSubarrayAtmostKSum(int[] nums, int k){
        int maxLength = 0;
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            sum += nums[p2];
            while(sum > k){
                sum -= nums[p1];
                p1++;
            }
            maxLength = Integer.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
