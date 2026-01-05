package TwoPointer;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }  
        System.out.println(checkPalindromeTwoPointer(N, arr));
        sc.close();
    }
    public static Boolean checkPalindromeTwoPointer(int N, int[] arr){
        /*Two pointer technique to reduce the space taken for extra array*/
        int left = 0;
        int right = N-1;
        while(left<right){
            if(arr[left] != arr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
