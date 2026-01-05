import java.util.*;

public class SecondLargestElement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(returnSecondLargest2(N, arr));
        sc.close();
    }
    // O(NlogN), O(1)
    public static int returnSecondLargest(int N, int[] arr){ 
        int secondMax = Integer.MIN_VALUE;
        if(N<2){
            return -1; // check if array has two elements atleast
        }
        Arrays.sort(arr);
        int max = arr[N-1];
        for(int i=N-2; i>=0; i--){
            if(arr[i]<max){
                secondMax = arr[i];
                break;
            }
        }
        return secondMax;
    }
    // Two pass approach -->O(N+N), O(1)
    public static int returnSecondLargest2(int N, int[] arr){
        if(N<2){
            return -1; // check if array has two elements atleast
        }
        int max = arr[0];
        for(int i=1; i<N; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        int secondMax = Integer.MIN_VALUE;
        boolean found = false;
        for(int i=0; i<N; i++){
            if(arr[i] < max && (!found || arr[i]>secondMax)){ // !found is used for case arr={1, Interge.MIN_VALUE}
                secondMax = arr[i];
                found = true;
            }
        }
        return found?secondMax:-1;
    }
    // Optimized O(N), O(1)
    public static int returnSecondLargestOptimized(int N, int[] arr){
        if(N<2){
            return -1; // check if array has two elements atleast
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        boolean found = false;
        for(int i=0; i<N; i++){
            if(arr[i]>max){
                if(max!=Integer.MIN_VALUE){
                    secondMax = max;
                    found = true;
                }
                max = arr[i];
            }
            else if(arr[i] < max && (!found || arr[i]>secondMax)){ // !found is used for case arr={1, Interge.MIN_VALUE}
                secondMax = arr[i];
                found = true;
            }
        }
        return found?secondMax:-1;
    }

}
