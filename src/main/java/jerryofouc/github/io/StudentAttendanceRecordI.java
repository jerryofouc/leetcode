package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/16/17.
 */
public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int absentCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                absentCount++;
            }
            if(absentCount>1){
                return false;
            }
        }

        if(s.length()<3){
            return true;
        }

        for(int i=2;i<s.length();i++){
            if(s.charAt(i-2) == 'L' && s.charAt(i-1) == 'L'&&s.charAt(i) == 'L'){
                return false;
            }
        }

        return true;
    }
}
