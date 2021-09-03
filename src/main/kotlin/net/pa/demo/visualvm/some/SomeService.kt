package net.pa.demo.visualvm.some

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

private const val LOOP_COUNT = 9_999_999

@Service
class SomeService {
    val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    fun doAsList() {
        waitAMinute()

        val cls = SomeClass(LOOP_COUNT)
        logger.info("initialized! with list")

        val after = cls.list.map {
            it.plus(cls.someMethod())
        }

        logger.info("Done! map loop")
        logger.info("Done! ( %,d count)".format(after.size))
    }

    fun doAsSequence() {
        waitAMinute()

        val cls = SomeSequenceClass(LOOP_COUNT)
        logger.info("initialized! with sequence")

        val after = cls.sequence.map {
            it.plus(cls.someMethod())
        }

        logger.info("Done! map loop")
        logger.info("Done! ( %,d count)".format(after.toList().size))
    }

    private fun waitAMinute() {
        val setting = WaitSetting()

        for (i in setting.range) {
            println(i.toRemindMessage())
            setting.intervalWait()
        }

        logger.info("start!")
    }

    val messageTemplate = "今のうちにVisualVMを起動してこのプロセスをクリック（あと%s秒）"
    private fun Int.toRemindMessage(): String = messageTemplate.format(this.millToSecond().toString())
    private fun Int.millToSecond(): Int = (this / 1000)

    private class WaitSetting(
        val interval: Int = 5_000,
        remindCount: Int = 3
    ) {
        val start: Int = remindCount * interval
        val range = start downTo interval step interval

        fun intervalWait() {
            Thread.sleep(interval.toLong())
        }
    }
}