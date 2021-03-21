package dev.struggzard.samples.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        delay(1000) // end-result same as Thread.sleep, but does not block any threads
        println("World!")
    }

    print("Hello, ")
    Thread.sleep(1500) // wait for second and half
}