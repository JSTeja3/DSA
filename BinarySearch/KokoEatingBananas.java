package BinarySearch;

import java.util.Scanner;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] piles = new int[N];
        for (int i = 0; i < N; i++) {
            piles[i] = sc.nextInt();
        }
        int h = sc.nextInt();
        System.out.println(minEatingSpeed(piles, h));
        sc.close();
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = 0;
        int k  = 0;
        for(int i=0; i<piles.length; i++){
            max = Integer.max(max, piles[i]);
        }

        while(min<=max){
            int mid = (min+max)/2;
            if(canFinish(mid, piles, h)){
                max = mid-1;
                k = mid;
            }
            else{
                min = mid+1;
            }
        }
        return k;
    }

    public static boolean canFinish(int x, int[] piles, int h) {
        long reqHours = 0;
        for (int i = 0; i < piles.length; i++) {
            int r = ((piles[i] % x) > 0) ? 1 : 0;
            reqHours += (r + piles[i] / x);
        }
        return reqHours <= (long)h;
    }
}
