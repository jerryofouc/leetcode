package jerryofouc.github.io;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Created by xiaojiez on 6/5/17.
 */
public class AccessSystemProperty {
    public static void main(String[] args) {
        System.out.println(System.getSecurityManager());
        AccessController.doPrivileged(
                new PrivilegedAction<Boolean>(){
                    public Boolean run(){
                        System.out.println(System.getProperty("java.home"));
                        return Boolean.TRUE;
                    }
                }
        );
    }
}
