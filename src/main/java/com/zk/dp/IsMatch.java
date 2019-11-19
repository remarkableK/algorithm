package com.zk.dp;

/**
 * 正则表达式匹配
 */
public class IsMatch {
    /**
     * 递归的写法
     * 如果是 pattern 中有星号起码出现要出现在第二位
     * 解题思路：
     * 1.先验证第一个字符是否相等
     * 2.看第二个字符是否是* ，如果是*号有两种可能，（1）第一个字符相等就递归判断pattern.substring(2)和text是否匹配 (*充当0)
     * （2）firstMatch && 递归判断text.substring(1)和pattern，
     * 3.如果第二字符不是* 就返回 firstMatch&&递归判断text.substring(1)和pattern.substring(1)
     * 还有就是出口就是 pattern为空时text是否为kong
     */
    public boolean recursionSolution(String text, String pattern) {
        if (pattern.isEmpty()) {
            return text.isEmpty();
        }
        boolean firstMatch = (!text.isEmpty()) && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            //以aab 和 a*b为例，存在两种情况
            //1 * = 0 继续匹配 text和pattern.substring(2)
            //2 第一个字符相等 text去掉第一个字符继续和pattern比较 ，*永远不能放在第一个
            return recursionSolution(text, pattern.substring(2)) || (firstMatch && recursionSolution(text.substring(1), pattern));
        } else {
            return firstMatch && recursionSolution(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        IsMatch isMatch = new IsMatch();
        System.out.println(isMatch.match("".toCharArray(), ".*".toCharArray()));
        System.out.println(isMatch.recursionSolution("", ".*"));

    }

    /**
     * 标准dp
     *
     * @param text
     * @param pattern
     * @return
     */
    enum Result {
        TRUE, FALSE;
    }

    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    /**
     * dp
     */
    private boolean dp(int i, int j, String text, String pattern) {
        //如果已经计算过
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        //出口
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean firstMatch = i < text.length() && (text.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '.');
            if ((j + 1) < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = dp(i, j + 2, text, pattern) || (firstMatch && dp(i + 1, j, text, pattern));
            } else {
                ans = firstMatch && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public boolean match(char[] str, char[] pattern) {
        return recursion(str, pattern, 0, 0);
    }

    /**
     * 再写一遍唉
     * @param str
     * @param pattern
     * @param strIndex
     * @param patternIndex
     * @return
     */
    public boolean recursion(char[] str, char[] pattern, int strIndex, int patternIndex) {
        if (patternIndex == pattern.length) {
            return strIndex == str.length;
        }
        boolean firstMatch = (strIndex < str.length) && ((str[strIndex] == pattern[patternIndex]) || pattern[patternIndex] == '.');
        if ((patternIndex + 1 < pattern.length) && pattern[patternIndex + 1] == '*') {
            return (recursion(str, pattern, strIndex, patternIndex + 2) || (firstMatch && recursion(str, pattern, strIndex + 1, patternIndex)));
        } else {
            return firstMatch && recursion(str, pattern, strIndex + 1, patternIndex + 1);
        }

    }
}
