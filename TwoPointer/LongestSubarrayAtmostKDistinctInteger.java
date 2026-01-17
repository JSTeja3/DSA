package TwoPointer;

import java.util.Scanner;

public class LongestSubarrayAtmostKDistinctInteger {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestKDistinct(nums, k));
        sc.close();
    }
    public static int longestKDistinct(int[] nums, int k){
        int maxLength = 0;
        int[] count = new int[(int)1e5];
        int p1 = 0;
        int p2 = 0;
        int c = 0;
        while(p2<nums.length){
            count[nums[p2]]++;
            if(count[nums[p2]]==1){
                c++;
            }
            while(c>k){
                count[nums[p1]]--;
                if(count[nums[p1]]==0){
                    c--;
                }
                p1++;
            }
            maxLength = Integer.max(maxLength, p2-p1+1);
            p2++;
        }
        return maxLength;
    }
}
