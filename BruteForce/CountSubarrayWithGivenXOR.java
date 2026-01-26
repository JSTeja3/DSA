import java.util.Scanner;

public class CountSubarrayWithGivenXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(subarrayXor(nums, k));
        sc.close();
    }

    public static long subarrayXor(int arr[], int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
