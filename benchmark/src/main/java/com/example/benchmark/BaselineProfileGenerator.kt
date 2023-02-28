package com.example.benchmark

import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalBaselineProfilesApi::class)
class BaselineProfileGenerator {
    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun generateBaselineProfile() = baselineProfileRule.collectBaselineProfile(
        packageName = "com.example.composevsview",
        profileBlock = {
            startActivityAndWait()

            val menuItem = device.findObject(
                By.res(packageName, "navigation_compose")
            )
            menuItem.click()

            val navHost = device.findObject(
                By.res(packageName, "nav_host_fragment_activity_main")
            )
            repeat(10) { navHost.fling(Direction.DOWN) }
        }
    )
}