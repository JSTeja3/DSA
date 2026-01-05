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
        int[] uniqueArray = new int[N];
        int x = 0;
        for(int i=0; i<N; i++){
            if(i==0 || arr[i]!=uniqueArray[x-1]){
                uniqueArray[x] = arr[i];
                x++;
            }
        }
        for(int i=0; i<N; i++){
            arr[i] = uniqueArray[i];
        }

        return x;
    }
}
