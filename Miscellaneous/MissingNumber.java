package Miscellaneous;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(missingNumber(nums));
        System.out.println(missingNumberXOR (nums)); //using XOR
        sc.close();
    }
    public static int missingNumber(int[] nums) {
        int sum = 0;
        int N = nums.length;
        int sumOfN = (N*(N+1))/2;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        return sumOfN-sum;
    }
    public static int missingNumberXOR(int[] nums) {
        int xor = nums.length;
        for(int i=0; i<nums.length; i++){
            xor ^= i^nums[i];
        }
        return xor;
    }


}
