package TwoPointer;

import java.util.Scanner;

public class MaxSumofSubArraySizeK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(returnMaxSum(N, arr, K));
        sc.close();
    }
    public static int returnMaxSum(int N, int[] arr, int K){
        int maxSum = 0;
        int p1=0, p2=0;
        int sum = 0;
        while(p2<N){
            sum += arr[p2];
            if((p2-p1+1) == K){
                maxSum = Math.max(maxSum, sum);
                sum -= arr[p1];
                p1++;
            }
            p2++;
        }
        return maxSum;


    }
}
