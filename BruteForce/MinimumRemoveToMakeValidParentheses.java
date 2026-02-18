import java.util.Scanner;

public class MinimumRemoveToMakeValidParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minRemoveToMakeValid(s));
        sc.close();
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        boolean[] marked = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                if (s.charAt(i) == ')') {
                    for (int j = i - 1; j >= 0; j--) {
                        if (s.charAt(j) == '(' && !marked[j]) {
                            marked[j] = true;
                            marked[i] = true;
                            break;
                        }
                    }
                } else {
                    marked[i] = true;
                }
            }
        }
        for (int i = 0; i < marked.length; i++) {
            if (marked[i]) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
