import java.util.Scanner;

public class SumOfSubarrayMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] heights = new int[N];
        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(sumOfMax(heights));
        sc.close();
    }

    public static int sumOfMax(int[] arr) {
        // code here 
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
                sum = (sum + max);
            }
        }
        return (int) sum;
    }
}
