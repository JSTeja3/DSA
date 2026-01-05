import java.util.*;

public class UpdateArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int P = sc.nextInt();
        int X = sc.nextInt();
        System.out.println(returnUpdatedArray(N, arr, P, X)); 
        sc.close();
    }
    public static String returnUpdatedArray(int N, int[] arr, int P, int X){
        String result = ""; // Can you StringBuilder for better optimization
        arr[P] = X;
        for(int i=0; i<N; i++){
            result += arr[i] + " ";
        }
        return result;
    }
}
