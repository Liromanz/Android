package com.example.pract2_visual

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import kotlinx.android.synthetic.main.activity_main.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<MainActivity>(
        MainActivity::class.java
    )

    private  val aName = "Bulka"

    @Test
    fun testUserInputScenarial(){
        Espresso.onView(withId(activityRule.activity.editTxt.id)).perform(typeText(aName))
        Espresso.closeSoftKeyboard()
        Espresso.onView(withId(activityRule.activity.txtView.id)).perform(click())
    }

    @Test
    fun test_navSecondaryActivity(){
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(activityRule.activity.textbtn.id)).perform(click())
    }
}