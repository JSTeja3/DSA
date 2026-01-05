import java.util.*;

public class DeleteAtPosition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int P = sc.nextInt();
        System.out.println(printDeletedArray(N, arr, P));
        sc.close();
    }
    public static String printDeletedArray(int N, int[] arr, int P){
        String result = "";
        for(int i=0; i<N; i++){
            if((i+1)<N){        // in place shifting
                if(i>=P)
                    arr[i] = arr[i+1];
            }
        }
        for (int i = 0; i < N-1; i++) {
            result += arr[i] + " ";
        }
        return result;
    }
}
