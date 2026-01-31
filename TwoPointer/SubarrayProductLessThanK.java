package TwoPointer;

import java.util.Scanner;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(numSubarrayProductLessThanK(nums, k));
        sc.close();
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0){
            return 0;
        }
        int count = 0;
        int p = 1;
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            p *= nums[p2];
            while(p>=k && p1<=p2){
                p /= nums[p1];
                p1++;
            }
            count += p2-p1+1;
            p2++;
        }
        return count;
    }

}
