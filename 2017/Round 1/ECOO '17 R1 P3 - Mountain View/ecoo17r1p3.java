import java.util.*;
public class ecoo17r1p3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++){
            int N = sc.nextInt();
            int heights[] = new int[N+1];
            for(int i=1; i<=N; i++)
                heights[i] = sc.nextInt();
            int best=0;
            int idx=0;
            for(int i=1; i<=N; i++){
                int cnt = visible(heights, i);
                if(cnt > best){
                    best = cnt;
                    idx = i;
                }
            }
            System.out.println(idx);
        }
        sc.close();
    }
    static int visible(int heights[], int mountain) {
        int cnt=0;
        double hi=-0x3f3f3f3f;
        for(int i=mountain+1; i<heights.length; i++){
            double slope = (heights[i] - heights[mountain]) / (double)(i - mountain);
            if(slope > hi){
                hi = slope;
                cnt++;
            }
        }
        hi = -0x3f3f3f3f;
        for(int i=mountain-1; i>=1; i--){
            double slope = -(heights[i] - heights[mountain]) / (double)(i - mountain);
            if(slope > hi) {
                hi = slope;
                cnt++;
            }
        }
        return cnt;
    }
}
