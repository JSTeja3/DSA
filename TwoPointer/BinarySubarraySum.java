package TwoPointer;

import java.util.Scanner;

public class BinarySubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int goal = sc.nextInt();
        System.out.println(numSubarraysWithSum(nums, goal)-numSubarraysWithSum(nums, goal-1));
        sc.close();
    }
    public static int numSubarraysWithSum(int[] nums, int goal){
        if(goal<0){
            return 0;
        }
        int count = 0;
        int sum = 0;
        int p1 = 0;
        int p2 = 0;
        while(p2<nums.length){
            sum += nums[p2];
            while(sum>goal){
                sum -= nums[p1];
                p1++; 
            }
            count += p2-p1+1;
            p2++;
        }
        return count;
    }
}
