package jerryofouc.github.io;

import java.util.TreeSet;

/**
 * Created by xiaojiez on 3/25/17.
 */
public class BeautifulArrangement {
    public static int countArrangement(int N) {
        int count = 0;
        TreeSet<Integer> l = new TreeSet<>();
        for(int i=1;i<=N;i++){
            l.add(i);
        }

        return range(1,l);

    }

    private static int range(int i, TreeSet<Integer> l) {
        if(l.size() == 1){
            int a = l.first();
            if(a%i == 0 || i%a == 0){
                return 1;
            }else {
                return 0;
            }
        }
        int sum = 0;
        for(Integer a : l){
            if(a%i == 0 || i%a == 0){
                TreeSet<Integer> ll = new TreeSet<>(l);
                ll.remove(a);
                sum += range(i+1,ll);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }
}
