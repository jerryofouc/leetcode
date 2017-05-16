package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 5/15/17.
 */
public class KillProcess {
    private static class Tuple{
        int parent;
        List<Integer> children = new ArrayList<>();
    }
    public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer,Tuple> map = new HashMap<>();
        for(int i=0;i<pid.size();i++){
            int cur = pid.get(i);
            Tuple tuple = map.getOrDefault(cur,new Tuple());
            tuple.parent = ppid.get(i);
            map.put(cur,tuple);
            Tuple parentTuple = map.getOrDefault(tuple.parent,new Tuple());
            parentTuple.children.add(cur);
            map.put(tuple.parent,parentTuple);
        }

        List<Integer> ret = new ArrayList<>();
        Stack<Integer> children = new Stack<>();
        children.add(kill);
        while (!children.isEmpty()){
            int a = children.pop();
            ret.add(a);
            Tuple t = map.get(a);
            if(t!= null && !t.children.isEmpty()){
                children.addAll(t.children);
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
