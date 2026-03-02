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

        double high = 0;
        double ans = 0;

        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }

        for (double dist = 0.0; dist <= high; dist += 0.000001) {

            if (isPossible(dist, stations, K)) {
                ans = dist;
                break; 
            }
        }


        return Math.round(ans * 1_000_000.0) / 1_000_000.0;
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
