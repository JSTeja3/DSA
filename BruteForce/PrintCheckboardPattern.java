import java.util.*;

public class PrintCheckboardPattern {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            printCheckerboard(t, N);
            
        }
        sc.close();
    }
    public static void printCheckerboard(int t, int N){
        StringBuilder result = new StringBuilder();
        char star = '*';
        char dash = '-';
        char rowStartValue = star;
        for(int i=0; i<2*N; i++){
            //first value in a row
            char currValue = rowStartValue;
            for(int j=0; j<2*N; j++){
                result.append(currValue);
                if(j%2!=0){
                    //changing current charcter for every odd position
                    currValue = (currValue==star)?dash:star;
                }
            }
            result.append("\n");
            if(i%2!=0){
                    //changing starting character for every odd row 
                    rowStartValue = (rowStartValue==star)?dash:star;
            }

        }
        System.out.println("Case #"+t+":");
        System.out.print(result);
    }
}

