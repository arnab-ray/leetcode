package string.easy;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            boolean plusSeen = false, atRate = false;
            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c != '.' && c != '+' && c != '@') {
                    if (!plusSeen) {
                        sb.append(c);
                    }
                } else if (c == '+') {
                    plusSeen = true;
                } else if (c == '.' && atRate) {
                    sb.append('.');
                } else if (c == '@') {
                    sb.append('@');
                    plusSeen = false;
                    atRate = true;
                }
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
