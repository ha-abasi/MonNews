package ir.hamedabasi.android.kotlin.compose.monews

import ir.hamedabasi.android.kotlin.compose.monews.retrofit.RetrofitInstance
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import kotlin.coroutines.coroutineContext

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val api = RetrofitInstance.api

        println("Testing Api ..")

        runBlocking {
            val nl = api.getNewsList("us", ApiKey.apiKey)

            println(nl.status)

            assertEquals("ok", nl.status)
            assertTrue(nl.totalResults > 0)
        }


        assertEquals(4, 2 + 2)
    }
}