import java.util.Scanner;
public class ecoo12r2p2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        for(int testcases=1; testcases<=10; testcases++) {
            String password = sc.next();
            System.out.println(totalScore(password));
        }
        sc.close();
    }
    static int basicRequirements(String pass) {
        int symbol=0, upper=0, lower=0, digit=0;
        for(int i=0; i<pass.length(); i++){
            char c = pass.charAt(i);
            if(!Character.isDigit(c) && !Character.isAlphabetic(c)) symbol++;
            if(Character.isUpperCase(c)) upper++;
            if(Character.isLowerCase(c)) lower++;
            if(Character.isDigit(c)) digit++;
        }
        int cnt=0; int ans=0;
        if(symbol>0) {
            cnt++;
            ans+=2;
        }
        if(upper>0) {
            cnt++;
            ans+=2;
        }
        if(lower>0) {
            cnt++;
            ans+=2;
        }
        if(digit>0) {
            cnt++;
            ans+=2;
        }

        if(cnt >= 3 && pass.length() >= 8) ans +=2;
        else ans = 0;
        return ans;
    }
    static int upperCase(String pass) {
        int upper=0;
        for(int i=0; i<pass.length(); i++)
            if(Character.isUpperCase(pass.charAt(i))) upper++;
        if(upper == 0) return 0;
        return (pass.length() - upper) * 2;
    }
    static int lowerCase(String pass) {
        int lower=0;
        for(int i=0; i<pass.length(); i++)
            if(Character.isLowerCase(pass.charAt(i))) lower++;
        if(lower == 0) return 0;
        return (pass.length() - lower) * 2;
    }
    static int digits(String pass) {
        int digits=0;
        for(int i=0; i<pass.length(); i++)
            if(Character.isDigit(pass.charAt(i))) digits++;
        if(digits == pass.length()) return 0;
        return digits * 4;
    }
    static int symbols (String pass) {
        int symbols=0;
        for(int i=0; i<pass.length(); i++) {
            char c = pass.charAt(i);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) symbols++;
        }
        return symbols * 6;
    }
    static int middleDigitsAndSymbols(String pass) {
        int symbolsAndDigits=0;
        for(int i=1; i<pass.length()-1; i++) {
            char c = pass.charAt(i);
            if ((!Character.isAlphabetic(c) && !Character.isDigit(c)) || Character.isDigit(c)) symbolsAndDigits++;
        }
        return symbolsAndDigits * 2;
    }
    static int lettersOnly(String pass) {
        boolean lettersOnly=true;
        for(int i=0; i<pass.length(); i++)
            if (!Character.isAlphabetic(pass.charAt(i)))
                lettersOnly = false;
        if(lettersOnly) return pass.length();
        return 0;
    }
    static int digitsOnly(String pass) {
        boolean digitsOnly=true;
        for(int i=0; i<pass.length(); i++)
            if (!Character.isDigit(pass.charAt(i)))
                digitsOnly = false;
        if(digitsOnly) return pass.length();
        return 0;
    }
    static int consecutiveUpperCase(String pass) {
        int cnt=0;
        for(int i=0; i<pass.length(); i++) {
            int consec=0;
            while(i < pass.length() && Character.isUpperCase(pass.charAt(i))) {
                consec++;
                i++;
            }
            if(consec > 0)
                cnt += (consec-1) * 2;
        }
        return cnt;
    }
    static int consecutiveLowerCase(String pass) {
        int cnt=0;
        for(int i=0; i<pass.length(); i++) {
            int consec=0;
            while(i < pass.length() && Character.isLowerCase(pass.charAt(i))) {
                consec++;
                i++;
            }
            if(consec > 0)
                cnt += (consec-1) * 2;
        }
        return cnt;
    }
    static int length(String pass){
        return pass.length() * 4;
    }
    static int consecutiveDigits(String pass) {
        int cnt=0;
        for(int i=0; i<pass.length(); i++) {
            int consec=0;
            while(i < pass.length() && Character.isDigit(pass.charAt(i))) {
                consec++;
                i++;
            }
            if(consec > 0)
                cnt += (consec-1) * 2;
        }
        return cnt;
    }
    static int sequentialLetters(String pass) {
        int maxlen=0;
        for(int i=0; i<pass.length()-1; i++) {
            boolean upper = Character.isUpperCase(pass.charAt(i));
            int upOrDown = Integer.MAX_VALUE;
            if((Character.isUpperCase(pass.charAt(i)) && Character.isUpperCase(pass.charAt(i+1))) ||
                    (Character.isLowerCase(pass.charAt(i)) && Character.isLowerCase(pass.charAt(i+1))))
            upOrDown = pass.charAt(i) - pass.charAt(i+1);

            if(upOrDown != 1 && upOrDown != -1) upOrDown = Integer.MAX_VALUE;
            if (upper && Character.isAlphabetic(pass.charAt(i))) {

                String cur = "";
                int k=i;
                while (k < pass.length() && Character.isAlphabetic(pass.charAt(k)) && Character.isUpperCase(pass.charAt(k))) {
                    cur += pass.charAt(k);
                    k++;
                }
                for (int j = 1; j < cur.length(); j++) {
                    if (cur.charAt(j-1) - cur.charAt(j)!= upOrDown) break;
                    maxlen = Math.max(j + 1, maxlen);
                }
            } else if (!upper && Character.isAlphabetic(pass.charAt(i))) {
                String cur = "";
                int k=i;
                while (k < pass.length() && Character.isAlphabetic(pass.charAt(k)) && Character.isLowerCase(pass.charAt(k))) {
                    cur += pass.charAt(k);
                    k++;
                }
                for (int j = 1; j < cur.length(); j++) {
                    if (cur.charAt(j-1) - cur.charAt(j) != upOrDown) break;
                    maxlen = Math.max(j + 1, maxlen);
                }
            }
        }
        if(maxlen > 2) return 3*(maxlen-2);
        return 0;
    }
    static int sequentialDigits(String pass) {
        int maxlen=0;
        for(int i=0; i<pass.length()-1; i++) {
            char c = pass.charAt(i);
            int upOrDown = pass.charAt(i) - pass.charAt(i+1);
            if(upOrDown != 1 && upOrDown != -1) upOrDown = Integer.MAX_VALUE;
            if(Character.isDigit(c)) {
                String cur="";
                int k=i;
                while (k < pass.length() && Character.isDigit(pass.charAt(k))) {
                    cur += pass.charAt(k);
                    k++;
                }
                for(int j=1; j<cur.length(); j++) {
                    if(cur.charAt(j-1) - cur.charAt(j)!= upOrDown) break;
                    maxlen = Math.max(j+1, maxlen);
                }
            }
        }
        if(maxlen > 2) return 3*(maxlen-2);
        return 0;
    }
    static String totalScore(String pass) {
        int score = length(pass) + basicRequirements(pass) + upperCase(pass) + lowerCase(pass) + digits(pass) + symbols(pass)
                + middleDigitsAndSymbols(pass) - lettersOnly(pass) - digitsOnly(pass) - consecutiveUpperCase(pass)
                - consecutiveLowerCase(pass) - consecutiveDigits(pass) - sequentialLetters(pass) - sequentialDigits(pass);
        if(score > 100) score = 100;
        if(score < 0) score = 0;
        String strength;
        if(score <= 20) strength="Very Weak";
        else if(score <= 40) strength="Weak";
        else if(score <= 60) strength="Good";
        else if(score <= 80) strength="Strong";
        else strength="Very Strong";
        return strength + " (score = " + score + ")";
    }
    static void debug(String pass) {
        System.out.println("length " + length(pass));
        System.out.println("basicRequirements " + basicRequirements(pass));
        System.out.println("upperCase " + upperCase(pass));
        System.out.println("lowerCase " + lowerCase(pass));
        System.out.println("digits " + digits(pass));
        System.out.println("symbols " + symbols(pass));
        System.out.println("middleDigitsAndSymbols " + middleDigitsAndSymbols(pass));
        System.out.println("lettersOnly " + lettersOnly(pass));
        System.out.println("digitsOnly " + digitsOnly(pass));
        System.out.println("consecutiveUpperCase " + consecutiveUpperCase(pass));
        System.out.println("consecutiveLowerCase " + consecutiveLowerCase(pass));
        System.out.println("consecutiveDigits " + consecutiveDigits(pass));
        System.out.println("sequentialLetters " + sequentialLetters(pass));
        System.out.println("sequentialDigits " + sequentialDigits(pass));

    }
}
