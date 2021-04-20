package string.p28;

/**
 * @Description
 * @Author CP
 * @Date 2021/4/20
 */
public class KMP {
    // 构建前缀表
    public void getPrefixTable(String pattern, int[] prefix, int n) {
        // 第一个字母的前缀长度为0
        prefix[0] = 0;
        // j 表示当前位置的最长公共前后缀长度
        int j = 0;
        // i为下一个要添加的字符
        int i = 1;
        while (i < n) {
            // 如果要需要检测的字符和当前已经存在的字符串的最长公共前后缀的下一个字符相等
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // 最长公共前后缀的长度加1
                ++j;
            } else {
                while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                    j = prefix[j - 1];
                }
            }
            prefix[i] = j;
            ++i;
        }
    }

    public void movePrefixTable(int[] prefix, int n) {
        if (n - 1 >= 0) System.arraycopy(prefix, 0, prefix, 1, n - 1);
        prefix[0] = -1;
    }

    public int kmpSearch(String text, String pattern) {
        int n = pattern.length();
        int[] prefix = new int[n];
        getPrefixTable(pattern, prefix, n);
        movePrefixTable(prefix, n);
        int i = 0, j = 0;
        int m = text.length();
        while (i < m) {
            if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {
                return i - j;
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = prefix[j];
                if (j == -1) {
                    ++i;
                    ++j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String pattern = "ABABCABAA";
        String text = "DABABCABAAAAAAA";
//        int[] prefix = new int[9];
//        int n = 9;
        KMP kmp = new KMP();
//        kmp.getPrefixTable(pattern, prefix, n);
//        kmp.movePrefixTable(prefix, n);
//        for (int i = 0; i < n; i++) {
//            System.out.println(prefix[i]);
//        }
        System.out.println(kmp.kmpSearch(text, pattern));
    }
}
