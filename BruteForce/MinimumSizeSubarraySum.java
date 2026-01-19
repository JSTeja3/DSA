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
        int minLength = nums.length;
        boolean valid = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    valid = true;
                    minLength = Integer.min(minLength, j - i + 1);
                }
            }
        }
        return (valid) ? minLength : 0;
    }
}