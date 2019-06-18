import java.util.*;
import java.util.Map.Entry;
public class ecoo19r1p2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++) {
            int R = sc.nextInt(); // number of rules
            int T = sc.nextInt(); // number if iterations
            String A = sc.next(); // axiom

            String rules[] = new String[26];
            Arrays.fill(rules, "#");
            for(int i=0; i<R; i++){
                char c = sc.next().charAt(0);
                String replacement = sc.next();
                rules[c-'A'] = replacement;
            }
            Map<Character, Long> freq = new HashMap<Character, Long>();
            for(Character ch : A.toCharArray()) {
                if(!freq.containsKey(ch))
                    freq.put(ch, 1L);
                else
                    freq.put(ch, freq.get(ch)+1);
            }

            char first=A.charAt(0);
            char last=A.charAt(A.length()-1);
            for(int num=1; num<=T; num++) {
                first=rules[first-'A'].charAt(0);
                String curLast=rules[last-'A'];
                int len=curLast.length();
                last=curLast.charAt(len-1);
                Map<Character, Long> new_freq = new HashMap<Character, Long>();
                for (Entry<Character, Long> entry : freq.entrySet()) {
                    for (Character ch : rules[entry.getKey()-'A'].toCharArray()) {
                        if(!new_freq.containsKey(ch))
                            new_freq.put(ch, entry.getValue());
                        else
                            new_freq.put(ch, new_freq.get(ch) + entry.getValue());
                    }
                }
                freq = new_freq;
            }
            long ansLength=0;
            for(Entry<Character, Long> entry : freq.entrySet()) {
                ansLength += entry.getValue();
            }
            String ans=first+""+last;
            System.out.println(ans + " " + ansLength);
        }
        sc.close();
    }
}
