package jerryofouc.github.io;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class IPO {
    static class Pair{
        public Pair(int p, int c) {
            this.p = p;
            this.c = c;
        }

        int p;
        int c;
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> captalPair = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.c>o2.c){
                    return 1;
                }else if(o1.c<o2.c){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        PriorityQueue<Pair> revenuePair = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.p>o2.p){
                    return -1;
                }else if(o1.p<o2.p){
                    return 1;
                }else {
                    return 0;
                }
            }
        });

        for(int i=0;i<capital.length;i++){
            captalPair.add(new Pair(profits[i],capital[i]));
        }

        while (k>0){
            while (!captalPair.isEmpty()&&captalPair.peek().c<=w){
                revenuePair.add(captalPair.poll());
            }
            Pair pair = revenuePair.poll();
            if(pair == null){
                return w;
            }
            w += (pair.p);
            k--;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] p = {1,2,3};
        int[] c = {1,1,2};
        System.out.println(findMaximizedCapital(2,0,p,c));
    }
}
