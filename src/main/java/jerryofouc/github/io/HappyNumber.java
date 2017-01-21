package jerryofouc.github.io;

import java.util.HashSet;

/**
 * Created by xiaojiez on 1/21/17.
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        if(n == 1){
            return true;
        }

        HashSet<Integer> hashSet = new HashSet<Integer>();

        hashSet.add(n);

        while (true){
            int next = 0;
            while (n !=0){
                next += (n%10)*(n%10);
                n = n/10;
            }
            if(hashSet.contains(next)){
                return false;
            }else if(next==1){
                return true;
            }else {
                hashSet.add(next);
            }
            n=next;
        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
