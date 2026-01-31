import java.util.Scanner;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(numSubarrayProductLessThanK(nums, k));
        sc.close();
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = 1;
            for (int j = i; j < nums.length; j++) {
                p *= nums[j];
                if (p < k) {
                    count++;
                }
            }
        }
        return count;
    }
}
