import java.util.Arrays;
import java.util.Scanner;

public class SingleNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        System.out.println(singleNumber(nums));
        sc.close();
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i+=2){
            if(i+1==nums.length || nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
}
