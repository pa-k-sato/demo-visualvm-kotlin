package net.pa.demo.visualvm

import net.pa.demo.visualvm.some.SomeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
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
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    override fun run(vararg args: String?) {
        try {
            callProfilingOperation()
        } catch (ex: InvalidArgumentException) {
            logger.error(ex.message)
        }
    }

    private fun callProfilingOperation() {
        if (!applicationArguments.containsOption(TARGET_OPTION_NAME)) throw InvalidArgumentException()

        val targetValues = applicationArguments.getOptionValues(TARGET_OPTION_NAME)
        if (targetValues.size == 0) throw InvalidArgumentException()

        when (targetValues[0]) {
            LIST_PROFILING -> service.doAsList()
            SEQUENCE_PROFILING -> service.doAsSequence()
            else -> throw InvalidArgumentException()
        }
    }
}

// FIXME 例外クラスが usage を持つのか🤔
class InvalidArgumentException(): Throwable() {
    override val message: String
        get() = usage

    private val usage: String = """
        
            usage: `--target=xxx`の形式で引数を指定してください。
            
            xxx: 計測対象
                - $LIST_PROFILING
                - $SEQUENCE_PROFILING
    """.trimIndent()
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
