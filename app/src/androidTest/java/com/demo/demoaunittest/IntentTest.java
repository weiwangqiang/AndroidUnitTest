package com.demo.demoaunittest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashSet;
import java.util.Set;

import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasCategories;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * class description here
 *
 * @author wangqiang
 * @since 2018-05-12
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class IntentTest {
    private static final String PACKAGE_NAME = "com.demo.demoaunittest";
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Before
    public void before(){
        mActivityRule.getActivity();
    }
    @Test
    public void test(){
//        onView(withId(R.id.main_text)).perform(click());
        Set<String> set = new HashSet<>();
//                hasComponent(hasShortClassName(".DisplayMessageActivity")),
//                hasExtra(MainActivity.EXTRA_MESSAGE, "test Intent"),
        set.add("Main");
        intended(allOf(
                hasAction(MainActivity.action),
                hasCategories(set),
                toPackage(PACKAGE_NAME)));
    }
}
