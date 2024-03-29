package main.java.easy.string.p242;

import java.util.HashMap;

/**
 * @Description
 * @Author ChenPeng
 * @Date 2020-11-22 22:20
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> table = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            table.put(ch, table.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            table.put(ch, table.getOrDefault(ch,0) - 1);
            if (table.get(ch) < 0) {
                return false;
            }
        }
        return true;
    }
}
