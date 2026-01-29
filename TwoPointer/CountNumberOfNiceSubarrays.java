package TwoPointer;

import java.util.Scanner;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(numberOfSubarrays(nums, k)-numberOfSubarrays(nums, k-1));
        sc.close();
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int c = 0;
        int countSub = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < nums.length) {
            if (nums[p2] % 2 != 0) {
                c++;
            }
            while (c > k) {
                if (nums[p1] % 2 != 0) {
                    c--;
                }
                p1++;
            }
            countSub += p2 - p1 + 1;

            p2++;
        }
        return countSub;
    }

}
