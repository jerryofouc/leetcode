package jerryofouc.github.io;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 5/8/14
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public class ScrambleString {
    public static Map<Pair<String,String>,Boolean> mem = new HashMap<Pair<String, String>, Boolean>();
    public static boolean isScramble(String s1, String s2) {
        Boolean memResult = mem.get(new Pair<String, String>(s1,s2));
        if(memResult != null){
            return memResult;
        }
        if(s1.equals(s2)){
            return true;
        }else if(s1.length() != s2.length() || (s1.length()==1 && !s1.equals(s2))){
            return false;
        }else {
            for(int i=1;i<s1.length();i++){
                if(isScramble(s1.substring(0,i),s2.substring(0,i))
                        && isScramble(s1.substring(i,s1.length()),s2.substring(i,s2.length()))){
                    mem.put(new Pair<String, String>(s1,s2),true);
                    return true;
                }

                if(isScramble(s1.substring(0,i),s2.substring(s2.length()-i,s2.length()))
                        && isScramble(s1.substring(i,s1.length()),s2.substring(0,s2.length()-i))){
                    mem.put(new Pair<String, String>(s1,s2),true);
                    return true;
                }
            }
            mem.put(new Pair<String, String>(s1,s2),false);
            return false;
        }
    }

    public static void main(String args[]){
        System.out.println(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
    }

    public static class Pair<L,R>{
        L left;
        R right;

        public L getLeft() {
            return left;
        }

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public R getRight() {
            return right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;

            Pair pair = (Pair) o;

            if (!left.equals(pair.left)) return false;
            if (!right.equals(pair.right)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = left.hashCode();
            result = 31 * result + right.hashCode();
            return result;
        }
    }

}
