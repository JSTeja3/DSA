package BinarySearch;

import java.util.Scanner;

public class SquareRootWithPrecision {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        System.out.println(sqrtWithPrecision(x));
        sc.close();
    }
    public static double sqrtWithPrecision(double x){
        double low = 0;
        double high = Math.max(1, x);
        while(high-low>1e-6){
            double mid = (high+low)/2.0;
            if(isPossible(mid, x)){
                low = mid;
            }
            else{
                high = mid;
            }
        }
        return Math.round(low*1000000.00)/1000000.00;
    }
    public static boolean isPossible(double v, double x){
        double sq = v*v;
        return sq<=(double)x;
    }
}
