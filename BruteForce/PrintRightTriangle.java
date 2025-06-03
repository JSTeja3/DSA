package BruteForce;

import java.util.*;

public class PrintRightTriangle {
    public static void main(String[] args){
        Scanner sc  =  new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            StringBuilder result = new StringBuilder();
            for(int r=1; r<=N; r++){
                for(int c=1; c<=N; c++){
                    if(c<=N-r){
                        result.append(" ");
                    }
                    else{
                        result.append("*");
                    }
                }
                result.append("\n");
            }
            System.out.println("Case #"+t+":");
            System.out.println(result);
        }
        sc.close();
    }
}
