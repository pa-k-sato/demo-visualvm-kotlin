package net.pa.demo.visualvm.some

class SomeClass(listSize: Int = 5) {
    val list = (0 until listSize).map { it.toString().padStart(9, '0') }
    val sequence = list.asSequence()

    fun someMethod() = "test"
}

class SomeSequenceClass(size: Int = 5) {
    private var counter = size

    val sequence = generateSequence {
        (counter--).takeIf { it > 0 }
    }.map {it.toString().padStart(9, '0')
    }

    fun someMethod() = "test"
}
