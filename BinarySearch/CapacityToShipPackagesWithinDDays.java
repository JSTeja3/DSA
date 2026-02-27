package BinarySearch;

import java.util.Scanner;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = sc.nextInt();
        }
        int d = sc.nextInt();
        System.out.println(shipWithinDays(weights, d));
        sc.close();
    }

    public static int shipWithinDays(int[] weights, int days) {
        int min = Integer.MIN_VALUE;
        int max = 0;
        int capacity = 0;
        for(int i=0; i<weights.length; i++){
            min = Integer.max(min, weights[i]);
            max += weights[i];
        }
        while(min<=max){
            int mid = (min+max)/2;
            if(isPossible(mid, days, weights)){
                max = mid-1;
                capacity = mid;
            }
            else{
                min = mid+1; 
            }
        }
        return capacity;
    }

    public static boolean isPossible(int x, int days, int[] weights) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > x) {
                count++;
                sum = weights[i];
            }
        }
        return count <= days;
    }
}
