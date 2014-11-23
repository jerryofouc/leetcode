package jerryofouc.github.io;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zhangxiaojie
 *         2014-11-22 21:37
 *         功能介绍:
 */
public class TextJustification {
    public static void main(String args[]){
        String[] words = {"What","must","be","shall","be."};
        System.out.println(fullJustify(words,12));
    }

    public static List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();

        boolean isBegin = true;
        List<String> line = new ArrayList<String>();
        int lineLength = 0;
        int index = 0;
        for (String w : words) {
            if (isBegin) {
                line = new ArrayList<String>();
            }
            if (isBegin) {
                lineLength += w.length()+1;
                line.add(w);
                isBegin = false;
            } else {
                if (lineLength + w.length()  <= L) {
                    lineLength += w.length() + 1;
                    line.add(w);
                } else {//组装」
                    String ll = "";
                    if (line.size() == 1) {
                        ll = line.get(0) + getKBlank(L - line.get(0).length());
                    } else {
                        int bn = (L - lineLength+line.size()) / (line.size() - 1);
                        int bb = (L - lineLength+line.size()) % (line.size() - 1);
                        Iterator<String> iterator = line.iterator();
                        while (iterator.hasNext()) {
                            ll += iterator.next();
                            if (iterator.hasNext()) {
                                ll += getKBlank(bn);
                                if (bb-- > 0) {
                                    ll += " ";
                                }
                            }
                        }
                    }
                    result.add(ll);
                    line.clear();
                    isBegin = true;

                    if(index < words.length){
                        lineLength = w.length() + 1;
                        line.add(w);
                        isBegin = false;
                    }


                }
            }
            index++;

        }

        if (!isBegin) {
            Iterator<String> iterator = line.iterator();
            String ll ="";
            while (iterator.hasNext()) {
                ll += iterator.next();
                if (iterator.hasNext()) {
                    ll += " ";
                }
            }

            ll += getKBlank(L - lineLength +1);
            result.add(ll);
        }

        return result;

    }

    private static String getKBlank(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
}
