package TwoPointer;

import java.util.*;

public class RotateArraybyK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(returnKRotatedArray(N, arr, K));
        sc.close();
    }
    public static String returnKRotatedArray(int N, int[] arr, int K){
        StringBuilder result = new StringBuilder();
        K = K%N;
        if (K != 0) {
            reverseArray(arr, 0, N - 1);
            reverseArray(arr, 0, (K - 1));
            reverseArray(arr, K, N - 1);
        }

        for(int i=0; i<N; i++){
            result.append(arr[i]).append(" ");
        }
        return result.toString();
    }
    public static void reverseArray(int[] arr, int p1, int p2){
        while(p1<p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
}
