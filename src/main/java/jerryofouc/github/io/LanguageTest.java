package jerryofouc.github.io;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;

/**
 * @author zhangxiaojie
 *         2014-11-05 23:43
 *         功能介绍:
 */
public class LanguageTest {
    public static void main(String args[]) throws LangDetectException {
        DetectorFactory.loadProfile("/Users/zhangxiaojie/Downloads/langdetect-03-03-2014/profiles");
        Detector detector = DetectorFactory.create();
        detector.append("toda barranquilla");
        String lang = detector.detect();
        System.out.println(lang);
    }
}
