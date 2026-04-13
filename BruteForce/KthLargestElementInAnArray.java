import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findKthLargest(nums, k));
        sc.close();
    }
    public static int findKthLargest(int[] nums, int k) {
        int N = nums.length; 
        Arrays.sort(nums);
        
        return nums[N-k];
    }
}
