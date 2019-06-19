import java.util.*;
public class ecoo18r1p3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1 ; testcases<=10; testcases++){

            // INPUT
            int N = sc.nextInt(), X = sc.nextInt(), Y = sc.nextInt(), Z = sc.nextInt();
            ArrayList<String> codes = new ArrayList<String>();

            for(int i=0; i<N; i++)
                codes.add(sc.next());

            sc.next(); // for the answer key start letter
            String ansKey[] = new String[N];
            for(int i=0; i<N; i++)
                ansKey[i] = sc.next();

            sc.next(); // for the asterisk
            //-----------------------

            ArrayList<String> converted = new ArrayList<String>(); // store the converted codes in here
            for(String s : codes) {
                String res="";
                for(int i=0; i< s.length(); i++) {
                    int digit = Integer.parseInt(s.substring(i, i+1));
                    if(digit==0) { // zero
                        digit = Z;
                    }
                    else if(digit%2==0) { // even
                        digit += X;
                    }
                    else if(digit%2!=0) { // odd;
                        digit -=Y;
                        digit = Math.max(0, digit);
                    }
                    res += digit;
                }
                converted.add(res);
            }
            boolean match=true;
            String fails=""; // store the fail ones in here
            for(int i=0; i<N; i++){
                if(converted.get(i).equals(ansKey[i])) continue;
                match=false;
                fails += (i+1)+",";
            }
            if(match)
                System.out.println("MATCH");
            else
                System.out.println("FAIL: " + fails.substring(0, fails.length()-1));
        }
        sc.close();
    }
}
