package TwoPointer;

import java.util.*;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(returnUniqueLength(N, arr));
        sc.close();
    } 
    public static int returnUniqueLength(int N, int[] arr){
        int p1=0;
        int p2=0;
        while(p1<N){
            if(arr[p1]!=arr[p2]){
                arr[++p2] = arr[p1];
            }
            p1++;
        }
        return p2+1;
    }
}
