package leetcode.temp.LeetCode.dp;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class _392_IsSubsequence {

    @Test
    public void test1() {
        String s = "abc";
        String t = "ahbgdc";
        assertIsSubsequence(s, t, true);
    }

    @Test
    public void test2() {
        String s = "axc";
        String t = "ahbgdc";
        assertIsSubsequence(s, t, false);
    }

    @Test
    public void test3() {
        String s = "hbc";
        String t = "ahbgdc";
        assertIsSubsequence(s, t, true);
    }

    @Test
    public void test4() {
        String s = "";
        String t = "ahbgdc";
        assertIsSubsequence(s, t, true);
    }

    @Test
    public void test5() {
        String s = "acb";
        String t = "ahbgdc";
        assertIsSubsequence(s, t, false);
    }

    private void assertIsSubsequence(String s, String t, boolean expected) {
        boolean actual = isSubsequence(s, t);
        Assert.assertEquals(expected, actual);
    }

    //    public boolean isSubsequence(String s, String t) {
//        if (s.length() == 0) return true;
//        int index = 0;
//        for (char tt : t.toCharArray()) {
//            if (tt == s.charAt(index) && s.length() == ++index) return true;
//        }
//        return false;
//    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int index = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(index) && s.length() == ++index) return true;
        }
        return false;
    }
}