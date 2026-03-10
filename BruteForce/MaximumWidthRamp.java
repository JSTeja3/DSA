import java.util.Scanner;

public class MaximumWidthRamp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxWidthRamp(nums));
        sc.close();
    }
    public static int maxWidthRamp(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(nums[j]>=nums[i]){
                    max = Integer.max(max, j-i);
                }
            }
        }
        return max;
    }

}
