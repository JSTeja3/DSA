import java.util.Scanner;

public class RotateArrayKLeft {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        int K = sc.nextInt();
        System.out.println(returnKRotatedArray(N, arr, K%N));
        sc.close();
    }
    public static String returnKRotatedArray(int N, int[] arr, int K){
        StringBuilder result = new StringBuilder();
        int[] rotatedArray = new int[N];
        for(int i=0; i<N; i++){
            int x = (i-K+N)%N;
            rotatedArray[x] = arr[i];
        }
        for(int i=0; i<N; i++){
            result.append(rotatedArray[i]).append(" ");
        }
        return result.toString();
    }
}
