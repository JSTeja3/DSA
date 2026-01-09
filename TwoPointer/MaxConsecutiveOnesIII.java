package TwoPointer;

import java.util.Scanner;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestOnes(nums, k));
        sc.close();
    }
    public static int longestOnes(int[] nums, int k) {
        int maxOnes = 0;
        int c = 0;
        int p1 = 0; 
        int p2 = 0;
        while(p2<nums.length){
            if(nums[p2]==0){
                c++;
            }
            while(c>k){
                if(nums[p1]==0){
                    c--;
                }
                p1++;
            }
            maxOnes = Integer.max(maxOnes, p2-p1+1);
            p2++;
        }
        return maxOnes;
    }
}
