import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(maximumSubarraySum(nums, k));
        sc.close();
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        for(int i=0; i<=nums.length-k; i++){
            int sum = 0;
            Set<Integer> set = new HashSet<>();
            for(int j=i; j<i+k; j++){
                if(set.contains(nums[j])){
                    sum = 0;
                    break;
                }
                sum += nums[j];
                set.add(nums[j]);
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
