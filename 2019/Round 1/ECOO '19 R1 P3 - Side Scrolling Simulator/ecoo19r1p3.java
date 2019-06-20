import java.util.*;
public class ecoo19r1p3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++){
            // INPUT
            int J = sc.nextInt(); // jump height of loo e.g
            int W = sc.nextInt(); // width of the level
            int H = sc.nextInt(); // height of the level

            pair start=new pair(0,0), end=new pair(0, 0); // start and end coordinates of the loo e.g

            char g[][] = new char[H][W]; // the level
            for(int i=0; i<H; i++){
                String cur = sc.next();
                for(int j=0; j<W; j++){
                    g[i][j] = cur.charAt(j);
                    if(g[i][j] == 'L') start = new pair(i, j);
                    if(g[i][j] == 'G') end = new pair(i, j);
                }
            }
            // END OF INPUT
            int r=start.r, c=start.c;

            int idx=-1; //  stores the first column that I'm unable to get across
            main: while(r < H && c < W) {
               // System.out.println(r+ " " + c + " " + g[r][c]);
                if(g[r][c] == 'G') // I have reached the end
                    break;

                if(g[r][c] == '@') { // i need to jump
                    // CHECK IF I CAN JUMP OVER THE WALL
                    int height=0; // stores the height of the wall
                    for(int i=r;i>=r-J-1;i--){
                        if(height > J || i<0) {
                            idx=c;
                            break main;
                        }
                        if(g[i][c] == '@') height++;
                        if(g[i][c] == '.') break;
                    }

                    // CHECK IF WHEN IM JUMPING, THERE IS SOMETHING ABOVE ME
                    for(int i=r; i>=r-height; i--){
                        if(g[i][c-1] == '@'){
                            idx=c;
                            break main;
                        }
                    }

                    // SEE IF MY LANDING SPOT IS ON A `@~
                    for(int i=start.r-height; i<H; i++){
                        if(g[i][c+1] == '@'){
                            idx=c;
                            break main;
                        }
                    }
                }
                c++; // move forward
            }
            System.out.println(idx==-1?"CLEAR": idx+1);
        }
        sc.close();
    }
    static class pair {
        int r, c;
        public pair(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
}
