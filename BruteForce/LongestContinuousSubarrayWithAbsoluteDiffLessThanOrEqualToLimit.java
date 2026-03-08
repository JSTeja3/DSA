import java.util.Scanner;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int limit = sc.nextInt();
        System.out.println(longestSubarray(nums, limit));
        sc.close();
    }
    public static int longestSubarray(int[] nums, int limit) {
        int maxLength = 0;
        for(int i=0; i<nums.length; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j=i; j<nums.length; j++){
                max = Integer.max(max, nums[j]);
                min = Integer.min(min, nums[j]);
                if(max-min<=limit){
                    maxLength = Integer.max(maxLength, j-i+1);
                }
            }
        }
        return maxLength;
    }
}
