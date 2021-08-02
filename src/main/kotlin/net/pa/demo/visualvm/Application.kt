package net.pa.demo.visualvm

import net.pa.demo.visualvm.some.SomeService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application(
    private val service: SomeService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        service.doWithForLoop()
    }
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
