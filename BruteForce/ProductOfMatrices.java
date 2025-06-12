import java.util.Scanner;

public class ProductOfMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N1 = sc.nextInt();
            int M1 = sc.nextInt();
            int[][] a = new int[N1][M1];
            for(int i=0; i<N1; i++){
                for(int j=0; j<M1; j++){
                    a[i][j] = sc.nextInt();
                }
            }
            int N2 = sc.nextInt();
            int M2 = sc.nextInt();
            int[][] b = new int[N2][M2];
            for(int i=0; i<N2; i++){
                for(int j=0; j<M2; j++){
                    b[i][j] = sc.nextInt();
                }
            }
            productMatrix(N1, M1, a, N2, M2, b);
                
        }
        sc.close();
    }
    public static void productMatrix(int N1, int M1, int[][] a, int N2, int M2, int[][]b){
        int[][] mat = new int[N1][M2];
        for(int i=0; i<N1; i++){
            for(int j=0; j<M2; j++){
                for(int k=0; k<M1; k++){
                    mat[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0; i<N1; i++){
            for(int j=0; j<M2; j++){
                result.append(mat[i][j]+" ");
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
