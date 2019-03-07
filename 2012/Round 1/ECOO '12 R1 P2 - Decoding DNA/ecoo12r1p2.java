import java.util.*;
public class ecoo12r1p2 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 5; t++) {
			String s = sc.next();
			int startIndex = s.indexOf("TATAAT") + 10;
			s = s.substring(startIndex);
			System.out.println(t+": " + findRNA(findComplmentary(s.substring(0, find(s)) ) ) );
		}
		sc.close();
	}
	static int find(String s) {
		for(int i = 0; i < s.length() - 6; i++) {
			for(int j = i + 6; j < s.length(); j++) { 
				String cur = s.substring(i, j);
				String tempS = s.substring(j);
				if(tempS.contains(findReverse(cur))) {
					return i;
				}
			}
		}
		return -1;
	}
	static String findReverse(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) 
			res += convert(s.charAt(i));
		StringBuilder sb = new StringBuilder(res);
		return sb.reverse().toString();
	}
	static String findRNA(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'T') res += "U";
			else res += s.charAt(i);
		}
		return res;
	}
	static String findComplmentary(String s) {
		String res = "";
		for(int i = 0; i < s.length(); i++) 
			res += convert(s.charAt(i));
		return res;
	}
	static char convert(char s) {
		if(s == 'T') return 'A';
		if(s == 'A') return 'T';
		if(s == 'C') return 'G';
		if(s == 'G') return 'C';
		return 'z';
	}
}
