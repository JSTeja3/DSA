import java.util.Scanner;

public class LongestSubarrayof1sAfterDeletingOneElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(longestSubarray(nums));
        sc.close();
    }

    public static int longestSubarray(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int delOps = 1;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] != 1) {
                    delOps--;
                }
                if (delOps < 0) {
                    break;
                }
                maxLength = Integer.max(maxLength, j - i);
            }
        }
        return maxLength;
    }
}
