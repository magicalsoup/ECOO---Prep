import java.util.Scanner;
import java.util.HashSet;
public class ecoo19r2p1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++) {
            int N = sc.nextInt();
            HashSet<String> st = new HashSet<String>();
            while(N-->0) {
                String s = sc.next().toLowerCase();
                String res="";
                for(int i=0; i<s.indexOf("@"); i++)
                    if(s.charAt(i) != '.')
                        res += s.charAt(i);
                if(s.contains("@"))
                    res += s.substring(s.indexOf("@"));
                s = res;
                String ans="";
                    if (s.contains("+") && s.contains("@"))
                        ans += s.substring(0, s.indexOf("+")) + s.substring(s.indexOf("@"));
                    else
                        ans += s;

                st.add(ans);
            }
            System.out.println(st.size());
        }
        sc.close();
    }
}
