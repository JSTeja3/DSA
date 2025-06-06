import java.util.*;

public class SumofArray {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();
        while(T-->0){
            int N = sc.nextInt();
            long sum = 0;
            for(int i=0; i<N; i++){
                long v = sc.nextLong();
                sum += v;
            }
            result.append(sum+"\n");
        }
        sc.close();
        System.out.println(result);
    }
}