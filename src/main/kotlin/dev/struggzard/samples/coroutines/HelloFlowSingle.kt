package dev.struggzard.samples.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        getNumbers().single().forEach { number ->
            println(number)
        }
    }

    Thread.sleep(1000)
}

fun getNumbers(): Flow<List<Int>> {
    return flowOf(listOf(1, 2, 3, 4, 5))
}
