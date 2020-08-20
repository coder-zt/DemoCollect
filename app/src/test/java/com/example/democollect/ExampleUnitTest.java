package com.example.democollect;

import android.util.Log;

import com.example.democollect.data.DataBean;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.lang.System.out;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private static final String TAG = "ExampleUnitTest";
    DataBean data = new DataBean();

    @Before
    public void pre_handle(){
        System.out.println("测试前的准备。。。。");
    }

    @Test
    public void addition_isCorrect() {
        System.out.println("addition_isCorrect： 现在开始测试。。。");
        assertEquals(data.multiply(3,2), 6);
        assertEquals(data.multiply(3,3), 9);
        assertEquals(data.multiply(3,5), 15);
        assertEquals(data.multiply(9,2), 18);
        assertEquals(data.multiply(4,3), 12);
        System.out.println("addition_isCorrect： 该单元测试测试结束。。。");
    }

    @Test
    public void add() {
        System.out.println("add: 现在开始测试。。。");
        assertEquals(data.add(2,2), 4);
        System.out.println("add: 该单元测试测试结束。。。");
    }

    @After
    public void afterHandle(){
        System.out.println("测试后的处理。。。");
    }
}