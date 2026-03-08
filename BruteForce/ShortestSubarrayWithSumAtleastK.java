import java.util.Scanner;

public class ShortestSubarrayWithSumAtleastK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0; i<N; i++){
            nums[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(shortestSubarray(nums, k));
        sc.close();
    }
    public static int shortestSubarray(int[] nums, int k) {
        int minLength = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int sum = 0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum >= k){
                    minLength = Math.min(minLength, j-i+1);
                }
            }
        }
        return (minLength==Integer.MAX_VALUE)?-1:minLength;
    }
}
