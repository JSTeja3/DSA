import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(isPalindrome(N, arr));
        sc.close();
    }

    public static Boolean isPalindrome(int N, int[] arr){
        int[] rev = new int[N];

        for(int i=0; i<N; i++){
            rev[i] = arr[N-i-1];
        }

        for(int i=0; i<N; i++){
            if(arr[i] != rev[i]){
                return false;
            }
        }
        return true;
    }
}
