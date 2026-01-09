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
        for (int i = 0; i < nums.length; i++) {
            int z = k;
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
