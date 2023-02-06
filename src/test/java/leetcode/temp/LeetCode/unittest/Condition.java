package leetcode.temp.LeetCode.unittest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class Condition {

    @Test
    void test_11() {
        TestObject testObject = new TestObject();
        Assert.assertTrue(testObject.getObject() == null);
    }

    @Test
    void test1_2() {
        TestObject testObject = new TestObject();
        testObject.object = new TestObject();
        Assert.assertFalse(testObject.getObject() == null);
    }

    @Test
    void test1_3() {
        TestObject testObject = new TestObject();
        testObject.object = new TestObject();
        Assert.assertTrue(testObject.getObject().getObject() == null);
    }

    @Test
    void test2_1() {
        TestObject testObject = new TestObject();
        testObject.isObject = true;
        Assert.assertTrue(testObject.isObject);
    }

    @Test
    void test2_2() {
        TestObject testObject = new TestObject();
        testObject.isObject = false;
        Assert.assertFalse(testObject.isObject);
    }

    @Test()
    void test3_1() {
        TestObject testObject = new TestObject();
        try {
            testObject.getObject().getObject();
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }


    @Test()
    void test3_2() {
        TestObject testObject = new TestObject();
        try {
            testObject.getObject().getObject();
        } catch (Exception ex) {
            assertFalse(ex instanceof IllegalArgumentException);
        }
    }

    @Test
    void test4_1() {
        TestObject testObject = new TestObject();
        testObject.isObject = false;
        Assert.assertFalse(testObject.isObject && testObject.getObject().getObject() == null);
    }

    @Test
    void test4_2() {
        TestObject testObject = new TestObject();
        testObject.isObject = true;
        testObject.object = new TestObject();
        Assert.assertTrue(testObject.isObject && testObject.getObject().getObject() == null);
    }

    @Test
    void test4_3() {
        TestObject testObject = new TestObject();
        testObject.isObject = true;
        try {
            Assert.assertFalse(testObject.isObject && testObject.getObject().getObject() != null);
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    void test5_1() {
        TestObject testObject = new TestObject();
        testObject.isObject = false;
        testObject.object = new TestObject();
        Assert.assertFalse(testObject.getObject().getObject() == null && testObject.isObject);
    }

    @Test
    void test5_2() {
        TestObject testObject = new TestObject();
        testObject.isObject = true;
        testObject.object = new TestObject();
        Assert.assertTrue(testObject.getObject().getObject() == null && testObject.isObject);
    }

    @Test
    void test5_3() {
        TestObject testObject = new TestObject();
        testObject.isObject = true;
        try {
            Assert.assertTrue(testObject.getObject().getObject() == null && testObject.isObject);
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    @Test
    void test5_4() {
        TestObject testObject = new TestObject();
        testObject.isObject = false;
        try {
            Assert.assertTrue(testObject.getObject().getObject() == null && testObject.isObject);
        } catch (Exception ex) {
            assertTrue(ex instanceof NullPointerException);
        }
    }

    class TestObject {
        public boolean isObject;
        public TestObject object;

        public TestObject getObject() {
            return object;
        }
    }
}