package BinarySearch;

import java.util.Scanner;

public class MinimumNumberOfDaysToMakemBouquets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] bloomDay = new int[N];
        for (int i = 0; i < N; i++) {
            bloomDay[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(minDays(bloomDay, m, k));
        sc.close();
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        if((double)m*k > bloomDay.length){
            return ans;
        }
        for(int i=0; i<bloomDay.length; i++){
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        while(min<=max){
            int mid = min+(max-min)/2;
            if(canMakeBouquets(mid, bloomDay, m, k)){
                ans = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return ans;
    }
    public static boolean canMakeBouquets(int days, int[] bloomDay, int m, int k){
        int reqK = 0;
        int reqM = 0;
        for(int i=0; i<bloomDay.length; i++){
            if(bloomDay[i]<=days){
                reqK++;
            }
            else{
                reqK = 0;
            }
            if(reqK == k){
                reqM++;
                reqK = 0;
            }
        }
        return reqM>=m;
    }
}
