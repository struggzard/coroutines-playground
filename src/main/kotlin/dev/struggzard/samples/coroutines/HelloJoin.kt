package dev.struggzard.samples.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Here runBlocking used for demo purpose only (due short lifespan of application).
// However, runBlocking is good fit for writing coroutine functions tests.
fun main() = runBlocking {

    val job = GlobalScope.launch {
        delay(1000)
        println("World!")
    }

    print("Hello, ")
    job.join()
}
