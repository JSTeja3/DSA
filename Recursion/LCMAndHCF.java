package Recursion;

import java.util.Scanner;

public class LCMAndHCF{
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            long A = sc.nextLong();
            long B = sc.nextLong();
            
            lcmAndhcf(A, B);
        }
        sc.close();
    }
    public static void lcmAndhcf(long A, long B){
        long max = (A>B)?A:B;
        long min = (A<B)?A:B;
        long HCF = findHCF(max, min);
        long LCM = (A*B)/HCF;
        System.out.println(LCM + " " + HCF);
    }
    public static long findHCF(long min, long max){
        if(min==0){
            return max;
        }
        return findHCF(max%min, min);
    }
}