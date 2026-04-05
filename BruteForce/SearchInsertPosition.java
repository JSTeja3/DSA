import java.util.Scanner;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(searchInsert(nums, target));
        sc.close();
    }
    public static int searchInsert(int[] nums, int target) {
        int result = nums.length;
        for(int i=0; i<nums.length; i++){
            if(nums[i]>=target){
                result = i;
                break;
            }
        }
        return result;
    }
}
