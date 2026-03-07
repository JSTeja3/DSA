import java.util.Scanner;

public class SubarraysWithMaximumLessThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(countSubArrays(nums, k));
        sc.close();
    }
    public static int countSubArrays(int[] nums, int k){
        int count = 0;
        for(int i=0 ; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                if(nums[j]>=k){
                    break;
                }
                count++;
            }
        }
        return count;
    }
}
