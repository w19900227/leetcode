package leetcode.temp.LeetCode.tree.retest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class _705_DesignHashSet {

    private final Test test = new MyHashSet2();

    @org.junit.jupiter.api.Test
    void a() {
        BigDecimal a1 = BigDecimal.valueOf(10);
        BigDecimal a2 = BigDecimal.valueOf(100);
        BigDecimal add = a1.add(a2);
        System.out.println();
    }

    @org.junit.jupiter.api.Test
    public void t() {
//        int n = 0;
//        int hash = 123456;
//        int r = (n - 221) & hash;
//        System.out.println(r + "," + (hash - 221));

//        int length = 16;
//        for (int i = 0; i <= 100; i++) {
//            System.out.println("i - " + i + ", length - " + length + ", result - " + ((length - 1) & i));
//        }
        int length = 16;
        HashSet map = new HashSet(length);
        for (int i = length; i <= 100; i++) {
            if ((i % length) == 0) {
                map.add(i);
            }
            if (i==48) {
                map.add(0);
            }
            if (i==49) {
                map.add(11);
            }
            if (i==50) {
                map.add(1);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void test2() {
//        int h = 0;
//        Object key = 1000;
//        int r = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
//        System.out.println(key.hashCode());
//        System.out.println(h >>> 16);
//        System.out.println(h);
//        System.out.println(r);
        System.out.println(Integer.toBinaryString(0));
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println("000000000000000000000000000000" + Integer.toBinaryString(1));
        System.out.println("00000000000000000000000000000" + Integer.toBinaryString(2));
        System.out.println("000000000000000000000000000" + Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        int a = -10;
        System.out.println("=======");
        System.out.println(Integer.toBinaryString(a >>> 0));
        System.out.println(Integer.toBinaryString(a >>> 1));
        System.out.println(Integer.toBinaryString(a >>> 2));
        System.out.println(Integer.toBinaryString(a >>> 3));
        System.out.println(Integer.toBinaryString(a >>> 4));
        System.out.println(Integer.toBinaryString(a >>> 16));
//        a = -10;
        int max = Integer.MAX_VALUE;
        System.out.println("MAX-" + max);
//        long a = -1_000_000;
//        System.out.println(a);
//        System.out.println(a << 1);
//        System.out.println(a >> 1);
//        System.out.println("=======");
//        System.out.println(a << 1);
//        System.out.println(a << 2);
//        System.out.println(a << 3);
//        System.out.println(a << 4);
//        System.out.println(a << 16);
        System.out.println("=======");
        System.out.println(a >>> 1);
        System.out.println(a >>> 2);
        System.out.println(a >>> 3);
        System.out.println(a >>> 4);
        System.out.println(a >>> 16);
        System.out.println("=======");
        System.out.println(max >>> 1);
        System.out.println(max >>> 2);
        System.out.println(max >>> 3);
        System.out.println(max >>> 4);
        System.out.println(max >>> 16);
    }

    @org.junit.jupiter.api.Test
    void ttttt() {
        Integer[] integers = new Integer[16];
        integers[1] = 1;
        integers[5] = 5;
        integers[16] = 16;
        System.out.println();
    }

    @ParameterizedTest
    @MethodSource("source")
    void test() {
        System.out.println((15 & 61) + "," + Integer.toBinaryString(15 >> 61));
        System.out.println((15 & 62) + "," + Integer.toBinaryString(15 >> 62));
        System.out.println((15 & 63) + "," + Integer.toBinaryString(15 >> 63));
        System.out.println((15 & 100) + "," + Integer.toBinaryString(15 >> 100));
//        test.add(17);
        test.add(1);
        test.add(2);
        test.add(33);
        test.add(49);
//        test.add(1);
//        test.add(2);
//        test.add(16);
//        test.add(17);
//        test.add(18);
//        test.add(32);
//        test.add(33);
//        test.add(34);
//        test.add(36);
//        test.add(64);
//        test.add(65);
//        test.add(68);
//        test.add(100);

//        System.out.println(16+","+test.contains(16));
//        System.out.println(17+","+test.contains(17));
//        System.out.println(32+","+test.contains(32));
//        System.out.println(33+","+test.contains(33));
//        System.out.println(34+","+test.contains(34));
//        System.out.println(64+","+test.contains(64));
//        System.out.println(65+","+test.contains(65));
//        System.out.println(100+","+test.contains(100));
        for (int i = 65; 2 < i; i--) {
            if (i == 64) {
                System.out.println(64);
            }
            if (i == 14) {
                System.out.println(32);
            }
            test.add(i);
        }
//        test.add(17);
//        test.add(50);
//        boolean r1 = test.contains(1);
//        Assert.assertEquals(true, r1);
//
//        boolean r2 = test.contains(3);
//        Assert.assertEquals(false, r2);
//
//        test.add(2);
//
//        boolean r3 = test.contains(2);
//        Assert.assertEquals(true, r3);
//
//        test.remove(2);
//
//        boolean r4 = test.contains(2);
//        Assert.assertEquals(false, r4);
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                arguments(
                )
        );
    }

    interface Test<T> {

        void add(T key);

        void remove(T key);

        boolean contains(T key);

    }

    class MyHashSet2<T> implements Test<T> {

        private Object[] table;
        private static final int ARRAY_INIT_SIZE = 16;
        private Integer MAX_SIZE = Integer.MAX_VALUE;
        private int size;

        public MyHashSet2() {
        }

        public void add(T key) {
            if (table == null) {
                resize();
            }
            table[key.hashCode()] = key;
            if (size++ >= table.length) {
                resize();
            }
        }

        public void remove(T key) {
            table[key.hashCode()] = null;
        }

        public boolean contains(T key) {
            return table[key.hashCode()] != null ? true : false;
        }

        public void resize() {
//            new HashSet<>()
            Object[] oldTable = table, newTable = null;
            int oldCap = (oldTable.length == 0) ? ARRAY_INIT_SIZE : oldTable.length;
            int newCap = 0;
            if ((newCap = oldCap << 1) < MAX_SIZE) {

            }
            newTable = new Object[newCap];
            for (int i = 0; i < oldTable.length; i++) {
                if (oldTable[i] != null) newTable[i] = oldTable[i];
            }
            table = newTable;
        }
    }
//    class MyHashSet<T> implements Test {
//
//        private MyHashSet<T> store;
//
//        public MyHashSet() {
//            store = new MyHashSet<>();
//        }
//
//        public void add(int key) {
//            store.add(key);
//        }
//
//        public void remove(int key) {
//            store.remove(key);
//        }
//
//        public boolean contains(int key) {
//            return store.contains(key);
//        }
//    }

    public static class Node<T> {
        private T key;

        public void add(T t) {

        }
    }
}