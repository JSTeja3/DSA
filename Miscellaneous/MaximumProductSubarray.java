package Miscellaneous;

import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProduct(nums));
        sc.close();
    }
    public static int maxProduct(int[] nums){
        int maxProduct = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0];
        for(int i=1; i<nums.length; i++){
            int tempMax = Math.max(nums[i], Math.max(nums[i]*maxEnding, nums[i]*minEnding));
            int tempMin = Math.min(nums[i], Math.min(nums[i]*maxEnding, nums[i]*minEnding));

            maxEnding = tempMax;
            minEnding = tempMin;

            maxProduct = Math.max(maxProduct, maxEnding);
        }
        return maxProduct;
    }
}
