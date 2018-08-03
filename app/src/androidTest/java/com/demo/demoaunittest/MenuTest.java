package com.demo.demoaunittest;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openContextualActionModeOverflowMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * class description here
 *
 * @author wangqiang
 * @since 2018-07-15
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MenuTest {
    @Rule
    public ActivityTestRule<MenuActivity> mActivityRule = new ActivityTestRule<>(
            MenuActivity.class);
    @Test
    public void test(){

        //打开menu
        openContextualActionModeOverflowMenu();
        //模拟点击item2
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
        onView(withText("item2"))
                .perform(click());
        try{
            Thread.sleep(500);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
