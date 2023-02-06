package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _96_UniqueBinarySearchTrees {

    @ParameterizedTest
    @MethodSource("source")
    public void test(int n, int expected) {
        int actual = numTrees(n);
        Assert.assertEquals(expected, actual);
    }

    public int numTrees(int n) {
        int[] i = new int[n+1];
        if (n==0 || n==1) i[0] = i[1] = 1;

        return i[n];
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(1, 1),
                arguments(2, 2),
                arguments(3, 5),
                arguments(4, 14),
                arguments(5, 42)
        );
    }
}