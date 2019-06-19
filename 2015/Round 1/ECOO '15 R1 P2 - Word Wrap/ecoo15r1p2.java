import java.util.*;
public class ecoo15r1p2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++){
            int W = sc.nextInt(); sc.nextLine();
            ArrayList<String> words = new ArrayList<String>();
            String s = sc.nextLine();
            String tmp1[] = s.split(" ");
            for(String i: tmp1)
                words.add(i);

            while(!words.isEmpty()){
                int len=0;
                int idx=0;
                ArrayList<String> output = new ArrayList<String>();
                if(words.get(idx).length() > W) {
                    String word = words.get(idx);
                    words.set(idx, word.substring(W));
                    output.add(word.substring(0, W));
                }
                else {
                    while (len < W && !words.isEmpty()) {
                        if(words.get(idx).length() + len <= W){
                            output.add(words.get(idx));
                            len+=words.get(idx).length()+1;
                            words.remove(idx);
                        }
                        else break;
                    }
                }
                String res="";
                for(String i: output) res += i +" ";
                System.out.println(res);
                if(words.isEmpty()) break;
            }
            System.out.println("=====");
        }
        sc.close();
    }
}
