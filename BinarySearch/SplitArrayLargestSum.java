package BinarySearch;

import java.util.Scanner;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(splitArray(nums, k));
        sc.close();
    }
    public static int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            min = Integer.max(min, nums[i]);
            max += nums[i];
        }
        while(min<=max){
            int mid = min+(max-min)/2;
            if(canSplit(mid, nums, k)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return ans;
    }
    public static boolean canSplit(int x, int[] nums, int k){
        int req = 1;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum > x){
                req++;
                sum = nums[i];
            }
        }
        return req<=k;
    }
}
