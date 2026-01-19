package TwoPointer;

import java.util.Scanner;

public class BinarySubarryaWithAtmostKZeroes {
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
        int p1 = 0;
        int p2 = 0;
        int zCount = 1;
        while (p2 < nums.length) {
            if (nums[p2] == 0) {
                zCount--;
            }
            while (zCount < 0) {
                if (nums[p1] == 0) {
                    zCount++;
                }
                p1++;
            }
            maxLength = Integer.max(maxLength, p2 - p1 + 1);
            p2++;
        }
        return maxLength;
    }
}
