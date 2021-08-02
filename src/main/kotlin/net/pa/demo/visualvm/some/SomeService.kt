package net.pa.demo.visualvm.some

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

private const val LOOP_COUNT = 9_999_999

@Service
class SomeService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun doWithForLoop() {
        val cls = SomeClass(LOOP_COUNT)
        logger.info("initialized!")

        val after = cls.collection.map {
            cls.someMethod(it)
        }

        logger.info("Done! ( %,d count)".format(after.size))
    }
}