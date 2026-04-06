package BinarySearch;

import java.util.Scanner;

public class FirstBadVersion {
    private static boolean[] verArray; 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int bad = sc.nextInt();
        fillArray(N, bad);
        System.out.println(firstBadVersion(N));
        sc.close();
    }
    public static void fillArray(int N, int bad){
        verArray = new boolean[N];
        for(int i=bad-1; i<verArray.length; i++){
            verArray[i] = true;
        }
    }
    public static boolean isBadVersion(int ver){
        return verArray[ver-1];
    }
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(isBadVersion(mid)){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
}
