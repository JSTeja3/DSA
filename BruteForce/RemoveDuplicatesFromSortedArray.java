import java.util.Scanner;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(removeDuplicates(nums));
        sc.close();
    }

    public static int removeDuplicates(int[] nums) {
        int[] result = new int[nums.length];
        int j = 0;
        result[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != result[j]) {
                result[++j] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

        return j + 1;
    }

}
