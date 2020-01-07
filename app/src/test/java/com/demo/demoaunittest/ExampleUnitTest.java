package com.demo.demoaunittest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    @Before
    public void before() {
        //在测试前的工作
    }

    @After
    public void after() {
        // 测试完成后的工作
    }

    @Test
    public void addition_isCorrect() {
        //主要工作
    }
}