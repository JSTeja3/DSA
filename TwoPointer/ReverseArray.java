package TwoPointer;

import java.util.*;

public class ReverseArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }  
        System.out.println(reverseArrayTwoPointer(N, arr));
        sc.close();
    }
    public static String reverseArrayTwoPointer(int N, int[] arr){
        StringBuilder result = new StringBuilder();
        /*Two pointer technique to reduce the space taken for extra array*/
        int left = 0;
        int right = N-1;
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        for(int i=0; i<N; i++){
            result.append(arr[i]).append(" ");
        }
        return result.toString();
    }
}
