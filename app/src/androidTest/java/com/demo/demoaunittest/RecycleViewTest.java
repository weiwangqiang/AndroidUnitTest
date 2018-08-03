package com.demo.demoaunittest;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecycleViewTest {
    private static final String TAG = "ExampleInstrumentedTest";
    @Rule
    public ActivityTestRule<RecyclerActivity> mActivityRule = new ActivityTestRule<>(
            RecyclerActivity.class);

    @Before
    public void init() {
        mActivityRule.getActivity();
    }

    @Test
    public void Run() {
        onView(ViewMatchers.withId(R.id.recycler_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(10, click()));

    }
}
