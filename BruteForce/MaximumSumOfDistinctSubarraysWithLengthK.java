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
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            int[] count = new int[(int) 1e5];
            for (int j = i; j < nums.length; j++) {
                count[nums[j]]++;
                sum += nums[j];
                if (count[nums[j]] > 1 || j - i + 1 > k) {
                    break;
                } else if (j - i + 1 == k) {
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}
