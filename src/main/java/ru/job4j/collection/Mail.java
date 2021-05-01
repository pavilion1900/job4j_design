package ru.job4j.collection;

import java.util.*;

public class Mail {
    private Map<String, String> tempMap = new LinkedHashMap<>();
    private Map<String, Set<String>> map = new LinkedHashMap<>();

    public Map<String, Set<String>> checkMails(Map<String, Set<String>> personInfo) {
        for (String user : personInfo.keySet()) {
            Set<String> tempSet = new HashSet<>(tempMap.keySet());
            int size = tempSet.size();
            tempSet.addAll(personInfo.get(user));
            String correctUser = user;
            if (size + personInfo.get(user).size() != tempSet.size()) {
                List<String> mailList = new ArrayList<>(tempMap.keySet());
                mailList.retainAll(personInfo.get(user));
                String firstEmail = mailList.get(0);
                correctUser = tempMap.get(firstEmail);
            }
            for (String email : personInfo.get(user)) {
                tempMap.put(email, correctUser);
            }
        }
        for (String email : tempMap.keySet()) {
            Set<String> emails = new LinkedHashSet<>();
            if (map.containsKey(tempMap.get(email))) {
                emails = map.get(tempMap.get(email));
            }
            emails.add(email);
            map.put(tempMap.get(email), emails);
        }
        return map;
    }
}