package TwoPointer;

import java.util.Scanner;

public class NumberOfSubarraysWithBoundedMaximum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int left = sc.nextInt();
        int right = sc.nextInt();
        System.out.println(numSubarrayBoundedMax(nums, left, right));
        sc.close();
    }
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int totalCount = 0;
        while(p2<nums.length){
            if(nums[p2]>right){
                p1=p2+1;
                count = 0;
            }
            else if(nums[p2]>=left){
                count = p2-p1+1;
            }
            totalCount += count;
            p2++;
        }
        return totalCount;
    }
}
