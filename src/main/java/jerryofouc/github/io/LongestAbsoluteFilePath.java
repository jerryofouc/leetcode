package jerryofouc.github.io;

/**
 * Created by xiaojiez on 3/1/17.
 */
public class LongestAbsoluteFilePath {
    public static int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        int max = 0;
        int[] a = new int[files.length];
        for(int i=0;i<files.length;i++){
            int level =  getTabNum(files[i]);
            if(level == 0){
                a[level] = files[i].length();
                if(files[i].contains(".")){
                    return files[i].length();
                }
            }else {
                a[level] = a[level-1] + 1 + files[i].length()-level;
                if(files[i].contains(".")){
                    if(max < a[level]){
                        max = a[level];
                    }
                }
            }
        }
        return max;
    }

    private static int getTabNum(String file) {
        int count = 0;
        for(int i=0;i<file.length();i++){
            if(file.charAt(i) == '\t'){
                count++;
            }else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
