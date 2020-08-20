package com.example.democollect;

import android.content.Context;
import android.util.Log;

import com.example.democollect.data.DataBean;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    private static final String TAG = "ExampleInstrumentedTest";
    DataBean data = new DataBean();
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.democollect", appContext.getPackageName());
    }

    @Test
    public void testDataBean(){
        assertEquals(data.add(2,2), 4);
        Log.d(TAG, "addition_isCorrect: " + "YES");
        assertEquals(data.add(3,2), 5);
        Log.d(TAG, "addition_isCorrect: " + "YES");
        assertEquals(data.add(2,7), 9);
        Log.d(TAG, "addition_isCorrect: " + "YES");
        assertEquals(data.add(1,8), 9);
        Log.d(TAG, "addition_isCorrect: " + "YES");
    }
}
