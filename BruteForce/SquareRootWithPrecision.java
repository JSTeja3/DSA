import java.util.*;

public class SquareRootWithPrecision {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.println(sqrtWithPrecision(x));
        sc.close();
    }
    public static double sqrtWithPrecision(double x){
        double high = Math.max(1, x);
        double ans = 0.0;
        for(double i=0.0; i<high; i += 0.000001){
            if(isPossible(i, x)){
                ans = i;
            }
            else{
                break;
            }
        }
        return Math.round(ans*1000000.00)/1000000.00;
    }
    public static boolean isPossible(double v, double x){
        double sq = v*v;
        return sq<=(double)x;
    }
}
