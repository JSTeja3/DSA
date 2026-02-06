import java.util.Scanner;

public class SumOfSubarrayMinimums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(sumSubarrayMins(heights));
        sc.close();
    }
    public static int sumSubarrayMins(int[] arr) {
        int N = arr.length;
        int M = (int)1e9+7;
        long sum = 0;
        for(int i=0; i<N; i++){
            int min  = Integer.MAX_VALUE;
            for(int j=i; j<N; j++){
                if(min>arr[j]){
                    min = arr[j];
                }
                sum = (sum+min)%M;
            }
        }
        return (int)sum;

    }
}
