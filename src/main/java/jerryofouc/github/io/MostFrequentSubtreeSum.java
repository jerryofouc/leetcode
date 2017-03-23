package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojiez on 3/23/17.
 */
public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Map<Integer,Integer> map = new HashMap<>();
        find(root,map);
        int max = Integer.MIN_VALUE;
        Map<Integer,List<Integer>> numMap = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            List<Integer> list = numMap.get(entry.getValue());
            if(list == null){
                list = new ArrayList<>();
            }
            list.add(entry.getKey());
            numMap.put(entry.getValue(),list);
            if(entry.getValue()>max){
                max = entry.getValue();
            }
        }

        List<Integer> list = numMap.get(max);
        int[] ret = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

    private int find(TreeNode root, Map<Integer, Integer> map) {
        if(root == null){
            return 0;
        }
        int left = find(root.left,map);
        int right = find(root.right,map);
        map.put(root.val+left+right,map.getOrDefault(root.val+left+right,0)+1);
        return root.val+left+right;
    }


}
