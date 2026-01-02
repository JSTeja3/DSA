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
        int[] resArray = new int[N];
        int x = 0;
        for(int i=0; i<N; i++){
            if(arr[i]==0){
                continue;
            }
            resArray[x] = arr[i];
            x++;
        }
        for(int i=0; i<N; i++){
            result.append(resArray[i]).append(" ");
        }
        return result.toString();

    }
}
