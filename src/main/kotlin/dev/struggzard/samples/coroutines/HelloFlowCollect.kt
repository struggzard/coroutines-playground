package dev.struggzard.samples.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

val currentNumberFlow = MutableStateFlow<Int>(0)

fun main() = runBlocking {

    // observe values
    val job = GlobalScope.launch {
        currentNumberFlow.collect {
            println(it)
        }
    }

    // change values
    for (i in 0..5) {
        delay(100)
        generateRandomNumber()
    }

    Thread.sleep(1000)
    job.cancelAndJoin()
}

fun generateRandomNumber() {
    currentNumberFlow.value = (Math.random() * 100).toInt()
}
