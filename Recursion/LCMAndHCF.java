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
        long HCF = findHCF(A, B);
        long LCM = (A*B)/HCF;
        System.out.println(LCM + " " + HCF);
    }
    public static long findHCF(long a, long b){
        if(a==0){
            return b;
        }
        return findHCF(b%a, a);
    }
}