import java.util.Scanner;

public class RotationOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            int[][] ar = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    ar[i][j] = sc.nextInt();
                }
            }
            rotateMatrix(t, N, ar);
        }
        sc.close();
    }
    public static void rotateMatrix(int t, int N, int[][]ar){
        StringBuilder result = new StringBuilder();
        for(int i=0; i<N; i++){ // transpose of a matrix
            for(int j=i+1; j<N; j++){
                int temp = ar[i][j];
                ar[i][j] = ar[j][i];
                ar[j][i] = temp;
            }
        }
        for(int i=0; i<N; i++){ //reverse each row
            for(int j=0; j<N/2; j++){
                int temp = ar[i][j];
                ar[i][j] = ar[i][N-1-j];
                ar[i][N-1-j] = temp;
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                result.append(ar[i][j]).append(" ");
            }
            result.append("\n");
        }



        System.out.println("Test Case #"+t+":");
        System.out.print(result);
    }
}
