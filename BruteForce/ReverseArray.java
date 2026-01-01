import java.util.*;

public class ReverseArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(printReverseArray(N, arr));
        sc.close();
    }

    public static String printReverseArray(int N, int[] arr){
        int[] rev = new int[N];
        StringBuilder result = new StringBuilder(); // More optimized way to append than using string

        for(int i=0; i<N; i++){
            rev[i] = arr[N-i-1]; // Storing array in reverse
        }

        for(int i=0; i<N; i++){
            arr[i] = rev[i];     // Copying back to original array
            result.append(arr[i]).append(" ");
        }
        return result.toString();
    }
}