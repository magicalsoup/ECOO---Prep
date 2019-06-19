import java.util.*;
public class ecoo15r1p4 {
    static String neanderthalNumbers[] = {"ug", "ook", "oog", "ooga", "mook", "ugug", "oogum", "oogam", "ookook", "mookmook"};
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++){
            String s = sc.next();
            int dp[] = new int [s.length()+1];
            dp[0] = 1;
            for(int i=0; i<s.length(); i++){
                for(int k=0; k<10; k++){
                    if(i + neanderthalNumbers[k].length() <= s.length()) {
                        if(s.substring(i, i+neanderthalNumbers[k].length()).equals(neanderthalNumbers[k])) {
                            dp[i + neanderthalNumbers[k].length()] += dp[i];
                        }
                    }
                }
            }
            System.out.println(dp[s.length()]);
        }
        sc.close();
    }
}
