package net.pa.demo.visualvm.some

class SomeClass(listSize: Int = 5) {
    val list = (0 until listSize).map { it.toString().padStart(9, '0') }
    val sequence = list.asSequence()

    fun someMethod() = "test"
}