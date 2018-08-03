package com.demo.demoaunittest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * class description here
 *
 * @author wangqiang
 * @since 2018-06-19
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void init() {
        mActivityRule.getActivity();
    }

    @Test
    public void Run() {
        onView(allOf(withId(R.id.main_text), withText("Hello MainActivity!")));
        onView(withId(R.id.main_text)).perform(
                replaceText("Hello MainActivity!"), closeSoftKeyboard());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
