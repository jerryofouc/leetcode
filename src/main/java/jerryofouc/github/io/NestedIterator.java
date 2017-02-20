package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaojiez on 2/20/17.
 */
 interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private Iterator<Integer> integerIterator ;
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger1 : nestedList){
            for(Integer  i : this.getList(nestedInteger1)){
                list.add(i);
            }
        }
        integerIterator = list.iterator();
    }

    List<Integer> getList(NestedInteger nestedInteger){
        List<Integer> list = new ArrayList<>();
        if(nestedInteger.isInteger()){
            list.add(nestedInteger.getInteger());
        }else {
            for(NestedInteger nestedInteger1 : nestedInteger.getList()){
                for(Integer  i : this.getList(nestedInteger1)){
                    list.add(i);
                }
            }
        }
        return list;
    }

    @Override
    public Integer next() {
        return integerIterator.next();
    }

    @Override
    public boolean hasNext() {
        return integerIterator.hasNext();
    }
}