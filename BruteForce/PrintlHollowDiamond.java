import java.util.*;

public class PrintlHollowDiamond{
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++){
            int N = sc.nextInt();
            StringBuilder result = new StringBuilder();
            for(int r=0; r<N; r++){
                for(int i=0; i<N; i++){
                    if(r<=N/2){
                        if(i==(N/2-r) || i==(N/2+r)){
                            result.append("*");
                        }
                        else{
                            result.append(" ");
                        }
                    }
                    else{
                        if(i==(r-N/2) || i==((3*N/2-1-r))){
                            result.append("*");
                        }
                        else{
                            result.append(" ");
                        }
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

