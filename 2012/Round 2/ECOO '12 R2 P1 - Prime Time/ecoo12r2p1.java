import java.util.*;
public class ecoo12r2p1 {
	static final int MAXN = 5 * 100000;
	static boolean prime[] = new boolean[MAXN + 1];
	static Map<Integer, Character> mp = new HashMap<Integer, Character>();
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		sieve(); initMap();
		for(int testcases = 1; testcases <= 5; testcases++) {
			int n = sc.nextInt(); long codedMessages[] = new long[n], decodedMessages[] = new long[n];
			for(int i = 0; i < n; i++) codedMessages[i] = sc.nextInt();
			
			int key = findPrime(codedMessages); decodedMessages = deKey(codedMessages, key);
			String ans = "";
			for(int i = 0; i < decodedMessages.length; i++)
				ans += decode(decodedMessages[i]);
			
			System.out.println(ans);
		}
		sc.close();
	}
	static String decode(long num) {
		
		int a = (int)(num / 100), b = (int)(num % 100);
		return String.valueOf(mp.get(a)) + String.valueOf(mp.get(b));
	}
	static long[] deKey(long codedMessages[], int key) {
		long decodedMessages[] = new long[codedMessages.length];
		for(int i = 0; i < codedMessages.length; i++)
			decodedMessages[i] = codedMessages[i] / key;
		return decodedMessages;
	}
	static int findPrime(long codedMessages[]) {
		for(int num = MAXN; num >= 2; num--) {
			for(int i = 0; i < codedMessages.length; i++) {
				if(prime[num] == false && codedMessages[i] % num == 0 && codedMessages[i] / num <= 3030)
					return num;
			}
		}
		return 2;
	}
	static void initMap() {
		int j = 1;
		for(char i = 'A'; i <= 'Z'; i++) { mp.put(j, i); j++;}
		mp.put(0, ' ');
		mp.put(27, '.');
		mp.put(28, ',');
		mp.put(29, '!');
		mp.put(30, '?');
	}
	static void sieve() {
		for(int i = 2; i * i < prime.length; i++) 
			if(prime[i] == false)
				for(int j = i * i; j < prime.length; j += i)
					prime[j] = true;
	}
}
