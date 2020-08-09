package leetcode.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $1541_BalanceParenthesisTest {

    private static final $1541_BalanceParenthesis INSTANCE = new $1541_BalanceParenthesis();

    @Test
    public void test1() {
        final String s = "(()))";
        assertEquals(1, INSTANCE.minInsertions(s));
        assertEquals(1, INSTANCE.minInsertionsSol2(s));
    }

    @Test
    public void test2() {
        final String s = "((";
        assertEquals(4, INSTANCE.minInsertions(s));
        assertEquals(4, INSTANCE.minInsertionsSol2(s));
    }

    @Test
    public void test3() {
        final String s = "())";
        assertEquals(0, INSTANCE.minInsertions(s));
        assertEquals(0, INSTANCE.minInsertionsSol2(s));
    }

    @Test
    public void test4() {
        final String s = "))())(";
        assertEquals(3, INSTANCE.minInsertions(s));
        assertEquals(3, INSTANCE.minInsertionsSol2(s));
    }

    @Test
    public void test5() {
        final String s = "((((((";
        assertEquals(12, INSTANCE.minInsertions(s));
        assertEquals(12, INSTANCE.minInsertionsSol2(s));
    }

    @Test
    public void test6() {
        final String s = ")))))))";
        assertEquals(5, INSTANCE.minInsertions(s));
        assertEquals(5, INSTANCE.minInsertionsSol2(s));
    }

}
