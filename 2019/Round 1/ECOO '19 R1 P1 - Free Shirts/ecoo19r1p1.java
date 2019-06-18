import java.util.*;
public class ecoo19r1p1 {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        for (int testcases = 1; testcases <= 10; testcases++) {
            int N = sc.nextInt(), M = sc.nextInt(), D = sc.nextInt();
            int tshirtdays[] = new int[D + 1];

            for (int i = 1; i <= M; i++)
                tshirtdays[sc.nextInt()]++;

            int dirtyshirts = 0, cleanshirts = N, clean = 0;
            for (int i = 1; i <= D; i++) {
                if (cleanshirts == 0) {
                    clean++;
                    cleanshirts = dirtyshirts;
                    dirtyshirts = 0;
                }
                cleanshirts += tshirtdays[i];
                dirtyshirts++;
                cleanshirts--;
            }
            System.out.println(clean);
        }
        sc.close();
    }
}
