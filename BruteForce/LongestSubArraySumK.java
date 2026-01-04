import java.util.*;

public class LongestSubArraySumK {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(returnLengthofLargest(N, arr, K));
        sc.close();
    }
    public static int returnLengthofLargest(int N, int[] arr, int K){
        int maxSubLength = 0;
        for(int i=0; i<N; i++){
            int sum = 0;    //---->Third loop optimization
            for(int j=i; j<N; j++){
                // for(int k=i; k<=j; k++){  -----> This loop can be optimized
                //     sum += arr[k];
                // }
                sum += arr[j];   //---->Third loop optimization
                if(sum==K){
                    maxSubLength = Math.max(maxSubLength, j-i+1);
                }

            }
        }
        return maxSubLength;
    }
}
