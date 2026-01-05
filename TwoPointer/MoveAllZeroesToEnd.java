package TwoPointer;

import java.util.*;

public class MoveAllZeroesToEnd {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(returnMovedArray(N, arr));
        sc.close();
    }
    public static String returnMovedArray(int N, int[] arr){
        StringBuilder result = new StringBuilder();
        int p1 = 0, p2 = 0;
        while(p1<N){
            if(arr[p2]!=0){
                p2++;
            }
            else if(arr[p1]!=0){
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p2++;
            }
            p1++;
        }
        for(int i=0; i<N; i++){
            result.append(arr[i]).append(" ");
        }
        return result.toString();

    }
}
