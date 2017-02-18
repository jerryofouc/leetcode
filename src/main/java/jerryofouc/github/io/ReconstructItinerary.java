package jerryofouc.github.io;

import java.util.*;

/**
 * Created by xiaojiez on 2/18/17.
 */
public class ReconstructItinerary {
    public static List<String> findItinerary(String[][] tickets) {
        Map<String,List<String>> map = new HashMap<>();
        for(String[] t : tickets){
            List<String> a = map.get(t[0]);
            if(a == null){
                a = new ArrayList<>();
            }
            a.add(t[1]);
            Collections.sort(a);
            map.put(t[0],a);
        }
        List<String> result = new ArrayList<>();
        result.add("JFK");
        findItinerary("JFK",map,result,tickets.length);
        return result;
    }

    private static void findItinerary(String start, Map<String, List<String>> map,
                                      List<String> result,int n) {
        List<String> dests = map.get(start);
        if(dests==null||dests.size() == 0){
            return;
        }
        List<String> list = new ArrayList<>();
        for(String d :dests){
            list.add(d);
        }
        for(int i=0;i<list.size();i++){
            result.add(list.get(i));
            dests.remove(i);
            findItinerary(list.get(i),map,result,n);
            if(result.size() == n+1){
                return;
            }
            result.remove(result.size()-1);
            dests.add(i,list.get(i));
        }
    }

    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}};
        System.out.println(findItinerary(tickets));
    }
}
