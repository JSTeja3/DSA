import java.util.Scanner;

public class LongestSubarrayWithAtmostKZeroes{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(longestSubarray(nums));
        sc.close();
    }
    public static int longestSubarray(int[] nums) {
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            int z = 2;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    z--;
                }
                if (z < 0) {
                    break;
                }
                maxOnes = Integer.max(maxOnes, j - i + 1);
            }
        }
        return maxOnes;
    }
}