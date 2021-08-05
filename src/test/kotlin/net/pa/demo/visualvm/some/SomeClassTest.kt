package net.pa.demo.visualvm.some

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SomeClassTest {
    @Test
    fun testDefaultList() {
        val sut = SomeClass()
        assertEquals(
            listOf(
                "000000000",
                "000000001",
                "000000002",
                "000000003",
                "000000004"
            ),
            sut.list
        )
    }

    @Test
    fun testSpecifiedList() {
        val sut = SomeClass(3)
        assertEquals(
            listOf(
                "000000000",
                "000000001",
                "000000002"
            ),
            sut.list
        )
    }

    @Test
    fun testSomeMethod() {
        val sut = SomeClass()
        assertEquals("test", sut.someMethod())
    }
}