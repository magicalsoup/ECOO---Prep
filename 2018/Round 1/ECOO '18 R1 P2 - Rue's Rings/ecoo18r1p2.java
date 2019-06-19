import java.util.*;
public class ecoo18r1p2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++) {

            // INPUT + Initializing stuff
            int N = sc.nextInt();
            ArrayList<ArrayList<Integer>> routes = new ArrayList<ArrayList<Integer>>();
            for(int i=0; i<=N; i++) routes.add(new ArrayList<Integer>());
            ArrayList<Integer> issueIds = new ArrayList<Integer>();
            int minDiameter=0x3f3f3f3f;
            for(int i=0; i<=N; i++) routes.add(new ArrayList<Integer>());
            for(int i=0; i<N; i++){
                int id = sc.nextInt();
                int R = sc.nextInt();
                for(int j=0; j<R; j++) {
                    int x = sc.nextInt();
                    minDiameter = Math.min(x, minDiameter);
                    routes.get(id).add(x);
                }
            }
            //-----------------------------------------------
            for(int i=1; i<=N; i++) {
                int count=0;
                for(int j=0; j<routes.get(i).size(); j++){
                    if(routes.get(i).get(j) == minDiameter)
                        count++;
                }
                if(count != 0)
                issueIds.add(i);
            }
            Collections.sort(issueIds);
            String res="{";
            for(Integer route : issueIds)
                res += route + ",";
            res = res.substring(0, res.length()-1) + "}";
            System.out.println(minDiameter + " " + res);
        }
        sc.close();
    }
}
