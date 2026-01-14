package TwoPointer;

import java.util.Scanner;

public class MaxConsecutiveOnesII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(findMaxConsecutiveOnes(nums));
        sc.close();
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesLength = 0;
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
            maxOnesLength = Integer.max(maxOnesLength, p2 - p1 + 1);
            p2++;
        }
        return maxOnesLength;
    }
}
