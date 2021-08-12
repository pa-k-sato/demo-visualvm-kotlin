package net.pa.demo.visualvm

import net.pa.demo.visualvm.some.SomeService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

private const val TARGET_OPTION_NAME = "target"
private const val LIST_PROFILING = "list"
private const val SEQUENCE_PROFILING = "sequence"

@SpringBootApplication
class Application(
    private val applicationArguments: ApplicationArguments,
    private val service: SomeService
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        println(applicationArguments.optionNames)
        println(applicationArguments.getOptionValues(TARGET_OPTION_NAME))
        when (applicationArguments.getOptionValues(TARGET_OPTION_NAME)[0]) {
            LIST_PROFILING -> service.doAsList()
            SEQUENCE_PROFILING -> service.doAsSequence()
        }
    }
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
