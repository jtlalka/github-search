package net.tlalka.github.search

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun checksApplicationPackage() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        assertEquals("net.tlalka.github.search", appContext.packageName)
    }
}
