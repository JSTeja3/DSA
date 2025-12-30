import java.util.*;

public class InsertAtPosition {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N+1];
        for(int i = 0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int X = sc.nextInt();
        int P = sc.nextInt();
        System.out.println(printInsertedArray(N, arr, X, P));
        sc.close();
    }
    public static String printInsertedArray(int N, int[] arr, int X, int P){
        int temp = 0;
        String result = "";
        for(int i=0; i<=N; i++){
            if(i>=P){
                temp = arr[i];
                arr[i] = X;
                X = temp;
            }

            result += arr[i]+" ";
        }
        return result;
    }
}
