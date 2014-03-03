package jerryofouc.github.io;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zhangxiaojie
 * Date: 2/27/14
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
public class CloneGraph {
    class UndirectedGraphNode {
             int label;
             ArrayList<UndirectedGraphNode> neighbors;
             UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        Map<Integer,UndirectedGraphNode> hasBuildMap = new HashMap<Integer, UndirectedGraphNode>();
        Set<Integer> hasVisitSet = new HashSet<Integer>();
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        hasBuildMap.put(head.label,head);
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode u = stack.pop();
            hasVisitSet.add(u.label);
            UndirectedGraphNode uc = hasBuildMap.get(u.label);
            if(u.neighbors != null){
                for(UndirectedGraphNode n : u.neighbors){
                    UndirectedGraphNode c = hasBuildMap.get(n.label);
                    if(c == null){
                        c = new UndirectedGraphNode(n.label);
                        hasBuildMap.put(n.label,c);
                    }
                    uc.neighbors.add(c);
                    if(!hasVisitSet.contains(n.label)&&!stack.contains(n)){
                        stack.push(n);
                    }
                }
            }
        }
        return head;
    }


}
