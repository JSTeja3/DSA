import java.util.Scanner;

public class LongestSubarrayWithSumAtmostK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(longestSubarrayAtmostKSum(nums, k));
        sc.close();
    }
    public static int longestSubarrayAtmostKSum(int[] nums, int k){
        int maxLength = 0;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum > k){
                    break;
                }
                maxLength = Integer.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }
}
