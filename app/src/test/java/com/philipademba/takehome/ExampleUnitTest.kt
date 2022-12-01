package com.philipademba.takehome

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.core.app.ActivityScenario
import com.philipademba.takehome.presentation.ui.main.MainActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog

@Config(instrumentedPackages = ["androidx.loader.content"])
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    @Throws(Exception::class)
    fun setUp() {
        ShadowLog.stream = System.out
    }

    @Test fun `Check if the page loads` () {
        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity { activity: MainActivity ->
                    composeTestRule
                        .onNodeWithTag("Discover Movies").assertIsDisplayed()

                    activity.recreate()

                    composeTestRule
                        .onNodeWithTag("Discover Movies").assertIsDisplayed()
                }
            }
    }

    @Test fun `Check if navigation page works` () {
        ActivityScenario.launch(MainActivity::class.java)
            .use { scenario ->
                scenario.onActivity { activity: MainActivity ->
                    composeTestRule
                        .onNodeWithTag("Discover Movies").assertIsDisplayed()

                    activity.recreate()

                    composeTestRule
                        .onNodeWithTag("Discover Movies").assertIsDisplayed()
                }
            }
    }
}