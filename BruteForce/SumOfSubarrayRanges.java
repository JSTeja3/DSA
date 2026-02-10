import java.util.Scanner;

public class SumOfSubarrayRanges {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(subArrayRanges(heights));
        sc.close();
    }
    public static long subArrayRanges(int[] nums) {
        long sum  = 0;
        int N = nums.length;
        for(int i=0; i<N; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j=i; j<N; j++){
                if(nums[j]>max){
                    max=nums[j];
                }
                if(nums[j]<min){
                    min = nums[j];
                }
                sum += max-min;
            }
        }
        return sum;
    }

}
