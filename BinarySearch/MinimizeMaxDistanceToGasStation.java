package BinarySearch;

import java.util.Scanner;

public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] stations = new int[N];
        for (int i = 0; i < N; i++) {
            stations[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(minMaxDist(stations, k));
        sc.close();
    }
    public static double minMaxDist(int[] stations, int K) {

        double low = 0;
        double high = 0;

        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;

            if (isPossible(mid, stations, K)) {
                high = mid;   
            } else {
                low = mid;    
            }
        }

        return Math.round(high * 1_000_000.0) / 1_000_000.0;
    }

    public static boolean isPossible(double dist, int[] stations, int K) {
        int required = 0;

        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            required += (int)Math.ceil(gap / dist) - 1;

            if (required > K) return false; 
        }

        return required <= K;
    }
}
