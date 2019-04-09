package Algorithms;

import java.util.HashSet;
import java.util.Set;

public class NumberUniqueEmails {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int atSign = email.indexOf('@');
            String local = email.substring(0, atSign);
            String domain = email.substring(atSign);
            local = local.replaceAll("\\.", "");
            int plusSign = email.indexOf('+');
            if (plusSign >= 0) {
                local = local.substring(0, plusSign);
            }
            set.add(local + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        NumberUniqueEmails sol = new NumberUniqueEmails();
        System.out.println(sol.numUniqueEmails(new String[] {
                "kuangxiao.ace@gmail.com",
                "kuangxiao+ace@gmail.com",
                "kuangxiao..ace@gmail.com",
        }));

    }
}
