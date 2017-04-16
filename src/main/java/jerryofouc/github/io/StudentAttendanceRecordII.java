package jerryofouc.github.io;

/**
 * Created by xiaojiez on 4/16/17.
 */
public class StudentAttendanceRecordII {
    public static int checkRecord(int n) {
        final long M = 1000000007;
        long[] P = new long[n+1];
        long[] PorL = new long[n+1];
        P[0] = 1;
        PorL[0] = 1;
        P[1] = 1;
        PorL[1] = 2;
        for(int i=2;i<n+1;i++){
            P[i] = PorL[i-1];
            PorL[i] = (P[i]+P[i-1]+P[i-2])%M;
        }

        long result = PorL[n]%M;
        for(int i=0;i<n;i++){
            long s = (PorL[i]*PorL[n-i-1])%M;
            result = (s +result)%M;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord(2));
    }
}
