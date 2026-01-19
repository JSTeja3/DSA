import java.util.*;

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
        for(int i=0; i<nums.length; i++){
            int distinct = 0;
            int[] count = new int[(int)1e5];
            for(int j=i; j<nums.length; j++){
                count[nums[j]]++;
                if(count[nums[j]]==1){
                    distinct++;
                }
                if(distinct>k){
                    break;
                }
                maxLength = Integer.max(maxLength, j-i+1);
            }
        }
        return maxLength;
    }
}
