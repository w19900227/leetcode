package leetcode.temp.LeetCode.tree;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _1656_DesignAnOrderedStream {

    private final OrderedStream test = new OrderedStream(5);

//    interface Test {
//        List<String> insert(int idKey, String value);
//    }

    public static class OrderedStream2 {

        private String[] stringList;
        private int start;

        public OrderedStream2(int n) {
            stringList = new String[n + 1];
            start = 0;
        }

        public List<String> insert(int idKey, String value) {
            stringList[idKey - 1] = value;
            List<String> result = new ArrayList();
            while (stringList[start] != null) {
                result.add(stringList[start++]);
            }
            return result;
        }
    }

    public static class OrderedStream {

        private String[] stringList;
        
        /**
         * 一開始宣告會影響效能，可以把初始值放到建構方法中建立
         * @see OrderedStream2#OrderedStream2(int) 
         */
        private int start = 0;

        public OrderedStream(int n) {
            stringList = new String[n + 1];
        }

        public List<String> insert(int idKey, String value) {
            stringList[idKey - 1] = value;
            List<String> result = new ArrayList();
            while (stringList[start] != null) {
                result.add(stringList[start++]);
            }
            return result;
        }
    }

    @Test
    public void test2() {
        OrderedStream2 orderedStream = new OrderedStream2(5);
        List<String> r1 = orderedStream.insert(3, "ccccc");
        Assert.assertEquals(Arrays.asList(), r1);

        List<String> r2 = orderedStream.insert(1, "aaaaa");
        Assert.assertEquals(Arrays.asList("aaaaa"), r2);

        List<String> r3 = orderedStream.insert(2, "bbbbb");
        Assert.assertEquals(Arrays.asList("bbbbb", "ccccc"), r3);

        List<String> r4 = orderedStream.insert(5, "eeeee");
        Assert.assertEquals(Arrays.asList(), r4);

        List<String> r5 = orderedStream.insert(4, "ddddd");
        Assert.assertEquals(Arrays.asList("ddddd", "eeeee"), r5);
    }
//    @ParameterizedTest
//    @MethodSource("source")
//    void test(TreeNode root, TreeNode p, TreeNode q, TreeNode expectedNode) {
//        TreeNode actual = test.lowestCommonAncestor(root, p, q);
//        Assert.assertEquals(expectedNode.val, actual.val);
//    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(new OrderedStream(5),
                        new LinkedHashMap<Integer, String>() {{
                            put(3, "ccccc");
                            put(1, "aaaaa");
                            put(2, "bbbbb");
                            put(5, "eeeee");
                            put(4, "ddddd");
                        }},
                        new LinkedHashMap<Integer, List<String>>() {{
                            put(0, Arrays.asList());
                            put(1, Arrays.asList("aaaaa"));
                            put(2, Arrays.asList("bbbbb", "ccccc"));
                            put(3, Arrays.asList());
                            put(4, Arrays.asList("ddddd", "eeeee"));
                        }}
                )
        );
    }

}