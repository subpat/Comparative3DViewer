package com.subhadeep.AndroidApp.view;

import com.subhadeep.AndroidApp.R;

import org.junit.Before;
import org.junit.Test;

import androidx.test.core.app.ActivityScenario;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class Activity2_SettingsTest {

    ActivityScenario<Activity2_Settings> activityScenario;

    @Before
    public void setUp() {
        activityScenario = ActivityScenario.launch(Activity2_Settings.class);
    }

    @Test
    public void buttonIsVisible() {
        onView(withId(R.id.button_go)).check(matches(isDisplayed()));
    }

    @Test
    public void numberOfModelsOptionIsVisible() {
        onView(withId(R.id.NumFilesTag)).check(matches(isDisplayed()));
        onView(withId(R.id.NumFiles)).check(matches(isDisplayed()));
    }

    @Test
    public void windowModeOptionIsVisible() {
        onView(withId(R.id.ModeTag)).check(matches(isDisplayed()));
        onView(withId(R.id.Mode)).check(matches(isDisplayed()));
    }

    @Test
    public void backgroundOneColorOptionsAreVisible() {
        onView(withId(R.id.background1)).check(matches(isDisplayed()));
        onView(withId(R.id.background_one_color_group)).check(matches(isDisplayed()));
        onView(withId(R.id.background_one_color)).check(matches(isDisplayed()));
    }

    @Test
    public void backgroundTwoColorOptionsAreVisible() {
        onView(withId(R.id.background2)).check(matches(isDisplayed()));
        onView(withId(R.id.background_two_color_group)).check(matches(isDisplayed()));
        onView(withId(R.id.background_two_color)).check(matches(isDisplayed()));
    }

    @Test
    public void ThreeDModelOneOptionsAreVisible() {
        onView(withId(R.id.FileOneTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneName)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOnePosTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOnePos)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneOpacityTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneOpacity)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneColorTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneColorGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.FileOneColor)).check(matches(isDisplayed()));
    }

    @Test
    public void ThreeDModelTwoOptionsAreVisible() {
        onView(withId(R.id.FileTwoTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoName)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoPosTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoPos)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoOpacityTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoOpacity)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoColorTag)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoColorGroup)).check(matches(isDisplayed()));
        onView(withId(R.id.FileTwoColor)).check(matches(isDisplayed()));
    }

}