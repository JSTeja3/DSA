package TwoPointer;

import java.util.Scanner;

public class LongestSubArraySumK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(returnLengthofLargest(N, arr, K));
        sc.close();
    }
    public static int returnLengthofLargest(int N, int[] arr, int K){
        int maxSubLength = 0;
        int p1=0, p2=0;
        int sum = 0;
        while(p2<N){
            sum += arr[p2];
            while(sum>K){
                sum -= arr[p1];
                p1++;
            }
            if(sum == K){
                 maxSubLength = Math.max(maxSubLength, p2 - p1 + 1);
            }
            p2++;
        }
        return maxSubLength;
    }
}
