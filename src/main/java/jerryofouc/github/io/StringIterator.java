package jerryofouc.github.io;

/**
 * Created by xiaojiez on 6/11/17.
 */
public class StringIterator {
    private String compressedString;
    int curOriginIndex = 0;
    int curCount = -1;
    int curNum = -1;
    int nextIndex = 0;
    public StringIterator(String compressedString) {
        this.compressedString = compressedString;
    }

    public char next() {
        char retVal = ' ';
        if(curOriginIndex<compressedString.length()){
            if(curCount == -1){
                int i=curOriginIndex+1;
                for(;i<compressedString.length()
                        &&this.compressedString.charAt(i)<='9'
                        &&this.compressedString.charAt(i)>='0';i++){

                }
                this.curCount = Integer.parseInt(compressedString.substring(curOriginIndex+1,i));
                this.curNum = 0;
                this.nextIndex = i;
            }
            retVal = compressedString.charAt(curOriginIndex);
            this.curNum++;
            if(this.curNum == this.curCount){
                this.curNum = -1;
                this.curCount = -1;
                curOriginIndex = nextIndex;
            }

        }
        return retVal;
    }

    public boolean hasNext() {
        return nextIndex < compressedString.length() || curCount != -1;
    }

    public static void main(String[] args) {
        StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
        iterator.next(); // return 'L'
        iterator.next(); // return 'e'
        iterator.next(); // return 'e'
        iterator.next(); // return 't'
        iterator.next(); // return 'C'
        iterator.next(); // return 'o'
        iterator.next(); // return 'd'
        iterator.hasNext(); // return true
        iterator.next(); // return 'e'
        iterator.hasNext(); // return false
        iterator.next(); // return ' '
    }
}
