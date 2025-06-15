import java.util.Scanner;

public class TrailingZeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            long N = sc.nextLong();
            trailingZeros(N);
        } 
        sc.close();   
    }
    public static void trailingZeros(long N){
        long count = 0;
        for(long i=5; N/i>0; i*=5){ 
            //Counting the number of 5's, 25's, 125's.... in N! 
            //Each 5 contributes 1 zero and each 25 contributes the second zero and so on
            count += N/i;
        }
        System.out.println(count);
    }
}
