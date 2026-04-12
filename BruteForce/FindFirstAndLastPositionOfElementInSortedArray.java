import java.util.Scanner;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        int[] result = searchRange(nums, target);
        for(int v: result){
            System.out.print(v+" ");
        }
        sc.close();
    }
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        boolean firstFound = false;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target){
                if(!firstFound){
                    firstFound = true;
                    result[0] = i;
                }
                result[1] = i;
            }
            
        }
        return result;
    }

}
