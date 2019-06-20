import java.util.*;
public class ecoo16r1p3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++){
            int N = sc.nextInt();
            LinkedList<Integer> nums = new LinkedList<Integer>();
            for(int i=0; i<N; i++) {
                int x = sc.nextInt();
                nums.add(x);
            }
            int next=N;
            int right=0, left=0, cost=0;
            while(next>1){
                left = nums.indexOf(next-1);
                right = nums.indexOf(next);
                if(left > right){
                    cost += left;
                    int add=nums.get(left);
                    nums.remove(left);
                    nums.addFirst(add);
                }
                next--;
            }
            System.out.println(cost);
        }
        sc.close();
    }
}
