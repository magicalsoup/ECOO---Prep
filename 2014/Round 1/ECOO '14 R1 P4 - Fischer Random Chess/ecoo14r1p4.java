import java.util.*;
public class ecoo14r1p4 {
    private static ArrayList<Character> pieces = new ArrayList<Character>(Arrays.asList('R','B','N','Q','K','N','B','R'));
    static Set<String> allPossibleConfigurations = new HashSet<String>();
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        initSet();
        ArrayList<String> possibleConfigurations = new ArrayList<String>();
        for(String it:  allPossibleConfigurations) {
            possibleConfigurations.add(it.toString());
        }
        for(int testcases=1; testcases<=10; testcases++) {
            for(int r=0; r<8; r++) {
                String row=sc.next();
                int possible=0;
                for(String s : possibleConfigurations){
                    if(matches(s, row))
                        possible++;
                }
                System.out.println(possible);
            }
        }
        sc.close();
    }
    static boolean matches(String a, String b){
        for(int i=0; i<a.length(); i++){
            if(b.charAt(i) != '_' && a.charAt(i) == b.charAt(i)) continue;
            else if(b.charAt(i) != '_') return false;
        }
        return true;
    }
    static ArrayList<Character> generateFirstRank(){
        do{
            Collections.shuffle(pieces);
        }while(!check(pieces.toString().replaceAll("[^\\p{Upper}]", ""))); //List.toString adds some human stuff, remove that

        return pieces;
    }
    static boolean check(String rank){
        if(!rank.matches(".*R.*K.*R.*")) return false;			//king between rooks
        if(!rank.matches(".*B(..|....|......|)B.*")) return false;	//all possible ways bishops can be placed
        return true;
    }
    static String convertToString(ArrayList<Character> a) {
        String ret="";
        for(Character e : a)
            ret = ret + String.valueOf(e);
        return ret;
    }
    static void initSet() {
        for(int i=1; i<=960*10+1; i++){
            String cur=convertToString(generateFirstRank());
            allPossibleConfigurations.add(cur);
        }
    }
}
