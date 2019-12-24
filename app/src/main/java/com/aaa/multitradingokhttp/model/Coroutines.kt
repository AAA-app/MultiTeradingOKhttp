package com.aaa.multitradingokhttp.model

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val job1 = GlobalScope.launch {
    println("${Thread.currentThread()} DogApi is started .")
}

val job2 = GlobalScope.launch {
    println("${Thread.currentThread()} IPApi is started.")
}
val job3 = GlobalScope.launch {
    println("${Thread.currentThread()} MyJsonServices is started.")
}