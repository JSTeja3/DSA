package BinarySearch;

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
        boolean foundNZeros = binarySearch(0l, value, N);  //Iterative Approach->Best as no stack space used
        //boolean foundNZeros = binarySearchR(0l, value, N); //Recursive Approach
        if(foundNZeros){
            System.out.println(5);
            return;
        }
        System.out.println(0);

    }
    public static boolean binarySearch(long l, long h, long N){
        while(l<=h){
            long m = (l+h)/2;
            long count = countZeros(m);
            if(count<N){
                l=m+1;
            }
            else if(count>N){
                h=m-1;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearchR(long l, long h, long N){
        if(l>h){                                  //Base condition
            return false;
        }
        long m = (l+h)/2;                         //Main Logic
        long count = countZeros(m);
        if(count<N){
            return binarySearchR(m+1, h, N);
        }
        else if(count>N){
            return binarySearchR(l, m-1, N);
        }
        return true;
    }
    public static long countZeros(long value){
        long count = 0l;
        for(long i=5l; value/i>0l; i*=5l){
            count += value/i;
        }
        return count;
    }
}
