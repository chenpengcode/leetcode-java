package main.java.easy.string.p28;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/20
 */
class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n == 0) return 0;
        if (n > m) return -1;
        int i = 0, j = 0;
        while ( i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                int x = i, y = j;
                boolean flag = true;
                while (x < m && y < n) {
                    if (haystack.charAt(x) != needle.charAt(y)) {
                        flag = false;
                        break;
                    }
                    ++x;
                    ++y;
                }
                if (flag && y == n) return i;
            }
            ++i;
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "isspi";
        Solution solution = new Solution();
        System.out.println(solution.strStr(haystack, needle));
    }
}