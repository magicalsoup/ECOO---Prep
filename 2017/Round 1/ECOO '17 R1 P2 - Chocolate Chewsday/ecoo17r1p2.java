import java.util.*;
public class ecoo17r1p2 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        for(int testcases=0; testcases<10; testcases++) {
            int N = sc.nextInt();
            int cnt=0;
            ArrayList<Chocolate> chocolates = new ArrayList<Chocolate>();
            String str=sc.next();
            while(cnt < N) {
                if(str.equals("*")) break;
                Chocolate cur;
                if(!str.equals("J")) {
                    cur = new Chocolate(str, 0, 0, 0);
                    while(true) {
                        str = sc.next();
                        if(!str.equals("J")) break;
                        int P = sc.nextInt(), F = sc.nextInt(), G = sc.nextInt();
                        cur.P += P;
                        cur.F += F;
                        cur.G += G;
                    }
                    chocolates.add(cur);
                    cnt++;
                }
            }
            Collections.sort(chocolates);
            String ret = chocolates.get(0).name;
            int prevP = chocolates.get(0).P;
            int prevF = chocolates.get(0).F;
            int prevG = chocolates.get(0).G;
            int prevTot = chocolates.get(0).totalScore();
            for(int i=1; i<chocolates.size(); i++) {
                int P = chocolates.get(i).P;
                int F = chocolates.get(i).F;
                int G = chocolates.get(i).G;
                int tot = chocolates.get(i).totalScore();
                if(P != prevP || F != prevF || G != prevG || tot != prevTot) break;
                prevP = P;
                prevF = F;
                prevG = G;
                prevTot = tot;
                ret += "," + chocolates.get(i).name;
            }
            System.out.println(ret);

        }
    }
    static void run() {

    }
    static class Chocolate implements Comparable<Chocolate> {
        String name;
        int P, F, G;
        public Chocolate(String name, int P, int F, int G){
            this.name=name;
            this.P=P;
            this.F=F;
            this.G=G;
        }
        public int totalScore(){
            return P+F+G;
        }
        @Override
        public int compareTo(Chocolate other) {
            if(totalScore() == other.totalScore()) {
                if(F == other.F && G == other.G) {
                    return Integer.compare(other.P, P);
                }
                else if(G == other.G) {
                    return Integer.compare(other.F, F);
                }
                return Integer.compare(other.G, G);
            }
            return Integer.compare(other.totalScore(), totalScore());
        }
    }
}
