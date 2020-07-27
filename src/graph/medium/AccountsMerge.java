package graph.medium;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> mailIdToAccount = new HashMap<>();
        for(List<String> account : accounts) {
            for(int i = 1; i < account.size(); i++) {
                String mailId = account.get(i);
                if(mailIdToAccount.get(mailId) == null) {
                    mailIdToAccount.put(mailId, new TreeSet<>(account));
                } else {
                    Set<String> accountDetails = mailIdToAccount.get(mailId);
                    for(String str : accountDetails) {
                        if(str.contains("@")) {
                            Set<String> details = mailIdToAccount.get(str);
                            details.addAll(account);
                            mailIdToAccount.put(str, details);
                        }
                    }
                    accountDetails.addAll(account);
                    mailIdToAccount.put(mailId, accountDetails);
                }
            }
        }

        for(Map.Entry<String, Set<String>> entry : mailIdToAccount.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        Set<Set<String>> resultSet = new HashSet<>(mailIdToAccount.values());
        List<List<String>> result = new LinkedList<>();
        resultSet.forEach(resultEntry -> result.add(new LinkedList<>(resultEntry)));

        return result;
    }
}
