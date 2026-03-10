import java.util.Scanner;

public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(numSubarrayBoundedMax(nums, left, right));
        sc.close();
    }

    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE;

            for (int j = i; j < nums.length; j++) {
                max = Math.max(max, nums[j]);

                if (max > right) {
                    break;
                }

                if (max >= left) {
                    count++;
                }
            }
        }

        return count;
    }
}
