package net.pa.demo.visualvm.some

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

private const val LOOP_COUNT = 9_999_999

@Service
class SomeService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun doAsList() {
        val cls = SomeClass(LOOP_COUNT)
        logger.info("initialized!")

        val after = cls.list.map {
            it.plus(cls.someMethod())
        }

        logger.info("Done! map loop")
        logger.info("Done! ( %,d count)".format(after.size))
    }

    fun doAsSequence() {
        val cls = SomeClass(LOOP_COUNT)
        logger.info("initialized!")

        val after = cls.sequence.map {
            it.plus(cls.someMethod())
        }

        logger.info("Done! map loop")
        logger.info("Done! ( %,d count)".format(after.toList().size))
    }
}