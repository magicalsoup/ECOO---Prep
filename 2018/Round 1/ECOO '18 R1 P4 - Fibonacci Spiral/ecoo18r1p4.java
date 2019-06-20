import java.util.*;
public class ecoo18r1p4 {
    static long fib[] = new long[50];
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        init();
        for(int testcases=1; testcases<=10; testcases++){
            int px=sc.nextInt(), py=sc.nextInt();
            System.out.println(bfs(px, py));
        }
        sc.close();
    }
    static int bfs (int px, int py) {
        rectangle boundingRect = new rectangle(0, -1, 1, 1);
        int n=1;
        boolean flag=false;
        int dir=-1;
        while(!flag){
            if(!inBounds(boundingRect, px, py)){
                dir = (dir+1)%4;
                n+=1;
                boundingRect = build(boundingRect, fib[n], dir);
            }
            else
                flag=true;
        }
        return n;
    }
    static rectangle build(rectangle rect, long add, int dir){
        if(dir == 0)
            return new rectangle(rect.x-add, rect.y, rect.width+add, rect.height);
        else if(dir == 1)
            return new rectangle(rect.x, rect.y, rect.width, rect.height+add);
        else if(dir == 2)
            return new rectangle(rect.x, rect.y, rect.width+add, rect.height);
        return new rectangle(rect.x, rect.y-add, rect.width, rect.height+add);
    }
    static boolean inBounds(rectangle rect, int x, int y){
        return x >=rect.x && x <= rect.x+rect.width && y >= rect.y && y <= rect.y+rect.height;
    }
    static void init(){
        fib[1] = 1;
        fib[2] = 1;
        for(int i=3; i<fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
    }
    static class rectangle {
        long x, y, width, height;
        public rectangle(long x, long y, long width, long height){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
        }
    }
}
