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
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == goal) {
                    count++;
                }
            }
        }
        return count;
    }
}
