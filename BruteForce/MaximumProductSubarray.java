import java.util.Scanner;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(maxProduct(nums));
        sc.close();
    }
    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=i; j<nums.length; j++){
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}
