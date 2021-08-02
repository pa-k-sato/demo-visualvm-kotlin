package net.pa.demo.visualvm.some

class SomeClass(listSize: Int = 5) : SomeInterface {
    override val collection: Collection<String>  = (0 until listSize).map { it.toString().padStart(9, '0') }

    override fun someMethod(args: String) = "$args test"
}