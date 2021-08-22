package dev.struggzard.samples.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

val numbersFlow = flowOf(1, 2, 3).onEach { delay(100) }
val lettersFlow =  flowOf("A", "B", "C", "D").onEach { delay(150) }

fun main() = runBlocking {

    val job = GlobalScope.launch {
        numbersFlow.combine(lettersFlow) { number, letter ->
            "${number}_${letter}"
        }.collect {
            println(it)
        }
    }

    Thread.sleep(1000)
    job.cancelAndJoin()
}
