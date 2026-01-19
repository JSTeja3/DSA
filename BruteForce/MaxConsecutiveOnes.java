import java.util.Scanner;

public class MaxConsecutiveOnes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(findMaxConsecutiveOnes(nums));
        sc.close();
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnesLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 1) {
                    maxOnesLength = Integer.max(maxOnesLength, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return maxOnesLength;
    }
}
