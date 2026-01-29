package TwoPointer;

import java.util.Scanner;

/*  Try this method after solving problem "CountSubarrayWithSumatmostK" */
/* Works only for non-negative numbers only */
public class SubarraySumOfK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarraySum(nums, k)-subarraySum(nums, k-1));
        sc.close();
    }
    public static int subarraySum(int[] nums, int k){
        if(k<0){
            return 0; // Edge case
        }

        int count = 0;
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            sum += nums[p2];
            while(sum>k){
                sum -= nums[p1];
                p1++;
            }
            count += p2-p1+1;
            p2++;
        }
        return count;
    }
}
