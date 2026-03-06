package TwoPointer;

import java.util.Scanner;

public class SubarraysWithMaximumLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(countSubArrays(nums, k));
        sc.close();
    }
    public static long countSubArrays(int[] nums, int k) {
        long count = 0;
        int l = 0;

        // Literal Two Pointer
        /*int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            if(nums[p2]>=k){
                l = p2-p1;
                count += (long)l*(l+1)/2;
                p1 = p2+1;
            }
            p2++;
        }
        l = p2-p1;*/


        // Simpler way
        for(int v: nums){
            if(v<k){
                l++;
                count+=l;
            }
            else{
                l=0;
            }
        }
        return count;
    }
}
