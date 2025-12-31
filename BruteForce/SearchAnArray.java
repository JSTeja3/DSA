import java.util.*;

public class SearchAnArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int X = sc.nextInt();
        System.out.println(findIndexofElement(N, arr, X));
        sc.close();
    }
    public static int findIndexofElement(int N, int[] arr, int X){
        int index = -1;
        for(int i=0; i<N; i++){
            if(arr[i]==X){
                index = i;
                break;
            }
        }
        return index;
    }
}
