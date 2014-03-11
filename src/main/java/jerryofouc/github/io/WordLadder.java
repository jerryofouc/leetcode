package jerryofouc.github.io;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 3/2/14
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
public class WordLadder {
    public static class Pair {
        boolean hasVisted;
        String word;
        int distance;
        public Pair(boolean hasVisted, String word, int distance) {
            this.hasVisted = hasVisted;
            this.word = word;
            this.distance = distance;
        }
    }

    public static int ladderLength(String start, String end, HashSet<String> dict) {
        dict.add(start);
        dict.add(end);

        HashMap<String, Pair> visitMap = new HashMap<String, Pair>();
        for (String w : dict) {
            if (w.equals(start)) {
                visitMap.put(start,new Pair(false,w, 0));
            } else {
                visitMap.put(w,new Pair(false,w, Integer.MAX_VALUE));
            }
        }


        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        visitMap.get(start).hasVisted = true;
        while(!queue.isEmpty()){
            String cur = queue.poll();
            byte[] bytes=cur.getBytes();
            for(int i=0;i<bytes.length;i++){
                byte cb = bytes[i];
                for(byte j='a';j<='z';j++){
                    if(j != cb){
                        bytes[i] = j;
                        String aj = new String(bytes);
                        if(dict.contains(aj)){
                            Pair pair = visitMap.get(aj);
                            if(!pair.hasVisted){
                                pair.distance = visitMap.get(cur).distance + 1;
                                queue.add(aj);
                                pair.hasVisted = true;
                            }
                        }
                    }
                }
                bytes[i] = cb;
            }
        }

        if(visitMap.get(end).distance == Integer.MAX_VALUE){
            return 0;
        }else{
            return visitMap.get(end).distance+1;
        }
    }

    public static void main(String args[]) {
        String test[] = {"hot","dot","dog","lot","log"};
        HashSet<String> set = new HashSet<String>();

        for (String t : test) {
            set.add(t);
        }
        System.out.println(ladderLength("hit","cog", set));
    }
}
