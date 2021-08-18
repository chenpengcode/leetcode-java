package main.java.easy.array.greed.p767;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author CP
 * @Date 2020/11/30
 */
public class Solution {
    public String reorganizeString(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] count = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            count[c - 'a']++;
            maxCount = Math.max(maxCount, count[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] ans = new char[length];
        int even = 0, odd = 1;
        int mid = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char)(i + 'a');
            while (count[i] > 0 && count[i] <= mid && odd < length) {
                ans[odd] = c;
                --count[i];
                odd += 2;
            }
            while (count[i] > 0) {
                ans[even] = c;
                --count[i];
                even += 2;
            }
        }
        return new String(ans);
    }

    public String reorganizeString2(String S) {
        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "aaabc";
        String res = solution.reorganizeString2(S);
        System.out.println(res);
    }
}
