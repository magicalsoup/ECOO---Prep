import java.util.*;
public class ecoo13r1p3 {
	static char g[][][][] = new char[4][4][4][4];
	static char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	static int cnt = 0;
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 0; t < 10; t++) {
			cnt = 0;
	        for (int i = 0; i < 4; i++) {
	            for (int k = 0; k < 4; k++) {
	                String line = sc.nextLine();
	                int cur = 0;
	                for (int j = 0; j < 4; j++) {
	                    g[i][j][k] = line.substring(cur, cur + 4).toCharArray();
	                    cur += 4;
	                }
	            }
	        }
	        for(int i = 0; i < 4; i++) {
	        	for(int j = 0; j < 4; j++) {
	        		for(int k = 0; k < 4; k++) {
	        			for(int l = 0; l < 4; l++) {
	        				if(g[i][j][k][l] == '-')
	        					check(i, j, k, l);
	        			}
	        		}
	        	}
	        }
	        System.out.println(cnt);
		}
        sc.close();
	}
	 static void check(int I, int J, int K, int L) {
		 for(int m = 0; m < d.length; m++) {
			 boolean flag = false;
			 for(int k = 0; k < 4; k++) {
				 for(int l = 0; l < 4; l++) {
					 if(g[I][J][k][l] == d[m]) {
						 flag = true;
						 break;
					 }
						 
				 }
				 if(flag) break;
			 }
			 if(flag) continue;
			 flag = false;
			 for(int j = 0; j < 4; j++) {
				 flag = false;
				 for(int l = 0; l < 4; l++) {
					 if(g[I][j][K][l] == d[m]) {
						 flag = true;
						 break;
					 }
				 }
				 if(flag) break;
			 }
			 if(flag) continue;
			 flag = false;
			 for(int i = 0; i < 4; i++) {
				 flag = false;
				 for(int k = 0; k < 4; k++) {
					 if(g[i][J][k][L] == d[m]) {
						 flag = true;
						 break;
					 }
						
				 }
				 if(flag) break;
			 }
			 if(flag) continue;
			 g[I][J][K][L] = d[m];
			 cnt++;
			 return;
		 }
	 	
     }
}
