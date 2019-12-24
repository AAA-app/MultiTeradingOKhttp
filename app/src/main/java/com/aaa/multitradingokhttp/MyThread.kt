package com.aaa.multitradingokhttp

import java.lang.Exception

val dogApiThread1 = Threading("DogApi") //Api to thread 0
val iPApiThread2 = Threading("IPApi")  //Api to thread 0
val myJsonServicesThread3 = Threading("MyJsonServices") //Api to thread 0


class Threading(): Thread() {
    var ThreadName: String = ""

    constructor(ThreadName: String): this() {
        this.ThreadName = ThreadName
        println(this.ThreadName + " is started")
    }
    override fun run() {
        //Write Thread
        var count = 0
        while (count < 5) {
            println(this.ThreadName + "Count: $count")
            count ++
            try {
                sleep(1000)
            } catch (ex: Exception) {
                println(ex.message)
            }
        }
    }
}