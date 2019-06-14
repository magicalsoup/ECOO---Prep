import java.util.*;
public class ecoo14r1p3 {
    @SuppressWarnings("duplicate")
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=5; testcases++){

            int R = sc.nextInt(), C = sc.nextInt();
            char g[][] = new char[R][C];
            for(int r=0; r<R; r++){
                String s = sc.next();
                for(int c=0; c<C; c++){
                    g[r][c] = s.charAt(c);
                }
            }

            int M = sc.nextInt();
            sc.nextLine();
            ArrayList<pair> bad = new ArrayList<pair>();
            for(int i=0; i<M; i++){
                String word = convert(sc.nextLine());
                search(word, g, bad);
            }

            for(int r=0; r<R; r++){
                for(int c=0; c<C; c++){
                    boolean flag=false;
                    for(pair p: bad){
                        if(p.r == r && p.c == c){
                            flag=true;
                            break;
                        }
                    }
                    if(flag) g[r][c] = '#';
                }
            }
            String ret="";
            for(int r=0; r<R; r++) {
                for (int c = 0; c < C; c++){
                    if(g[r][c] != '#') ret += g[r][c];
                }
            }
            System.out.println(ret);
        }
        sc.close();
    }
    static String convert(String s){
        String ret="";
        for(int i=0; i<s.length(); i++)
            if(Character.isAlphabetic(s.charAt(i)))
                ret += s.charAt(i)+"";
        return ret;
    }
    static void search(String word, char g[][], ArrayList<pair> bad) {
        char firstLetter = word.charAt(0);
        int R = g.length, C = g[0].length;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(g[r][c] == firstLetter){
                    pair start = new pair(r, c);
                    if(checkDiagonalLeftBackword(g, start, word, R, C)) {
                        fillDiagonal(start, word.length(), 1, g, bad);
                        //System.out.println(word + " diag left back");
                    }
                    else if(checkDiagonalLeftForward(g, start, word, R, C)) {
                        fillDiagonal(start, word.length(), 3, g, bad);
                        //System.out.println(word + " diag left for");
                    }
                    else if(checkDiagonalRightBackword(g, start, word, R, C)) {
                        fillDiagonal(start, word.length(), 2, g, bad);
                        //System.out.println(word + " diag right back");
                    }
                    else if (checkDiagonalRightForward(g, start, word, R, C)) {
                        fillDiagonal(start, word.length(), 4, g, bad);
                        //System.out.println(word +" diag right for");
                    }
                    else if(checkHorzontalBackwords(g, start, word, R, C)) {
                        fillHorizontalBackwords(start, new pair(start.r, start.c - word.length()), g, bad);
                        //System.out.println(word + " hor back");
                    }
                    else if(checkHorzontalFoward(g, start, word, R, C)) {
                        fillHorizontalForwards(start, new pair(start.r, start.c + word.length()), g, bad);
                        //System.out.println(word + " hor for");
                    }
                    else if(checkVerticalDownward(g, start, word, R, C)) {
                        fillVerticalDownward(start, new pair(start.r + word.length(), start.c), g, bad);
                        //System.out.println(word + " ver down");
                    }
                    else if(checkVerticalUpward(g, start, word, R, C)) {
                        fillVerticalUpwards(start, new pair(start.r - word.length(), start.c), g, bad);
                        //System.out.println(word + " ver up");
                    }
                }
            }
        }
    }
    static boolean checkDiagonalRightForward(char g[][], pair start, String word, int R, int C) {
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        String dis[][] = new String[R][C];
        q.add(start); vis[start.r][start.c] = true;
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr = cur.r+1, nc = cur.c+1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }
    static boolean checkDiagonalLeftBackword(char g[][], pair start, String word, int R, int C) {
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        String dis[][] = new String[R][C];
        q.add(start); vis[start.r][start.c] = true;
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr = cur.r-1, nc = cur.c-1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }
    static boolean checkDiagonalLeftForward(char g[][], pair start, String word, int R, int C) {
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        String dis[][] = new String[R][C];
        q.add(start); vis[start.r][start.c] = true;
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr = cur.r+1, nc = cur.c-1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }
    static boolean checkDiagonalRightBackword(char g[][], pair start, String word, int R, int C) {
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        String dis[][] = new String[R][C];
        q.add(start); vis[start.r][start.c] = true;
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr = cur.r-1, nc = cur.c+1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }

    static boolean checkHorzontalFoward(char g[][], pair start, String word, int R, int C){
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        vis[start.r][start.c] = true;
        String dis[][] = new String[R][C];
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        q.add(start);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr=cur.r,nc=cur.c+1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }

        return false;
    }
    static boolean checkHorzontalBackwords(char g[][], pair start, String word, int R, int C){
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        vis[start.r][start.c] = true;
        String dis[][] = new String[R][C];
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        q.add(start);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr=cur.r,nc=cur.c-1;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }
    static boolean checkVerticalDownward(char g[][], pair start, String word, int R, int C){
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        vis[start.r][start.c] = true;
        String dis[][] = new String[R][C];
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        q.add(start);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr=cur.r+1,nc=cur.c;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }
    static boolean checkVerticalUpward(char g[][], pair start, String word, int R, int C){
        LinkedList<pair> q = new LinkedList<pair>();
        boolean vis[][] = new boolean[R][C];
        vis[start.r][start.c] = true;
        String dis[][] = new String[R][C];
        dis[start.r][start.c] = String.valueOf(g[start.r][start.c]);
        q.add(start);
        while(!q.isEmpty()) {
            pair cur = q.poll();
            int nr=cur.r-1,nc=cur.c;
            if(nr<0||nc<0||nr>=R||nc>=C||vis[nr][nc]) continue;
            dis[nr][nc] = dis[cur.r][cur.c]+g[nr][nc];
            if(dis[nr][nc].equals(word)) return true;
            vis[nr][nc] = true;
            q.add(new pair(nr, nc));
        }
        return false;
    }

    static void fillVerticalDownward(pair start, pair end, char g[][], ArrayList<pair> bad) {
        for(int i=start.r; i<end.r; i++)
            bad.add(new pair(i, start.c));
    }
    static void fillVerticalUpwards(pair start, pair end, char g[][], ArrayList<pair> bad) {
        for(int i=start.r; i>end.r; i--)
            bad.add(new pair(i, start.c));
    }
    static void fillHorizontalBackwords(pair start, pair end, char g[][], ArrayList<pair> bad) {
        for(int j=start.c; j>end.c; j--)
            bad.add(new pair(start.r, j));
    }
    static void fillHorizontalForwards(pair start, pair end, char g[][], ArrayList<pair> bad){
        for(int j=start.c; j<end.c; j++)
            bad.add(new pair(start.r, j));
    }
    static void fillDiagonal(pair start, int len, int type, char g[][], ArrayList<pair> bad){
        if(type==1){ // if diagonal is Left Backwards
            int r=start.r, c=start.c;
            while(len>0){
                bad.add(new pair(r,c));
                r--;c--;
                len--;
            }
        }
        if(type==2) { // if diagonal is Right Backwards
            int r=start.r, c=start.c;
            while(len>0){
                bad.add(new pair(r,c));
                r--;c++;
                len--;
            }
        }
        if(type==3){ // if diagonal is Left Forwards
            int r=start.r, c=start.c;
            while(len>0){
                bad.add(new pair(r,c));
                r++;c--;
                len--;
            }
        }
        if(type==4){ // if diagonal is Right Forwards
            int r=start.r, c=start.c;
            while(len>0){
                bad.add(new pair(r,c));
                r++;c++;
                len--;
            }

        }
    }
    static class pair {
        int r, c;
        public pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
