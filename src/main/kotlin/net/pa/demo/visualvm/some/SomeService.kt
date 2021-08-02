package net.pa.demo.visualvm.some

import org.springframework.stereotype.Service

private const val LOOP_COUNT = 9_999_999

@Service
class SomeService {
    fun doWithForLoop() {
        val cls = SomeClass(LOOP_COUNT)
        println("initialized!")
    }
}