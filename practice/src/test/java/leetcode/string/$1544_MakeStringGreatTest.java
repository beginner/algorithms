package leetcode.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class $1544_MakeStringGreatTest {

    private static final $1544_MakeStringGreat INSTANCE = new $1544_MakeStringGreat();

    @Test
    public void test1() {
        String s = "leEeetcode";
        assertEquals("leetcode", INSTANCE.makeGood(s));
    }

    @Test
    public void test2() {
        String s = "abBAcC";
        assertEquals("", INSTANCE.makeGood(s));
    }



}
