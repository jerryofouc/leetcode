package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by xiaojiez on 2/2/17.
 */
public class PeekingIterator implements Iterator<Integer>{
    private List<Integer> list = new ArrayList<>();
    private int currentIndex;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(currentIndex>=list.size()){
            throw new IllegalArgumentException();
        }
        return list.get(currentIndex);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(currentIndex>=list.size()){
            throw new IllegalArgumentException();
        }
        return list.get(currentIndex++);
    }

    @Override
    public boolean hasNext() {
        return currentIndex<list.size();
    }
}
