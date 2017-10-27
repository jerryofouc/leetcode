import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by xiaojiez on 3/17/17.
 */
public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length() <2){
            return false;
        }
        int l = s.length();
        HashSet<Integer> primeSet = new HashSet<>();
        for(int i=2;i<l;i++){
            if(isPrime(i,primeSet)){
                primeSet.add(i);
            }
        }
        primeSet.add(s.length());
        for(Integer p : primeSet){
            if(s.length()%p == 0){
                int last = s.length()/p;
                String min = s.substring(0,last);
                boolean isRepeated = true;
                for(int i=0;i<s.length()/last;i++){
                    if(!min.equals(s.substring(last*i,last*(i+1)))){
                        isRepeated = false;
                    }
                }
                if(isRepeated){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isPrime(int n,HashSet<Integer> primeSet) {
        for(Integer i : primeSet){
            if(n%i == 0){
                return false;
            }
            if(i>Math.sqrt(n)){
                break;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("ababab"));
        CopyOnWriteArrayList copyOnWriteArrayList;
    }
}
