import java.util.Arrays;
import java.util.Scanner;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(longestConsecutive(nums));
        sc.close();
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } 
            else if (nums[i] == nums[i - 1] + 1) {
                currLen++;
            } 
            else {
                currLen = 1;
            }

            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }

}
