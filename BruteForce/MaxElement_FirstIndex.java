import java.util.*;

public class MaxElement_FirstIndex {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        } 
        System.out.println(printMaxAndIndex(N, arr));

        sc.close();
    }
    public static String printMaxAndIndex(int N, int[] arr){
        if(N == 0){
            return "-1\n-1";
        }
        int max = arr[0];
        int index = 0;
        String result = "";
        for (int i=1; i<N; i++){
            if(max<arr[i]){
                max = arr[i];
                index = i; 
            }
        }
        result += max + "\n" + index;
        return result;
    }
}
