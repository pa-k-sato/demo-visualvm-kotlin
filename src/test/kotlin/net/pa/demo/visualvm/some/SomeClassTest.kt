package net.pa.demo.visualvm.some

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SomeClassTest {
    @Test
    fun testSomeMethod() {
        val sut = SomeClass()
        assertEquals("test", sut.someMethod())
    }
}