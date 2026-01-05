import java.util.*;

public class ArrayTraversal_Aggregation {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            System.out.println("Test Case: "+t);
            System.out.println(SumAndCount(N, arr, x));
        }
        sc.close();
    }
    public static String SumAndCount(int N, int[] arr, int x){
        long sum = 0;
        int count = 0;
        String result = "";
        for(int i=0; i<N; i++){
            sum+=arr[i];
            if(arr[i]>x){
                count++;
            }
        }
        result+= sum +"\n"+count;
        return result;

    }
    
}
