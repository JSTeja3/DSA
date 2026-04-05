package TwoPointer;

import java.util.Scanner;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(minSubArrayLen(target, nums));
        sc.close();
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            sum += nums[p2];
            while (sum >= target) {
                minLength = Math.min(minLength, p2 - p1 + 1);
                sum -= nums[p1];
                p1++;
            }
            p2++;
        }
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
