import java.util.Scanner;

public class TrailingZerosModified {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            long N = sc.nextLong();
            trailingZerosModified(N);
        }
        sc.close();
    }
    public static void trailingZerosModified(long N){
        long value = 5l*N;
        if(value==0){
            System.out.println(4);
            return;
        }
        while(value>0){
            long count = countZeros(value);
            if(count==N){
                System.out.println(5);
                return;
            }
            else if(count<N){
                break;
            }
            value--;;
        }
        System.out.println(0);

    }
    public static long countZeros(long value){
        long count = 0l;
        for(long i=5l; value/i>0l; i*=5l){
            count += value/i;
        }
        return count;
    }
}
